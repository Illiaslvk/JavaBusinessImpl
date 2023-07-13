package mp4.subset;

import mp2.Validation.NullValidation;
import mp3.BookValidation;
import mp3.MyException;
import mp4.ObjectPlus;

public class Employee extends ObjectPlus {
    private String firstName;
    private int employeeId;

    //LIB
    private Library owns;    // Library owned by the employee
    private Library worksIn; // Library where the employee works

    public Employee(String firstName, int employeeId) {
        setFirstName(firstName);
        setEmployeeId(employeeId);

        addToExtent();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new NullValidation("firstName can not be empty");
        }
        this.firstName = firstName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        if(employeeId < 0) {
            throw new BookValidation("employeeId cannot be smaller than 0");
        }
        this.employeeId = employeeId;
    }

    //////////////////////////////////////////////////////////////////

    public Library getOwns() {
        return owns;
    }

    public Library getWorksIn() {
        return worksIn;
    }

    public void setWorksIn(Library library) {
        if (library == null) {
            throw new MyException("Library cannot be null");
        }
        if (worksIn == library) {
            return;
        }
        if (this.worksIn != null) {
            throw new MyException("This employee already works in a different library");
        }
        this.worksIn = library;
    }

    public void removeWorksIn(Library library) {
        if (library == null) {
            throw new MyException("Library cannot be null");
        }
        if (library.getEmployees().contains(this)) {
            throw new MyException("Library still has this employee as a worker");
        }
        this.worksIn = null;
    }

    public void setOwns(Library library) {
        if (library == null) {
            throw new MyException("Library cannot be null");
        }
        if (owns == library) {
            return;
        }
        if (this.owns != null) {
            throw new MyException("This employee already owns a different library");
        }
        this.owns = library;
    }

    public void removeOwns(Library library) {
        if (library == null) {
            throw new MyException("Library cannot be null");
        }
        if (library.getOwner() == this) {
            throw new MyException("Library still has this employee as an owner");
        }
        this.owns = null;
    }


    @Override
    public void removeFromExtent() {
        super.removeFromExtent();
    }

}

