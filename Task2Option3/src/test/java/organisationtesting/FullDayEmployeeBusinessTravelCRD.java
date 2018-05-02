package organisationtesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.Date;
import organisation.*;

public class FullDayEmployeeBusinessTravelCRD {
    private String firstName;
    private String lastName;
    private JobTitles position;
    private int salary;
    private Date hireDateNow;
    private Date hireDateBefore;
    private Date hireDateAfter;
    private Date hireDateAfterPlus7Days;
    private BusinessTravel businessTravelBefore;
    private BusinessTravel businessTravelAfter;

    @BeforeClass
    public void beforeMethod() {
        firstName = "Vasiliy";
        lastName = "Ivanov";
        position = JobTitles.OfficeManager;
        salary = 45000;
        Calendar myCalendar = Calendar.getInstance();
        hireDateNow = myCalendar.getTime();
        myCalendar.add(Calendar.DATE, -7);
        hireDateBefore = myCalendar.getTime();
        myCalendar.add(Calendar.DATE, 14);
        hireDateAfter = myCalendar.getTime();
        myCalendar.add(Calendar.DATE, 7);
        hireDateAfterPlus7Days = myCalendar.getTime();
        businessTravelBefore = new BusinessTravel(hireDateBefore, hireDateNow, 1500, 3000, 100);
        businessTravelAfter = new BusinessTravel(hireDateAfter, hireDateAfterPlus7Days, 1500, 3000, 100);
    }

    @Test
    public void testGetAddEmployeeBusinessTravelBefore() {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
        assertNull(myEmployee.getBusinessTravel(hireDateNow));
        assertNull(myEmployee.getBusinessTravel(hireDateBefore));
        myEmployee.addBusinessTravel(businessTravelBefore);
        assertNotNull(myEmployee.getBusinessTravel(hireDateBefore));
        assertNotNull(myEmployee.getBusinessTravel(hireDateNow));
        assertNull(myEmployee.getBusinessTravel(hireDateAfter));
    }
    @Test
    public void testGetAddEmployeeBusinessTravelAfter() {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
        assertNull(myEmployee.getBusinessTravel(hireDateNow));
        assertNull(myEmployee.getBusinessTravel(hireDateAfter));
        myEmployee.addBusinessTravel(businessTravelAfter);
        assertNotNull(myEmployee.getBusinessTravel(hireDateAfter));
        assertNull(myEmployee.getBusinessTravel(hireDateNow));
    }
}
