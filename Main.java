package JavaProjects.ToDoList;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Member signedInMember = null;

    public static void main(String[] args) {
        System.out.println("Welcome to the To-Do List");
        while(true) {
            String choice = Menu.openingMenu();
            Menu.signUp();
            choice = Menu.openingMenu();
            if (choice.equalsIgnoreCase("signup")) {
                Menu.signUp();
            }

            else if (choice.equalsIgnoreCase("signin")) {
                signedInMember = Menu.signIn();
                int menuChoice;
                while (true) {
                    menuChoice = Menu.mainMenu();
                    if (menuChoice == 1) {
                        Menu.addToDo(signedInMember);
                        menuChoice = Menu.mainMenu();
                    }
                    else if (menuChoice == 2) {
                        ToDo.displayToDoList(signedInMember);
                        menuChoice = Menu.mainMenu();
                    }
                    else if (menuChoice == 3) {
                        Menu.editToDo(signedInMember);
                        menuChoice = Menu.mainMenu();
                    }
                    else if (menuChoice == 4) {
                        Menu.removeToDo(signedInMember);
                        menuChoice = Menu.mainMenu();
                    }
                    else if (menuChoice == 5) {
                        Menu.chooseAlteration(signedInMember);
                        menuChoice = Menu.mainMenu();
                    }
                    else if (menuChoice == 999) {
                        return;
                    }
                }
            }

            else if (Integer.parseInt(choice) == 999) {
                return;
            }

            else {
                Menu.openingMenu();
            }
        }
    }
}