import java.util.HashSet;

public class Member {

    private static int numMembers = 0;

    private String name;
    private String id;
    private HashSet<Book> borrowedBooks;


    public Member(String name) {
        this.name = name;
        borrowedBooks = new HashSet<>();

        numMembers++;
        id = "m" + numMembers;
    }



    public static int getNumMembers() {
        return numMembers;
    }
}
