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
                signUp();
            }

            else if (choice == 2) {
                boolean exitedLoop = false;
                boolean signedIn = false;
                Member signedInMember = null;

                // Ensures user enters input
                while(!signedIn){
                    signedInMember = signIn();
                    if(signedInMember != null){
                        signedIn = true;
                    }
                }

                while (!exitedLoop) {
                    int menuChoice = mainMenu();

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

    public static Member signIn(){
        Member signedInMember = null;
        boolean signedIn = false;
        do{
            System.out.println("Enter your username");
            username = sc.nextLine();
            System.out.println("Enter your password");
            password = sc.nextLine();
            if(Member.checkLogin(username, password)){
                System.out.println("You have signed in");
                signedInMember = Member.getMember(username);
                break;
            }
        } while (!signedIn);

        return signedInMember;
    }

    public static void signUp(){
        boolean usernameValid = false;

        do{
            System.out.println("Enter a username for your account");
            username = sc.nextLine();

            if(Member.checkValidUsername(username)){// if username available
                usernameValid = true;
                break;
            }
        }
        while (!usernameValid);

        System.out.println("Enter a Password for your account");
        password = sc.nextLine();

        Member member = new Member(username, password);
        System.out.println("Your account has been created");
    }

    public static int mainMenu(){
        System.out.println("\nWelcome to the To-Do List Menu");
        System.out.println("1. Create a new To-Do");
        System.out.println("2. Display All your To-Do's");
        System.out.println("3. Delete a To-Do");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
}
