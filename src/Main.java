import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Test", "Tyler", "123123", 1);
        Book book2 = new Book("Test2", "Tyler", "123", 2);


        HashSet<Book> map = new HashSet<>();
        System.out.println(map.add(book1));
        System.out.println(map.add(book2));
        System.out.println(map.add(book1));

        System.out.println(map);
    }
}
