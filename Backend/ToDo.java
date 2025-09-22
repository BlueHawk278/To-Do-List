package JavaProjects.ToDoList.Backend;

import java.io.*;

public class ToDo {

    static final String path = "C:\\Users\\harry\\OneDrive\\Computer_Science\\Programming\\Projects\\JavaProjects\\ToDoList\\Database\\ToDoS.txt";

    public static void writeData(){
        try(FileWriter fw = new FileWriter(path)){
            for(JavaProjects.ToDoList.ToDo todo : JavaProjects.ToDoList.ToDo.getList()){
                fw.write(todo.toStringDB());
            }
        }
        catch (IOException e){
            System.out.println("Something went wrong" + e.getMessage());
        }
    }

    // Figure out how to account for commas inside the description
    public static void readData(){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = "";
            while((line = reader.readLine()) != null) {
                String[] members = line.split(",");
                JavaProjects.ToDoList.Member member = JavaProjects.ToDoList.Member.getMember(members[2]);
                new JavaProjects.ToDoList.ToDo(members[0], members[1], member);
            }
        }
        catch (IOException e){
            System.out.println("Something went wrong" + e.getMessage());
        }
    }
}