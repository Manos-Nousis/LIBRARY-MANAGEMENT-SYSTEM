package gr.ist.com537.library.entities;

import java.util.Date;

public class Loan {
    private Book book;
    private User user;
    private Librarian librarian;
    private Date loanDate;
    private int days;
    private Date dueDate;
    private Date returnDate;


    public Loan(Book book, User user, Librarian librarian, Date loanDate, int days, Date dueDate, Date returnDate) {
        this.book = book;
        this.user = user;
        this.librarian = librarian;
        this.loanDate = loanDate;
        this.days = days;
        this.dueDate = dueDate;
        this.returnDate = returnDate;

        this.user.borrowBook(book);
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
