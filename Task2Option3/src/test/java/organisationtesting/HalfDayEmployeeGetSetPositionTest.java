package organisationtesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.Date;
import organisation.*;

public class HalfDayEmployeeGetSetPositionTest {
    private String firstName;
    private String lastName;
    private JobTitles position;
    private JobTitles position1;
    private int salary;
    private Date hireDateNow;

    @BeforeClass
    public void beforeMethod() {
        firstName = "Vasiliy";
        lastName = "Ivanov";
        position = JobTitles.OfficeManager;
        position1 = JobTitles.BigBoss;
        salary = 45000;
        Calendar myCalendar = Calendar.getInstance();
        hireDateNow = myCalendar.getTime();
    }
    @Test
    public void testSetEmployeePosition() {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(position, myEmployee.getEmployeePosition());
        myEmployee.setEmployeePosition(position1);
        assertEquals(position1, myEmployee.getEmployeePosition());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetEmployeePositionNullValues() throws IllegalArgumentException {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(position, myEmployee.getEmployeePosition());
        myEmployee.setEmployeePosition(null);
    }
}
