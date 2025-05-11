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
}
