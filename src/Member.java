import java.util.ArrayList;

public class Member {

    private static int numMembers = 0;

    private String name;
    private String id;
    private ArrayList<Book> borrowedBooks;


    public Member(String name) {
        this.name = name;
        borrowedBooks = new ArrayList<>();

        numMembers++;
        id = "m" + numMembers;
    }

    public static int getNumMembers() {
        return numMembers;
    }

    public boolean borrowBook(Book borrowed) {
        borrowedBooks.add(borrowed);
        return borrowed.borrow();
    }

    public boolean returnBook(Book returned) {
        borrowedBooks.remove(returned);
        return returned.returnBook();
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String toString() {
        return name + " (Member ID: " + id + ")";
    }
}
