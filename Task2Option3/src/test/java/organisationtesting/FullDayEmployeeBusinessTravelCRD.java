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
    private Date hireDateNowAround;
    private Date hireDateBeforeAround;
    private Date hireDateAfterAround;
    private BusinessTravel businessTravelBefore;

    @BeforeClass
    public void beforeMethod() {
        firstName = "Vasiliy";
        lastName = "Ivanov";
        position = JobTitles.OfficeManager;
        salary = 45000;
        Calendar myCalendar = Calendar.getInstance();
        hireDateNow = myCalendar.getTime();
        Calendar myCalendarAround = Calendar.getInstance();
        myCalendarAround.setTimeInMillis(hireDateNow.getTime());
        myCalendarAround.set(Calendar.MILLISECOND, 0);
        myCalendarAround.set(Calendar.SECOND, 0);
        myCalendarAround.set(Calendar.MINUTE, 0);
        myCalendarAround.set(Calendar.HOUR, 0);
        hireDateNowAround = myCalendarAround.getTime();
        myCalendar.add(Calendar.DATE, -7);
        myCalendarAround.add(Calendar.DATE, -7);
        hireDateBefore = myCalendar.getTime();
        hireDateBeforeAround = myCalendarAround.getTime();
        myCalendar.add(Calendar.DATE, 14);
        myCalendarAround.add(Calendar.DATE, 14);
        hireDateAfter = myCalendar.getTime();
        hireDateAfterAround = myCalendarAround.getTime();
        businessTravelBefore = new BusinessTravel(hireDateBefore, hireDateNow, 1500, 3000, 100);
    }

    @Test
    public void testGetAddEmployeeBusinessTravel() {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
        System.out.println(hireDateNow);
        System.out.println(hireDateNowAround);
        assertNull(myEmployee.getBusinessTravel(hireDateNow));
        assertNull(myEmployee.getBusinessTravel(hireDateBefore));
        myEmployee.addBusinessTravel(businessTravelBefore);
        assertNotNull(myEmployee.getBusinessTravel(hireDateBefore));
        assertNotNull(myEmployee.getBusinessTravel(hireDateBeforeAround));
        assertNull(myEmployee.getBusinessTravel(hireDateNow));
        assertNull(myEmployee.getBusinessTravel(hireDateNowAround));
    }
}
