package service;

import model.Persons;

public interface LibraryService {

    public void addRequest(Persons person);

    public void initializeBooks();

    public void processRequests();

    public void assignBook(Persons person, String bookName);

    public void addFirstInFirstOut(Persons person);

    public void processRequestFifo();

    public void assignBooks(Persons person, String bookName);


}
