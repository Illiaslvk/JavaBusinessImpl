package mp4.unique;

import mp4.NullValidation;
import mp4.ObjectPlus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Employee {
    private static final Set<Employee> extent = new HashSet<>();
    private long id;
    private String username; //unique

    public Employee(long id, String username) {
        setId(id);
        setUsername(username);

        extent.add(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id < 0) {
            throw new NullValidation("Id can not be smaller than 0");
        }
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new NullValidation("username cannot be empty");
        }
        if(!isUsernameUnique(username))
        {
            throw new IllegalArgumentException("username should be unique");
        }
        this.username = username;
    }

    private static boolean isUsernameUnique(String username){
        return extent.stream().noneMatch(un -> un.getUsername().equals(username));
    }


    @Override
    public String toString() {
        return "Employee{" +
                ", Employee Id ='" + id + '\'' +
                ", Username ='" + username + '\'' +
                '}';
    }

}
