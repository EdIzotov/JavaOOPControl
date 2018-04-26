package organisationtesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.Date;
import organisation.*;

public class HalfDayEmployeeGetSetLastNameTest {
    private String firstName;
    private String lastName;
    private String lastName1;
    private JobTitles position;
    private int salary;
    private Date hireDateNow;

    @BeforeClass
    public void beforeMethod() {
        firstName = "Vasiliy";
        lastName = "Ivanov";
        lastName1 = "Petrov";
        position = JobTitles.OfficeManager;
        salary = 45000;
        Calendar myCalendar = Calendar.getInstance();
        hireDateNow = myCalendar.getTime();
    }
    @Test
    public void testSetEmployeeLastNameConstExtHireDate() {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        myEmployee.setEmployeeLastName(lastName1);
        assertEquals(lastName1, myEmployee.getEmployeeLastName());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetEmployeeLastNameNullValues() throws IllegalArgumentException {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        myEmployee.setEmployeeLastName(null);
    }
}
