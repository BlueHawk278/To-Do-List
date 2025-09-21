package JavaProjects.ToDoList.File;

import java.io.*;

public class ToDo {

    static final String path = "C:\\Users\\harry\\OneDrive\\Computer_Science\\Programming\\Projects\\JavaProjects\\ToDoList\\Database\\ToDoS.txt";

    public static void writeData(){
        try(FileWriter fw = new FileWriter(path)){
            for(JavaProjects.ToDoList.ToDo todo : JavaProjects.ToDoList.ToDo.getList()){
                fw.write(todo.toString());
            }
        }
        catch (IOException e){
            System.out.println("Something went wrong" + e.getMessage());
        }
    }

    public static void readData(){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = "";
            while((line = reader.readLine()) != null) {
                String[] members = line.split(",");
                // FIX THIS
                new JavaProjects.ToDoList.ToDo(members[0], members[1], members[2]);
            }
        }
        catch (IOException e){
            System.out.println("Something went wrong" + e.getMessage());
        }
    }
}