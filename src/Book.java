public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int copies;

    public Book(String title, String author, String ISBN, int copies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.copies = copies;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @Override
    public String toString() {
        return title;
    }
}
