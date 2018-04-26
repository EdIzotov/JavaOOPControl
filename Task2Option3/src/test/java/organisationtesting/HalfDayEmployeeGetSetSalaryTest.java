package organisationtesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.Date;
import organisation.*;

public class HalfDayEmployeeGetSetSalaryTest {
    private String firstName;
    private String lastName;
    private JobTitles position;
    private int salary;
    private int salary1;
    private int negativeSalary;
    private Date hireDateNow;

    @BeforeClass
    public void beforeMethod() {
        firstName = "Vasiliy";
        lastName = "Ivanov";
        position = JobTitles.OfficeManager;
        salary = 45000;
        salary1 = 2500;
        negativeSalary = -1000;
        Calendar myCalendar = Calendar.getInstance();
        hireDateNow = myCalendar.getTime();
    }

    @Test
    public void testSetEmployeeSalary() {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(salary, myEmployee.getEmployeeSalary());
        myEmployee.setEmployeeSalary(salary1);
        assertEquals(salary1, myEmployee.getEmployeeSalary());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetEmployeeSalaryNegativeValue() throws IllegalArgumentException {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(salary, myEmployee.getEmployeeSalary());
        myEmployee.setEmployeeSalary(negativeSalary);
    }
}
