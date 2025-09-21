package JavaProjects.ToDoList;

public class Menu {
    public static String openingMenu(){
        System.out.println("Would you like to sign up or sign in");
        return Main.scanner.nextLine();
    }
    public static int mainMenu(){
        System.out.println("1. Create a ToDo");
        System.out.println("2. Display your ToDo's");
        System.out.println("3. Edit a ToDo");
        System.out.println("4. Remove a ToDo");
        System.out.println("5. Alter account details");
        int choice = Main.scanner.nextInt();
        Main.scanner.nextLine();
        return choice;
    }

    public static void signUp(){
        while(true){
            System.out.println("Enter your username");
            String username = Main.scanner.nextLine();
            if(Member.checkValidUsername(username)){
                System.out.println("Enter your password");
                String password = Main.scanner.nextLine();
                new Member(username, password);
                System.out.println("Account created");
                break;
            }
            else{
                System.out.println("Invalid username or password");
            }
        }
    }
    public static Member signIn(){
        while (true) {
            System.out.println("Enter your username");
            String username = Main.scanner.nextLine();
            System.out.println("Enter your password");
            String password = Main.scanner.nextLine();
            boolean validUsername = Member.checkLogin(username, password);
            if (validUsername) {
                return Member.getMember(username);
            }
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    public static void addToDo(Member signedInMember){
        while(true) {
            System.out.println("Enter your title");
            String title = Main.scanner.nextLine();
            System.out.println("Would you like to enter a description yes/no");
            String descriptionRequested = Main.scanner.nextLine();
            if (descriptionRequested.equalsIgnoreCase("yes")) {
                System.out.println("Enter your description");
                String description = Main.scanner.nextLine();
                new ToDo(title, description, signedInMember);
                return;
            } else if (descriptionRequested.equalsIgnoreCase("no")) {
                new ToDo(title, signedInMember);
                return;
            } else {
                System.out.println("Invalid description. Please try again.");
            }
        }
    }
    public static void editToDo(Member signedInMember){
        while(true) {
            System.out.println("Enter the title");
            String title = Main.scanner.nextLine();
            for(ToDo todo : ToDo.getList()){
                if(todo.getMember() ==  signedInMember && todo.getTitle().equals(title)){
                    while(true) {
                        System.out.println("What would you like to change");
                        String choice = Main.scanner.nextLine();
                        if (choice.equalsIgnoreCase("title")){
                            System.out.println("Enter your title");
                            String username = Main.scanner.nextLine();
                            todo.setTitle(username);
                            return;
                        }
                        else if (choice.equalsIgnoreCase("description")) {
                            System.out.println("Enter your description");
                            String description = Main.scanner.nextLine();
                            todo.setDescription(description);
                            return;
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
                    }
                }
            }
        }
    }
    public static void removeToDo(Member signedInMember){
        System.out.println("Enter the title");
        String title = Main.scanner.nextLine();
        ToDo.removeToDo(title, signedInMember);
        return;
    }

    public static void chooseAlteration(Member signedInMember){
        while(true){
            System.out.println("What would you like to change");
            String alterationRequested = Main.scanner.nextLine();
            if(alterationRequested.equalsIgnoreCase("username")){
                changeUsername(signedInMember);
                return;
            }
            else if(alterationRequested.equalsIgnoreCase("password")){
                changePassword(signedInMember);
                return;
            }
            else{
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void changeUsername(Member signedInMember){
        System.out.println("Enter your new username");
        String username = Main.scanner.nextLine();
        Member.setUsername(username, signedInMember);
    }
    public static void changePassword(Member signedInMember){
        System.out.println("Enter your new password");
        String password = Main.scanner.nextLine();
        Member.setPassword(password, signedInMember);
    }
}