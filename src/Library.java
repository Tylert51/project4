import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public boolean addBook(String title, String author, String ISBN, int copies) {

        ArrayList<Book> found = searchBook(ISBN,2);

        if(found.isEmpty()) {
            books.add(new Book(title, author, ISBN, copies));
            return true;
        }

        found.get(0).addCopies(copies);
        return false;
    }

    public Member addMember(String name) {
        Member member = new Member(name);
        members.add(member);

        return member;
    }

    public ArrayList<Book> searchBook(String search, int choice) {

        search = search.toLowerCase();
        ArrayList<Book> found = new ArrayList<>();

        for(Book book : books) {
            switch (choice) {
                case 1:     // searching title
                    if(book.getTitle().toLowerCase().equals(search)) {
                        found.add(book);
                    }
                    break;

                case 2:     // searching ISBN
                    if(book.getISBN().equals(search)) {
                        found.add(book);
                    }
                    break;

                case 3:     // searching author

                    if(book.getAuthor().toLowerCase().equals(search)) {
                        found.add(book);
                    }

                    break;
            }
        }

        return found;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}
