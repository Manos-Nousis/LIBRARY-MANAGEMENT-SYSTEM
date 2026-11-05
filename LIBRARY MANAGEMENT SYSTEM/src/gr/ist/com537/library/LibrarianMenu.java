package gr.ist.com537.library;

import java.util.Scanner;

public class LibrarianMenu {
    public String runMenu() {
        String staffSelection;
        do {
            System.out.println("What do you want to do" + "\n"
                    + "(Type (loans) for display loans details)" + "\n"
                    + "(Type (exit) for exit");
            Scanner userChoice = new Scanner(System.in);
            staffSelection = userChoice.nextLine();
        } while (!staffSelection.equals("loans") && !staffSelection.equals("exit"));
        return staffSelection;
    }
}
