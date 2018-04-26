package organisationtesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.Date;
import organisation.*;

public class HalfDayEmployeeGetSetFirstNameTest {
    private String firstName;
    private String lastName;
    private JobTitles position;
    private int salary;
    private String firstName1;
    private Date hireDateNow;

    @BeforeClass
    public void beforeMethod() {
        firstName = "Vasiliy";
        lastName = "Ivanov";
        position = JobTitles.OfficeManager;
        salary = 45000;
        firstName1 = "Ivan";
        Calendar myCalendar = Calendar.getInstance();
        hireDateNow = myCalendar.getTime();
    }
    @Test
    public void testSetEmployeeFirstNameConstExtHireDate() {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        myEmployee.setEmployeeFirstName(firstName1);
        assertEquals(firstName1, myEmployee.getEmployeeFirstName());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetEmployeeFirstNameNullValues() throws IllegalArgumentException {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        myEmployee.setEmployeeFirstName(null);
    }
}
