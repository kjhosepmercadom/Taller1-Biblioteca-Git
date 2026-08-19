
package com.mycompany.biblioteca;
/**
 *
 * @author KEVINDDD
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
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
}
 