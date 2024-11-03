package service.impl;

import model.Library;
import model.Persons;
import service.LibraryService;

import java.util.Map;
import java.util.Optional;

public class LibraryServiceImpl extends Library implements LibraryService {

    @Override
    public void addRequest(Persons person) {
        getRequestQueue().add(person);
    }

    @Override
    public void initializeBooks() {
        try {
            getLibraryCollection().putAll(Map.of(
                    "Things Fall Apart", 19,
                    "Harry Potter", 13,
                    "Getting Rich", 10,
                    "Being Happy", 9,
                    "Becoming The Best", 28,
                    "Joys of coding", 7
            ));
        } catch (Exception e) {
            System.out.println("Error initializing books: " + e.getMessage());
        }
    }

    @Override
    public void processRequests() {
        getRequestQueue().forEach(person -> assignBook(person, person.getBookName()));
        getRequestQueue().clear();
    }

    @Override
    public void assignBook(Persons person, String bookName) {
        try {
            int requestedCopies = person.getRequestedCopies();
            Optional<Integer> availableCopies = Optional.ofNullable(getLibraryCollection().get(bookName));

            availableCopies.ifPresentOrElse(
                    available -> {
                        if (available >= requestedCopies) {
                            getLibraryCollection().put(bookName, available - requestedCopies);
                            System.out.printf("The %s has been assigned %d copies of the book: %s%n",
                                    person.getRole(), requestedCopies, bookName);
                        } else {
                            System.out.printf("Sorry, %d copies of %s are unavailable for %s%n",
                                    requestedCopies, bookName, person.getRole());
                        }
                    },
                    () -> System.out.printf("Book '%s' is not available in the library collection.%n", bookName)
            );
        } catch (Exception e) {
            System.out.println("Error assigning book: " + e.getMessage());
        }
    }

    @Override
    public void addFirstInFirstOut(Persons person) {
        getFifo().add(person);
    }

    @Override
    public void processRequestFifo() {
        getFifo().forEach(person -> assignBooks(person, person.getBookName()));
        getFifo().clear();
    }

    @Override
    public void assignBooks(Persons person, String bookName) {
        assignBook(person, bookName);
    }
}
