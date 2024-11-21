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

// Library class to manage the list of books
class Library {
    private ArrayList<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book '" + title + "' by " + author + " has been added to the library.");
    }

    // Method to display available books in the library
    public void displayBooks() {
        System.out.println("\nAvailable Books in the Library:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        }
    }

    // Method to borrow a book
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

    // Method to return a borrowed book
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

// Main class to run the Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Sample data
        library.addBook("1984", "George Orwell");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");

        // Menu system
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



// import java.util.ArrayList;
// import java.util.Scanner;

// class Book {
//     String title;
//     String author;
//     String ISBN;
//     boolean availability;

//     public Book(String title, String author, String ISBN, boolean availability) {
//         this.title = title;
//         this.author = author;
//         this.ISBN = ISBN;
//         this.availability = availability;
//     }

//     @Override
//     public String toString() {
//         return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN + "\nAvailability: " + availability + "\n";
//     }
// }

// class Library {
//     ArrayList<Book> books;

//     public Library() {
//         books = new ArrayList<>();
//     }

//     public void addBook(Book book) {
//         books.add(book);
//     }

//     public void removeBook(String ISBN) {
//         Book bookToRemove = null;
//         for (Book book : books) {
//             if (book.ISBN.equals(ISBN)) {
//                 bookToRemove = book;
//                 break;
//             }
//         }
//         if (bookToRemove != null) {
//             books.remove(bookToRemove);
//             System.out.println("Book with ISBN " + ISBN + " has been removed.");
//         } else {
//             System.out.println("Book with ISBN " + ISBN + " not found.");
//         }
//     }

//     public void displayBooks() {
//         if (books.isEmpty()) {
//             System.out.println("No books available in the library.");
//         } else {
//             for (Book book : books) {
//                 System.out.println(book);
//             }
//         }
//     }
// }

// public class LibraryManagementSystem {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         Library library = new Library();

//         while (true) {
//             System.out.println("\n1. Add Book");
//             System.out.println("2. Remove Book");
//             System.out.println("3. Display Books");
//             System.out.println("4. Exit");
//             System.out.print("Enter your choice: ");
            
//             int choice = scanner.nextInt();
//             scanner.nextLine(); // To consume the newline character

//             if (choice == 1) {
//                 System.out.print("Enter title: ");
//                 String title = scanner.nextLine();
//                 System.out.print("Enter author: ");
//                 String author = scanner.nextLine();
//                 System.out.print("Enter ISBN: ");
//                 String ISBN = scanner.nextLine();
//                 System.out.print("Enter availability (true for available, false for unavailable): ");
//                 boolean availability = scanner.nextBoolean();
                
//                 library.addBook(new Book(title, author, ISBN, availability));
//                 System.out.println("Book added successfully.");

//             } else if (choice == 2) {
//                 System.out.print("Enter ISBN of the book to remove: ");
//                 String ISBN = scanner.nextLine();
//                 library.removeBook(ISBN);

//             } else if (choice == 3) {
//                 library.displayBooks();

//             } else if (choice == 4) {
//                 System.out.println("Exiting the system.");
//                 break;

//             } else {
//                 System.out.println("Invalid choice. Please try again.");
//             }
//         }

//         scanner.close();
//     }
// }
