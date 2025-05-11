import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        String ans;

        do {

            System.out.print("""
                    ----------------------------------
                    Library Management System
                    1. Add Book
                    2. Add Member
                    3. Search Book
                    4. Issue Book
                    5. Return Book
                    6. List Borrowed Books
                    7. Exit
                    Choose an option:\s"""
            );

            ans = sc.nextLine();

            switch (ans) {
                case "1":
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String ISBN = sc.nextLine();
                    System.out.print("Enter number of copies: ");
                    String copiesStr = sc.nextLine();

                    try {

                        int copies = Integer.parseInt(copiesStr);
                        if ( library.addBook(title, author, ISBN, copies) ) {   // if person entered a new book

                            System.out.println("Book added: " + library.searchBook(ISBN, 2).get(0));

                        } else {        // if book is already updated

                            System.out.println("Book already exists. Updated the number of copies in the library. Copies available for borrowing: " + library.searchBook(ISBN, 2).get(0).getCopies());

                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid format. Please enter a number.\nResetting to menu");
                    }
                    break;

                case "2":
                    break;

                case "3":
                    break;

                case "4":
                    break;

                case "5":
                    break;

                case "6":
                    break;

                case "7":
                    break;

                default:
                    System.out.println("Invalid option");


            }
        } while (!ans.equals("7"));



    }
}
