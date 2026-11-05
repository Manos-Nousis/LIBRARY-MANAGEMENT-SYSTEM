package gr.ist.com537.library.entities;

import java.util.ArrayList;

public class Book extends ArrayList<Book> {

    private String tittle;
    private Author author;
    private String genre;
    private String description;
    private int totalCopies;
    private int availableCopies;

    public Book(String tittle, Author author, String genre, String description, int totalCopies, int availableCopies) {
        this.tittle = tittle;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }


    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }


    public void addCopies(int num) {
        totalCopies += num;
        availableCopies += num;
        System.out.println("The available copies are: " + this.getAvailableCopies());
    }

    public void retireCopy() {
        totalCopies--;
    }

    public void loanBook() {
        availableCopies--;
    }

    public void returnBook() {
        availableCopies++;
    }
}
