package mp4.unique;

import mp4.NullValidation;
import mp4.ObjectPlus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private String libraryName;
    private String location;
    private List<Employee> employees;

    public Library(String libraryName, String location) {
        setLibraryName(libraryName);
        setLocation(location);

        employees = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        if (libraryName == null || libraryName.isBlank()) {
            throw new NullValidation("libraryName can not be empty or null");
        }
        this.libraryName = libraryName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null || location.isBlank()) {
            throw new NullValidation("location can not be empty or null");
        }
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new NullValidation("Employee cannot be null.");
        }
        if (employees.contains(employee)) {
            throw new IllegalArgumentException("Employee already exists in the library.");
        }
        employees.add(employee);
    }
    public void removeEmployee(Employee employee){
        if(employee == null) {
            throw new NullValidation("employee cannot be null");
        }
        this.employees.remove(employee);
    }

}

