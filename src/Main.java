import java.util.ArrayList;
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
                case "1":       // Add Book
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

                case "2":       // Add Member

                    System.out.print("Enter member name : ");
                    String name = sc.nextLine();
                    System.out.println("Member added: " + library.addMember(name));

                    break;

                case "3":       // Search Book

                    System.out.print("""
                            1. Title
                            2. ISBN
                            3. Author
                            Choose an option:\s""");

                    String choiceStr = sc.nextLine();
                    ArrayList<Book> found;

                    switch (choiceStr) {
                        case "1":

                            System.out.print("Enter the book title: ");
                            found = library.searchBook(sc.nextLine().trim().toLowerCase(), 1);
                            if(!found.isEmpty()) {
                                System.out.println("Book found: " + found.get(0));
                            } else {
                                System.out.println("No books with that title currently in the library");
                            }

                            break;

                        case "2":

                            System.out.print("Enter the book ISBN: ");
                            found = library.searchBook(sc.nextLine().trim(), 2);
                            if(!found.isEmpty()) {
                                System.out.println("Book found: " + found.get(0));
                            } else {
                                System.out.println("No books with that ISBN currently in the library");
                            }

                            break;

                        case "3":

                            System.out.print("Enter the author name: ");
                            String authorSearch = sc.nextLine().trim().toLowerCase();
                            found = library.searchBook(authorSearch, 3);
                            if(!found.isEmpty()) {
                                System.out.println("Books by " + authorSearch + ":");
                                for(Book book : found) {
                                    System.out.println(book);
                                }

                            } else {
                                System.out.println("No books with that author currently in the library");
                            }

                            break;

                        default:
                            System.out.println("Invalid choice. Resetting to menu...");
                    }

                    break;

                case "4":       // Issue Book

                    System.out.print("Enter member ID: ");
                    String memID = sc.nextLine().trim().toLowerCase();

                    try {

                        int idNum = Integer.parseInt(memID.substring(1));
                        if (memID.substring(0, 1).equals("m") && idNum <= library.getMembers().size()) {     // makes sure that member actually exists

                            System.out.print("Enter book title to borrow: ");
                            String titleBorrow = sc.nextLine();
                            ArrayList<Book> booksFound = library.searchBook(titleBorrow, 1);
                            Member member = library.getMembers().get(idNum - 1);
                            Book bookBorrow = null;

                            if(booksFound.isEmpty()) {
                                System.out.println("No books with that title currently in the library");
                            } else {
                                bookBorrow = booksFound.get(0);

                                if(member.getBorrowedBooks().contains(bookBorrow)) {

                                    System.out.println(memID + " has already borrowed this book: " + bookBorrow.getTitle() + "\nCould not issue the book.");

                                } else if ( member.borrowBook(bookBorrow) ) {

                                    System.out.println("Book issued: " + bookBorrow.getTitle() + " to " + memID);

                                } else {

                                    System.out.println("This book is currently unavailable. Could not issue the book");

                                }
                            }


                        } else {
                            System.out.println("Member doesn't exist");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid format. Returning to menu...");
                    }

                    break;

                case "5":       // Return Book

                    System.out.print("Enter member ID: ");
                    memID = sc.nextLine().trim().toLowerCase();

                    try {

                        int idNum = Integer.parseInt(memID.substring(1));
                        if (memID.substring(0, 1).equals("m") && idNum <= library.getMembers().size()) {     // makes sure that member actually exists

                            String titleReturn = sc.nextLine();
                            ArrayList<Book> booksFound = library.searchBook(titleReturn, 1);
                            Member member = library.getMembers().get(idNum - 1);
                            Book bookReturn = null;

                            if(booksFound.isEmpty()) {
                                System.out.println("No books with that title currently in the library");
                            } else {
                                bookReturn = booksFound.get(0);

                                if ( !member.getBorrowedBooks().contains(bookReturn) ) {
                                    System.out.println(memID + " has not borrowed this book: " + bookReturn.getTitle());
                                } else {

                                    member.returnBook(bookReturn);
                                    System.out.println("Book returned: " + bookReturn);

                                }

                            }
                        } else {
                            System.out.println("Member doesn't exist");
                        }


                    } catch (NumberFormatException e) {
                        System.out.println("Invalid format. Returning to menu...");
                    }

                    break;

                case "6":       // List Borrowed Books

                    System.out.print("Enter member ID to list borrowed books: " );
                    memID = sc.nextLine().trim().toLowerCase();

                    try {

                        int idNum = Integer.parseInt(memID.substring(1));
                        if (memID.substring(0, 1).equals("m") && idNum <= library.getMembers().size()) {

                            Member member = library.getMembers().get(idNum - 1);
                            System.out.println(memID + " borrowed books: ");
                            for(Book book : member.getBorrowedBooks()) {
                                System.out.println(book.getTitle() + " (ISBN: " + book.getISBN() + ").");
                            }

                        } else {
                            System.out.println("Member doesn't exist");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid format. Returning to menu...");
                    }


                    break;

                case "7":       // Exit
                    break;

                default:
                    System.out.println("Invalid option");

            }
        } while (!ans.equals("7"));

        sc.close();
        System.out.println("Exiting...");

    }
}
