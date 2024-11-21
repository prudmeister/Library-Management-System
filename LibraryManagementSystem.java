import java.util.ArrayList;
import java.util.Scanner;

// Book class representing the book object
class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Method to check if the book is borrowed
    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Method to set the book as borrowed
    public void borrowBook() {
        isBorrowed = true;
    }

    // Method to set the book as returned
    public void returnBook() {
        isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Borrowed: " + isBorrowed;
    }
}

class Library {
    private ArrayList<Book> books;
    
    public Library() {
        books = new ArrayList<>();
    }

    
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book '" + title + "' by " + author + " has been added to the library.");
    }
    public void displayBooks() {
        System.out.println("\nAvailable Books in the Library:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        }
    }
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isBorrowed()) {
                    book.borrowBook();
                    System.out.println("You have successfully borrowed '" + title + "'.");
                } else {
                    System.out.println("The book '" + title + "' is currently borrowed.");
                }
                return;
            }
        }
        System.out.println("The book '" + title + "' does not exist in the library.");
    }
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isBorrowed()) {
                    book.returnBook();
                    System.out.println("You have successfully returned '" + title + "'.");
                } else {
                    System.out.println("The book '" + title + "' was not borrowed.");
                }
                return;
            }
        }
        System.out.println("The book '" + title + "' does not exist in the library.");
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        library.addBook("1984", "George Orwell");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        while (running) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Display Available Books");
            System.out.println("2. Add New Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter the book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;

                case 3:
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;

                case 4:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}


