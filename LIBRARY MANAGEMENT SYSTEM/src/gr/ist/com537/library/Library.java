package gr.ist.com537.library;

import gr.ist.com537.library.entities.*;

import java.util.*;

public class Library {
    private static List<Loan> loans = new ArrayList<>();
    private static List<Book> book = new ArrayList<>();
    private static List<Librarian> staff = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        runningAppForLoggin();
    }

    public static Person runningAppForLoggin() {
        libraryEntities();
        LoginMenu selectMenu = new LoginMenu();
        String personSelection;
        personSelection = selectMenu.runMenu();

        switch (personSelection) {

            case "user":
                int keepUser = 0;
                Scanner authenticator = new Scanner(System.in);
                boolean keepLoggedIn = false;
                while (!keepLoggedIn) {
                    System.out.println("Enter your email: ");
                    String email = authenticator.nextLine();
                    System.out.println("Enter your password: ");
                    String password = authenticator.nextLine();
                    for (int u = 0; u < users.size(); u++) {
                        if (email.equals(users.get(u).getEmail())) {
                            keepUser = u;
                        }
                        keepLoggedIn = true;
                    }
                    if (password.equals(users.get(keepUser).getPassword())) {
                        System.out.println("Welcome " + users.get(keepUser).getName() + " " + users.get(keepUser).getSubName());
                        do {
                            menuUserRun(users.get(keepUser));
                            keepLoggedIn = true;
                        } while (keepLoggedIn);
                    } else {
                        System.err.println("your email or password is wrong please try again");
                    }
                    keepLoggedIn = false;
                }


            case "staff":
                int keepStaff = 0;
                Scanner authenticatorStaff = new Scanner(System.in);
                boolean keepLoggedInStaff = false;

                while (!keepLoggedInStaff) {
                    System.out.println("Enter your email: ");
                    String email = authenticatorStaff.nextLine();
                    System.out.println("Enter your password: ");
                    String password = authenticatorStaff.nextLine();
                    for (int s = 0; s < staff.size(); s++) {
                        if (email.equals(staff.get(s).getEmail())) {
                            keepStaff = s;
                        }
                        keepLoggedInStaff = true;
                    }
                    if (password.equals(staff.get(keepStaff).getPassword())) {
                        System.out.println("Welcome Staff " + staff.get(keepStaff).getName() + " " + staff.get(keepStaff).getSubName());
                        do {
                            librarianMenuRun(staff.get(keepStaff));
                            keepLoggedInStaff = true;
                        } while (keepLoggedInStaff);
                    } else {
                        System.err.println("your email or password is wrong please try again");
                    }
                    keepLoggedInStaff = false;
                }
                break;

            case "exit":
                System.exit(0);
                break;
        }
        return null;
    }

    public static void menuUserRun(User user) {
        UserMenu userMenu = new UserMenu();
        String userSelection;
        userSelection = userMenu.runMenu();

        boolean userChoose = false;

        while (!userChoose) {

            switch (userSelection) {

                case "display":
                    user.printBorrowedBooks();
                    userChoose = true;
                    break;

                case "borrow":
                    int chosseBook = -1;
                    Book books;
                    do {
                        availableBooks();
                        System.out.println("Select the book you want to borrow: ");
                        Scanner bookSelect = new Scanner(System.in);
                        chosseBook = bookSelect.nextInt();
                    } while (chosseBook > book.size());
                    books = book.get(chosseBook);

                    if (!userChoose) {
                        System.out.println("How many days do you want to borrow the book?: ");
                        Scanner daysSelect = new Scanner(System.in);
                        int daysInput = daysSelect.nextInt();
                        userChoose = true;
                 Loan loan = new Loan(books, user, selectLibrarianRandomly(staff), new Date(), daysInput, new Date(daysInput++), new Date());
                   loans.add(loan);
                    }
                    userChoose = true;
                    break;

                case "return":
                    user.printBorrowedBooks();
                    if(!user.getBorrowedBooks().isEmpty())
                    {
                        System.out.println("Select the book you want to return: ");
                        Scanner bookToReturn = new Scanner(System.in);
                        int bookindex = bookToReturn.nextInt();
                        if(bookindex < user.getBorrowedBooks().size())
                        {
                            user.returnBook(user.getBorrowedBooks().get(bookindex));
                        }
                    }
                    userChoose = true;
                    break;

                case "exit":
                    System.exit(0);
                    userChoose = true;
                    break;
            }
        }
    }

    public static void librarianMenuRun(Librarian librarian) {


        LibrarianMenu librarianMenu = new LibrarianMenu();
        String staffSelection;
        staffSelection = librarianMenu.runMenu();
        boolean staffChoose = false;

        while (!staffChoose) {
            switch (staffSelection) {
                case "loans":
                    loanDetails();
                    staffChoose = true;
                    break;
                case "exit":
                    System.exit(0);
            }
        }
    }

    

    public static Librarian selectLibrarianRandomly(List<Librarian> librarians) {
        if(!librarians.isEmpty())
        {
            int randLibrarian = Math.round((float)Math.random() * (librarians.size() - 1));
            Librarian randomLibrarian = librarians.get(randLibrarian);
            System.out.println("The librarian in charge of borrowing is "+randomLibrarian.getName());
            return randomLibrarian;
        }
        else
            return null;
    }


    public static void availableBooks() {
        for (int b = 0; b < book.size(); b++) {
            System.out.println(b + " --> " +
                    book.get(b).getTittle() + " From the author: " +
                    book.get(b).getAuthor().getFirstName() +" "+ book.get(b).getAuthor().getLastName());
        }
    }

    public static void loanDetails() {
        for (int l = 0; l < loans.size(); l++) {
            System.out.println("Tittle of book--> " + loans.get(l).getBook().getTittle() + "\n"
                    + "Days of borrowing is--> " + loans.get(l).getDays() + "\n"
                    + "The user who borrows it is--> " + loans.get(l).getUser().getName() + loans.get(l).getUser().getSubName() + "\n"
                    + "Telephone user is--> " + loans.get(l).getUser().getPhoneNumber() + "\n");
        }
    }

    public static void libraryEntities() {

        Author author1 = new Author("George", "Papadopolos", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris non vulputate lorem. Phasellus et risus et est ultricies suscipit et at dolor. Sed nec diam.");
        Author author2 = new Author("Mixalhs", "Ioakimidis", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris non vulputate lorem. Phasellus et risus et est ultricies suscipit et at dolor. Sed nec diam.");
        Author author3 = new Author("Panos", "Mixalopoulos", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris non vulputate lorem. Phasellus et risus et est ultricies suscipit et at dolor. Sed nec diam.");
        User user1 = new User("Panos", "Mousiou", "test", "test", "Dafnidos 25", "+306958545157");
        users.add(user1);
        User user2 = new User("Nikolaos", "Parsotakis", "nikolaosp1@gmail.com", "nik007", "Patision 84", "+306971973467");
        users.add(user2);
        User user3 = new User("Aristofanis", "Goulas", "aristoG5@gmail.com", "258goul", "Panepistimiou 100", "+306942971835");
        users.add(user3);
        User user4 = new User("Maria", "Fourxioth", "fourM1@gmail.com", "marfour8", "Koumoundourou 4", "+306946837918");
        users.add(user4);
        Book book1 = new Book("Storms", author1, "Science", "Describe how create lightning", 3, 2);
        book.add(book1);
        Book book2 = new Book("Java", author2, "Programming", "How Java works", 5, 5);
        book.add(book2);
        Book book3 = new Book("Photography Still Life", author3, "Photography", "Tips for Still Life photography", 3, 2);
        book.add(book3);
        Book book4 = new Book("Python", author2, "Photography", "How Python works", 3, 3);
        book.add(book4);
        Librarian librarian1 = new Librarian("Alan", "Hopkins", "test", "test", "Ipokratous 46", "+306948215675");
        staff.add(librarian1);
        Librarian librarian2 = new Librarian("Aleksandra", "Kalabrezou", "aleksandrak1@librarian.com", "aleksa1972", "Sigkrou 125", "+306945449759");
        staff.add(librarian2);
        Loan loan1 = new Loan(book1, user1, librarian1, new Date(12 / 4 / 2021), 15, new Date(27 / 4 / 2021), new Date(1 / 5 / 2021));
        loans.add(loan1);
        Loan loan2 = new Loan(book3, user4, librarian2, new Date(5 / 5 / 2021), 5, new Date(10 / 5 / 2021), new Date(11 / 5 / 2021));
        loans.add(loan2);
    }
}
