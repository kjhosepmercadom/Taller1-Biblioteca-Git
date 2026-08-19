
package com.mycompany.biblioteca;
/**
 *
 * @author KEVINDDD
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Menu will be added in Phase 8
    }

    static void createClient() {
        System.out.println("=== Create Client ===");
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        Client newClient = new Client(id, name, phone, email);
        clients.add(newClient);
        System.out.println("Client created successfully.");
    }

    static void listClients() {
        System.out.println("=== Client List ===");
        if (clients.isEmpty()) {
            System.out.println("No clients registered.");
            return;
        }
        for (Client c : clients) {
            System.out.println(c);
        }
    }

    static void findClient() {
        System.out.println("=== Find Client ===");
        System.out.print("Enter ID to search: ");
        String id = sc.nextLine();

        for (Client c : clients) {
            if (c.getId().equals(id)) {
                System.out.println("Client found:");
                System.out.println(c);
                return;
            }
        }
        System.out.println("Client not found.");
    }
    static void updateClient() {
    System.out.println("=== Update Client ===");
    System.out.print("Enter ID of the client to update: ");
    String id = sc.nextLine();

    for (Client c : clients) {
        if (c.getId().equals(id)) {
            System.out.print("New name (leave blank to keep current): ");
            String name = sc.nextLine();
            if (!name.isBlank()) {
                c.setName(name);
            }

            System.out.print("New phone (leave blank to keep current): ");
            String phone = sc.nextLine();
            if (!phone.isBlank()) {
                c.setPhone(phone);
            }

            System.out.print("New email (leave blank to keep current): ");
            String email = sc.nextLine();
            if (!email.isBlank()) {
                c.setEmail(email);
            }

            System.out.println("Client updated successfully.");
            return;
        }
    }
    System.out.println("Client not found.");
}
    static void deleteClient() {
    System.out.println("=== Delete Client ===");
    System.out.print("Enter ID of the client to delete: ");
    String id = sc.nextLine();

    for (Client c : clients) {
        if (c.getId().equals(id)) {
            clients.remove(c);
            System.out.println("Client deleted successfully.");
            return;
        }
    }
    System.out.println("Client not found.");
}
    static void createBook() {
    System.out.println("=== Create Book ===");
    System.out.print("Code: ");
    String code = sc.nextLine();
    System.out.print("Title: ");
    String title = sc.nextLine();
    System.out.print("Publication Year: ");
    String publicationYear = sc.nextLine();
    System.out.print("Author: ");
    String author = sc.nextLine();

    Book newBook = new Book(code, title, publicationYear, author);
    books.add(newBook);

    System.out.println("Book created successfully.");
}
    static void listBooks() {
    System.out.println("=== Book List ===");
    if (books.isEmpty()) {
        System.out.println("No books registered.");
        return;
    }
    for (Book b : books) {
        System.out.println(b);
    }
}
    static void findBook() {
    System.out.println("=== Find Book ===");
    System.out.print("Enter code to search: ");
    String code = sc.nextLine();

    for (Book b : books) {
        if (b.getCode().equals(code)) {
            System.out.println("Book found:");
            System.out.println(b);
            return;
        }
    }
    System.out.println("Book not found.");
}
    static void updateBook() {
    System.out.println("=== Update Book ===");
    System.out.print("Enter code of the book to update: ");
    String code = sc.nextLine();

    for (Book b : books) {
        if (b.getCode().equals(code)) {
            System.out.print("New title (leave blank to keep current): ");
            String title = sc.nextLine();
            if (!title.isBlank()) {
                b.setTitle(title);
            }

            System.out.print("New publication year (leave blank to keep current): ");
            String year = sc.nextLine();
            if (!year.isBlank()) {
                b.setPublicationYear(year);
            }

            System.out.print("New author (leave blank to keep current): ");
            String author = sc.nextLine();
            if (!author.isBlank()) {
                b.setAuthor(author);
            }

            System.out.println("Book updated successfully.");
            return;
        }
    }
    System.out.println("Book not found.");
}
    static void deleteBook() {
    System.out.println("=== Delete Book ===");
    System.out.print("Enter code of the book to delete: ");
    String code = sc.nextLine();

    for (Book b : books) {
        if (b.getCode().equals(code)) {
            books.remove(b);
            System.out.println("Book deleted successfully.");
            return;
        }
    }
    System.out.println("Book not found.");
}
    static void createLoan() {
    System.out.println("=== Create Loan ===");

    System.out.print("Loan ID: ");
    String idLoan = sc.nextLine();

    System.out.print("Client ID: ");
    String clientId = sc.nextLine();
    Client foundClient = null;
    for (Client c : clients) {
        if (c.getId().equals(clientId)) {
            foundClient = c;
            break;
        }
    }
    if (foundClient == null) {
        System.out.println("Client not found. Loan cancelled.");
        return;
    }

    System.out.print("Book code: ");
    String bookCode = sc.nextLine();
    Book foundBook = null;
    for (Book b : books) {
        if (b.getCode().equals(bookCode)) {
            foundBook = b;
            break;
        }
    }
    if (foundBook == null) {
        System.out.println("Book not found. Loan cancelled.");
        return;
    }
    if (!foundBook.isAvailable()) {
        System.out.println("Book is not available. Loan cancelled.");
        return;
    }

    Loan newLoan = new Loan(idLoan, foundClient, foundBook, LocalDate.now(), "ACTIVE");
    loans.add(newLoan);
    foundBook.setAvailable(false);

    System.out.println("Loan registered successfully.");
}
    static void returnLoan() {
    System.out.println("=== Return Loan ===");
    System.out.print("Enter Loan ID to return: ");
    String idLoan = sc.nextLine();

    for (Loan l : loans) {
        if (l.getIdLoan().equals(idLoan) && l.getStatus().equals("ACTIVE")) {
            l.setStatus("RETURNED");
            l.getBook().setAvailable(true);
            System.out.println("Loan returned successfully.");
            return;
        }
    }
    System.out.println("Active loan not found.");
}
    static void listActiveLoans() {
    System.out.println("=== Active Loans ===");
    boolean found = false;

    for (Loan l : loans) {
        if (l.getStatus().equals("ACTIVE")) {
            System.out.println(l);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No active loans.");
    }
}
}
 