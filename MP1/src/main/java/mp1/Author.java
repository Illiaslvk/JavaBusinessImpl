package mp1;

import java.io.Serializable;
import java.util.Date;

public class Author implements Serializable {
    private String name;
    private String surname;
    private Date birthday;

    public Author(String name, String surname, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name+" " + surname;
    }
}
