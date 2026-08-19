package com.mycompany.biblioteca;

import java.time.LocalDate;

public class Loan {
    private String idLoan;
    private Client client;
    private Book book;
    private LocalDate date;
    private String status;

    public Loan(String idLoan, Client client, Book book, LocalDate date, String status) {
        this.idLoan = idLoan;
        this.client = client;
        this.book = book;
        this.date = date;
        this.status = status;
    }

    public String getIdLoan() { return idLoan; }
    public void setIdLoan(String idLoan) { this.idLoan = idLoan; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Loan ID: " + idLoan +
               " | Client: " + client.getName() +
               " | Book: " + book.getTitle() +
               " | Date: " + date +
               " | Status: " + status;
    }
}