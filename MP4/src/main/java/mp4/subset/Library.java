package mp4.subset;

import mp2.Validation.NullValidation;
import mp3.MyException;
import mp4.ObjectPlus;

import java.util.*;

public class Library extends ObjectPlus {
    private String name;
    private String location;

    // EMP
    private Employee owner; // Employee who owns the library
    private Set<Employee> employees = new HashSet<>(); // Employees working in the library

    public Library(String name, String location, Employee owner) {
        setName(name);
        setLocation(location);
        setOwner(owner);

        addToExtent();
    }

    public Library(String name, String location) {
        setName(name);
        setLocation(location);

        addToExtent();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new NullValidation("name can not be empty");
        }
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null) {
            throw new NullValidation("location can not be empty");
        }
        this.location = location;
    }

    /////////////////////////////////////////////

    public Employee getOwner() {
        return owner;
    }

    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(employees);
    }

    public void addEmployees(Employee employee) {
        if (employee == null) {
            throw new MyException("Employee cannot be null");
        }
        if (employees.contains(employee)) {
            throw new MyException("Employee is already added to the library");
        }
        employees.add(employee);
        employee.setWorksIn(this);
    }

    public void removeEmployees(Employee employee) {
        if (employee == null) {
            throw new MyException("Employee cannot be null");
        }
        if (!employees.contains(employee)) {
            throw new MyException("Employee is not associated with the library");
        }
        if (employee == owner) {
            Employee e = owner;
            owner = null;
            e.removeOwns(this);
        }
        employees.remove(employee);
        employee.setWorksIn(this);
    }

    public void setOwner(Employee employee) {
        if (employee == null) {
            throw new MyException("Employee cannot be null");
        }
        if (!employees.contains(employee)) {
            throw new MyException("Employee is not associated with the library");
        }
        if (this.owner == employee) {
            return;
        }
        if (this.owner != null) {
            throw new MyException("Library already has an owner");
        }

        this.owner = employee;
        employee.setOwns(this);
    }

    public void removeOwner(Employee employee) {
        if (employee == null) {
            throw new MyException("Employee cannot be null");
        }
        if (this.owner != employee) {
            throw new MyException("Employee is not the owner of the library");
        }
        this.owner = null;
        employee.removeOwns(this);
    }

}
