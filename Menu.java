package Projects.ToDoList;

import static Projects.ToDoList.Main.sc;
import static Projects.ToDoList.Main.username;
import static Projects.ToDoList.Main.password;

public class Menu {

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
