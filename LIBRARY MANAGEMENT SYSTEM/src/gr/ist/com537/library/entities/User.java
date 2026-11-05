package gr.ist.com537.library.entities;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private List<Book> borrowedBooks = new ArrayList<>();


    public User(String name, String subName, String email, String password, String address, String phoneNumber) {
        super(name, subName, email, password, address, phoneNumber);
        this.borrowedBooks = borrowedBooks;
    }


    public String printInfo() {

        return "{" + "Name: " + getName() + "\n" +
                "Subname: " + getSubName() + "\n" +
                "email: " + getEmail() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Phone_Number: " + getPhoneNumber() + "\n" +
                "borrowedBooks: " + borrowedBooks +
                '}';
    }

    public void printBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("You do not have borrowed books");
        } else {
            for (int i = 0; i < getBorrowedBooks().size(); i++) {
                System.out.println(i+")"+" " +borrowedBooks.get(i).getTittle()+ "\n");
            }
        }
    }


    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }


    public boolean borrowBook(Book book) {
        if (book.getAvailableCopies() > 0 && getBorrowedBooks().size() < 3 && !checkIfBorrowed(book))
        {
            book.loanBook();
            borrowedBooks.add(book);
        }
        else if (book.getAvailableCopies() ==0)
        {
            System.out.println("You can't borrow this book because book is not available");
        }
        else if (borrowedBooks.size() >= 3)
        {
            System.out.println("You can not borrow more books");
        }
        return false;
    }

    public boolean checkIfBorrowed(Book book) {
        boolean bookBorrowed = false;
        for (int i = 0; i < getBorrowedBooks().size(); i++) {
            if (getBorrowedBooks().get(i) == book) {
                bookBorrowed = true;
            }
        }
        return bookBorrowed;
    }


    public void returnBook(Book book) {
        if (borrowedBooks.size() > 0) {
            book.returnBook();
            borrowedBooks.remove(book);
        }
    }

}