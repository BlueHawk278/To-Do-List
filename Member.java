package Projects.ToDoList;

import java.util.ArrayList;

public class Member {

    private String username;
    private String password;

    private static ArrayList<Member> members = new ArrayList<Member>();

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

    // Checks if corrent credentials have been entered
    static boolean checkLogin(String username, String password){
        for(Member member : members){
            if(member.username.equals(username) && member.password.equals(password)){
                return true;
            }
        }
        return false;
    }

    static Member getMember(String username){
        for(Member member : members){
            if(member.username.equals(username)){
                return member;
            }
        }
        return null;
    }

    static ArrayList<Member> getMembers(){
        return members;
    }
}