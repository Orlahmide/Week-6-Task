package model;

public class Persons {
    private String bookName;
    private String role;
    private int requestedCopies;

    public Persons(String bookName, String role, int requestedCopies) {
        this.bookName = bookName;
        this.role = role;
        this.requestedCopies = requestedCopies;
    }

    public String getBookName() {
        return bookName;
    }

    public String getRole() {
        return role;
    }

    public int getRequestedCopies() {
        return requestedCopies;
    }

    @Override
    public String toString() {
        return String.format("Persons{name='%s', role='%s', requestedCopies=%d}", bookName, role, requestedCopies);
    }
}
