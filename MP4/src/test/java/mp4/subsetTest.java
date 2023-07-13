package mp4;

import mp4.subset.Employee;
import mp4.subset.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class subsetTest {
    @Test
    public void test(){
        Library library = new Library("sss","sss");
        Employee e1 = new Employee("John", 1);
        Employee e2 = new Employee("John1", 2);
        Employee e3 = new Employee("John2", 3);
        Employee e4 = new Employee("John3", 4);

        //Adding employees
        library.addEmployees(e1);
        library.addEmployees(e2);
        library.addEmployees(e3);

        assertEquals(e1.getWorksIn(),library);
        assertEquals(e2.getWorksIn(),library);
        assertEquals(e3.getWorksIn(),library);

        assertEquals(library.getEmployees().size(),3);

        //Valid Setting and changing administrator

        //Set
        library.setOwner(e1);
        assertEquals(e1.getOwns(),library);

        //Remove
        library.removeOwner(e1);
        assertNull(e1.getOwns());
        assertNull(library.getOwner());

        //Change
        library.setOwner(e2);
        assertEquals(e2.getOwns(),library);
        assertEquals(library.getOwner(),e2);

        //Invalid setting and changing administrator
        //salon.setAdministratedBy(e4); -- throws an exception
        library.removeEmployees(e2);
        assertFalse(library.getEmployees().contains(e2));
        assertNull(library.getOwner());
        assertNull(e2.getOwns());

    }
}
