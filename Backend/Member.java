package JavaProjects.ToDoList.Backend;

import java.io.*;

public class Member {

    static private final String path = "C:\\Users\\harry\\OneDrive\\Computer_Science\\Programming\\Projects\\JavaProjects\\ToDoList\\Database\\Members.txt";

    // Write data to members.txt
    public static void writeData(){
        try(FileWriter fw = new FileWriter(path)){
            for(JavaProjects.ToDoList.Member member : JavaProjects.ToDoList.Member.getMembers()){
                fw.write(member.getUsername() + "," + member.getPassword()+"\n");
            }
        }
        catch(IOException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    // Read in data from members.txt
    public static void readData(){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while((line = reader.readLine()) != null) {
                String[] members = line.split(",");
                // Create new Member
                new JavaProjects.ToDoList.Member(members[0], members[1]);
            }
        }
        catch(IOException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
