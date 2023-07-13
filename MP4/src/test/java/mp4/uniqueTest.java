package mp4;

import mp4.unique.Employee;
import mp4.unique.Library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class uniqueTest {

    private Employee employee;
    private Library library;

    @Before
    public void setup() {
        library = new Library("Public Library", "Main Street");
        employee = new Employee(1,"s22460");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test(){
        new Employee(2,"s22460");
    }

    public void test2(){
        Employee employee1 = new Employee(2,"J23");
        employee.setUsername("J23");

    }

}