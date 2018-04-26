package organisationtesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.Date;
import organisation.*;

public class HalfDayEmployeeGetMonthPremiumAmountTest {
    private String firstName;
    private String lastName;
    private JobTitles position;
    private int salary;
    private Date hireDateNow;
    private Date hireDateBefore2Years;

    @BeforeClass
    public void beforeMethod() {
        firstName = "Vasiliy";
        lastName = "Ivanov";
        position = JobTitles.OfficeManager;
        salary = 45000;
        Calendar myCalendar = Calendar.getInstance();
        hireDateNow = myCalendar.getTime();
        myCalendar.add(Calendar.DATE, -731);
        hireDateBefore2Years = myCalendar.getTime();
    }
    @Test
    public void testGetEmployeeMonthPremium() {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertTrue(myEmployee.getMonthPremiumAmount() == 0);
    }
    @Test
    public void testGetEmployeeMonthPremiumHireDateNow() {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateBefore2Years);
        assertTrue(myEmployee.getMonthPremiumAmount() == 0);
    }
}
