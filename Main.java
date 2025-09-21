package JavaProjects.ToDoList;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Member signedInMember = null;

    public static void main(String[] args) {

        JavaProjects.ToDoList.File.Member.readData();

        System.out.println("Welcome to the To-Do List");
        while(true) {
            String choice = Menu.openingMenu();
            if (choice.equalsIgnoreCase("sign up")) {
                Menu.signUp();
            }

            else if (choice.equalsIgnoreCase("sign in")) {
                signedInMember = Menu.signIn();
                int menuChoice;
                while (true) {
                    menuChoice = Menu.mainMenu();
                    if (menuChoice == 1) {
                        Menu.addToDo(signedInMember);
                    }
                    else if (menuChoice == 2) {
                        ToDo.displayToDoList(signedInMember);
                    }
                    else if (menuChoice == 3) {
                        Menu.editToDo(signedInMember);
                    }
                    else if (menuChoice == 4) {
                        Menu.removeToDo(signedInMember);
                    }
                    else if (menuChoice == 5) {
                        Menu.chooseAlteration(signedInMember);
                    }
                    else if (menuChoice == 999) {
                        JavaProjects.ToDoList.File.Member.writeData();
                        return;
                    }
                }
            }

            else if (Integer.parseInt(choice) == 999) {
                JavaProjects.ToDoList.File.Member.writeData();
                return;
            }
        }
    }
}