package gr.ist.com537.library;

import java.util.Scanner;

public class LoginMenu {
    public String runMenu() {
        String personSelection;
        do {
            System.out.println("Welcome to the digital library system");
            System.out.println("How do you want to connect" + "\n"
                    + "Type (user) for login as a user" + "\n"
                    + "Type (staff) for login as a librarian" + "\n"
                    + "Type (exit) for quit the library");
            Scanner userChoice = new Scanner(System.in);
            personSelection = userChoice.nextLine();
        } while (!personSelection.equals("user") && !personSelection.equals("staff") && !personSelection.equals("exit"));
        return personSelection;
    }
}

