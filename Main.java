package Projects.ToDoList;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static String username, password;

    public static void main(String[] args) {

        Member sampleMember = new Member("harry", "123");

        // Main Execution Loop
        boolean exitRequested = false;
        while (!exitRequested) {
            System.out.println("Would you like to sign up or sign in");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                Menu.signUp();
            }

            else if (choice == 2) {
                boolean exitedLoop = false;
                boolean signedIn = false;
                Member signedInMember = null;

                // Ensures user enters input
                while(!signedIn){
                    signedInMember = Menu.signIn();
                    if(signedInMember != null){
                        signedIn = true;
                    }
                }

                while (!exitedLoop) {
                    int menuChoice = Menu.mainMenu();

                    // Create a ToDo
                    if (menuChoice == 1) {
                        System.out.println("Enter the title for you ToDo");
                        String title = sc.nextLine();
                        System.out.println("Would you like to enter a description?");
                        String response = sc.nextLine().toLowerCase();
                        if(response.equals("yes")) {
                            System.out.println("Enter a description for your ToDo");
                            String description = sc.nextLine();

                            ToDo todo = new ToDo(title, description, signedInMember);
                        }

                        else if(response.equals("no")) {
                            ToDo todo = new ToDo(title, signedInMember);
                        }
                    }

                    // Display your ToDoS
                    else if (menuChoice == 2) {
                        ToDo.displayToDoList(signedInMember);
                    }

                    // Removing a ToDo
                    else if (menuChoice == 3) {
                        ToDo.displayToDoList(signedInMember);
                        System.out.println("Enter the title of the ToDo you would like to remove");
                        String title = sc.nextLine();
                        System.out.println("Attempting to remove the ToDo");
                        ToDo.removeToDo(title, signedInMember);
                    }

                    // Exiting inner loop
                    else if (menuChoice == 999) {
                        exitedLoop = true;
                    }
                }
            }
            // Exiting outer loop
            else if (choice == 999){
                exitRequested = true;
            }
        }
    }
}
