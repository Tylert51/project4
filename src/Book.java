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


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }


    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + ISBN + "). Copies available for borrowing: " + copies;
    }
}
