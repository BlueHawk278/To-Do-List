package JavaProjects.ToDoList;

import java.util.ArrayList;

public class Member {

    private String username;
    private String password;

    private static final ArrayList<Member> members = new ArrayList<>();

    public Member(String username, String password) {
        this.username = username;
        this.password = password;

        members.add(this);
    }

    // Checks for duplicate usernames
    static boolean checkValidUsername(String username){
        for(Member member : members){
            if(member.username.equals(username)){
                return false;
            }
        }
        return true;
    }
    // Checks if current credentials have been entered
    static boolean checkLogin(String username, String password){
        for(Member member : members){
            if(member.username.equals(username) && member.password.equals(password)){
                return true;
            }
        }
        return false;
    }

    public static Member getMember(String username){
        for(Member member : members){
            if(member.username.equals(username)){
                return member;
            }
        }
        return null;
    }
    public static ArrayList<Member> getMembers(){
        return members;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    static void setUsername(String username, Member member){
        member.username = username;
    }
    static void setPassword(String password, Member member){
        member.password = password;
    }
}