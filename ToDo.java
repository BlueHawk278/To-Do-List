package Projects.ToDoList;

import java.util.ArrayList;

public class ToDo {

    private String title;
    private String description;
    private Member member;

    private static ArrayList<ToDo> ToDoList = new ArrayList<ToDo>();

    // Constructor with description
    ToDo(String title, String description, Member member) {
        this.title = title;
        this.description = description;
        this.member = member;

        ToDoList.add(this);
    }
    // Constructor without description
    ToDo(String title, Member member){
        this.title = title;
        this.member = member;

        ToDoList.add(this);
    }

    static void removeToDo(String title, Member member){
        for(ToDo todo : ToDoList){
            if(todo.title.equals(title) && todo.member == member) {
                ToDoList.remove(todo);
                System.out.println(title + " has been removed from the list.");
            }
        }
    }

    static void displayToDoList(Member member){
        for(ToDo todo : ToDoList){
            if(todo.member == member){
                System.out.println(todo.toString());
            }
        }
    }

    Member getMember() {
        return this.member;
    }
    public String getDescription() {
        return description;
    }

    void setTitle(String title) {
        this.title = title;
    }
    void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.title + " " + this.description;
    }
}