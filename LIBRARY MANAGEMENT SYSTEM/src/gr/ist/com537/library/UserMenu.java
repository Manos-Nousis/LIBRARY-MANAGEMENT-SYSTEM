package gr.ist.com537.library;

import java.util.Scanner;

public class UserMenu {
    public String runMenu() {
        String userSelection;
        do {
            System.out.println("What do you want to do" + "\n"
                    + "(Type (display) for display my borrowed books)" + "\n"
                    + "(Type (borrow) for borrow a book)" + "\n"
                    + "(Type (return) for return a book" + "\n"
                    + "(Type (exit) for exit");
            Scanner userChoice = new Scanner(System.in);
            userSelection = userChoice.nextLine();
        } while (!userSelection.equals("display") && !userSelection.equals("borrow") && !userSelection.equals("return") && !userSelection.equals("exit"));
        return userSelection;
    }
}

