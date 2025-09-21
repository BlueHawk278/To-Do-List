package JavaProjects.ToDoList;

import java.io.*;

public class File {

    static private final String path = "C:\\Users\\harry\\OneDrive\\Computer_Science\\Programming\\Projects\\JavaProjects\\ToDoList\\Database\\Members.txt";

    // Write data to members.txt
    public static void membersWriteData(){
        try(FileWriter fw = new FileWriter(path)){
            for(Member member : Member.getMembers()){
                fw.write(member.getUsername() + "," + member.getPassword()+"\n");
            }
        }
        catch(IOException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    // Read in data from members.txt
    public static void membersReadData(){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while((line = reader.readLine()) != null) {
                String[] members = line.split(",");
                // Create new Member
                new Member(members[0], members[1]);
            }
        }
        catch(IOException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
