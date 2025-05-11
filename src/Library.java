import java.util.HashSet;

public class Library {
    private HashSet<Book> books;
    private HashSet<Member> members;

    public Library() {
        books = new HashSet<>();
        members = new HashSet<>();
    }

    public void addBook(String title, String author, String ISBN, int copies) {
        books.add(new Book(title, author, ISBN, copies));
    }

    public void addMember(String name) {
        members.add(new Member(name));
    }

    public HashSet<Book> searchBook(String search, int choice) {

        HashSet<Book> found = new HashSet<>();

        for(Book book : books) {
            switch (choice) {
                case 1:     // searching title
                    if(book.getTitle().equals(search)) {
                        found.add(book);
                    }
                    break;

                case 2:     // searching ISBN
                    if(book.getISBN().equals(search)) {
                        found.add(book);
                    }
                    break;

                case 3:     // searching author

                    if(book.getAuthor().equals(search)) {
                        found.add(book);
                    }

                    break;
            }
        }

        return found;
    }
}
