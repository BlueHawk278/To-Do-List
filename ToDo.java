package JavaProjects.ToDoList;

import java.util.ArrayList;

public class ToDo {

    private String title;
    private String description;
    private final Member member;

    private static final ArrayList<ToDo> ToDoList = new ArrayList<>();

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
        ArrayList<ToDo> removeList = new ArrayList<>();
        for(ToDo todo : ToDoList){
            if(todo.title.equals(title) && todo.member == member) {
                removeList.add(todo);
            }
        }
        for(ToDo todo : removeList){
            ToDoList.remove(todo);
        }
        System.out.println("Your To-Do's have been removed");
    }

    static void displayToDoList(Member member){
        for(ToDo todo : ToDoList){
            if(todo.member == member){
                System.out.println(todo.toString());
            }
        }
    }

    static ArrayList<ToDo> getList(){
        return ToDoList;
    }
    Member getMember() {
        return this.member;
    }

    public String getTitle() {
        return this.title;
    }
    public String getDescription() {
        return this.description;
    }

    void setTitle(String title) {
        this.title = title;
    }
    void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.getTitle() + " " + this.getDescription();
    }
}