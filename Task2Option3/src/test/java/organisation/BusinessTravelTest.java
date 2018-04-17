package organisation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static java.lang.Math.toIntExact;
import java.util.Calendar;
import java.util.Date;

public class BusinessTravelTest {
    private Date dateToday;
    private Date dateTomorrow;
    private Date dateAfterWeek;
    private Date dateAfterCentury;
    private Date dateYesterday;
    private Date dateBeforeCentury;
    private int travelTotalForward;
    private int travelTotalForward2;
    private int travelTotalBack;
    private int travelTotalBack2;
    private int dailyAmount;
    private int dailyAmount2;

    @BeforeClass
    public void initializeBusinessTravels() {
        dateToday = new Date();
        Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(dateToday);
        myCalendar.add(Calendar.DATE, 1);
        dateTomorrow = myCalendar.getTime();
        myCalendar.setTime(dateToday);
        myCalendar.add(Calendar.DATE, 7);
        dateAfterWeek = myCalendar.getTime();
        myCalendar.setTime(dateToday);
        myCalendar.add(Calendar.DATE, 365 * 100);
        dateAfterCentury = myCalendar.getTime();
        myCalendar.setTime(dateToday);
        myCalendar.add(Calendar.DATE, -1);
        dateYesterday = myCalendar.getTime();
        myCalendar.setTime(dateToday);
        myCalendar.add(Calendar.DATE, -1 * (365 * 100));
        dateBeforeCentury = myCalendar.getTime();
        travelTotalForward = 700;
        travelTotalForward2 = 100;
        travelTotalBack = 900;
        travelTotalBack = 1100;
        dailyAmount = 50;
        dailyAmount2 = 10;
    }
    @Test
    public void testConstructorDefault() {
        BusinessTravel myBusinessTravel = new BusinessTravel();
        assertNull(myBusinessTravel.getDepartureDate());
        assertNull(myBusinessTravel.getArrivalDate());
        assertTrue(myBusinessTravel.getTravelTotalForward() == 0);
        assertTrue(myBusinessTravel.getTravelTotalBack() == 0);
        assertTrue(myBusinessTravel.getDailyAmount() == 0);
        assertTrue(myBusinessTravel.getNumberOfTravelDays() == 0);
    }
    @Test
    public void testConstructorWithParameters() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateTomorrow, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        assertEquals(dateTomorrow, myBusinessTravel.getDepartureDate());
        assertEquals(dateAfterWeek, myBusinessTravel.getArrivalDate());
        assertEquals(travelTotalForward, myBusinessTravel.getTravelTotalForward());
        assertEquals(travelTotalBack, myBusinessTravel.getTravelTotalBack());
        assertEquals(dailyAmount, myBusinessTravel.getDailyAmount());
        int numberOfTravelDays = toIntExact((dateAfterWeek.getTime() - dateTomorrow.getTime()) / InterfaceBusinessTravel.DAY_IN_MILLIS);
        assertEquals(numberOfTravelDays, myBusinessTravel.getNumberOfTravelDays());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorWithParametersIncorrectDays() throws IllegalArgumentException {
        new BusinessTravel(dateAfterWeek, dateTomorrow, travelTotalForward, travelTotalBack, dailyAmount);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorWithParametersDuplicateDays() throws IllegalArgumentException {
        new BusinessTravel(dateTomorrow, dateTomorrow, travelTotalForward, travelTotalBack, dailyAmount);
    }
    @Test
    public void testConstructorWithParametersNullData() {
        BusinessTravel myBusinessTravel = new BusinessTravel(null, null, 0, 0, 0);
        assertNull(myBusinessTravel.getDepartureDate());
        assertNull(myBusinessTravel.getArrivalDate());
        assertTrue(myBusinessTravel.getTravelTotalForward() == 0);
        assertTrue(myBusinessTravel.getTravelTotalBack() == 0);
        assertTrue(myBusinessTravel.getDailyAmount() == 0);
        assertTrue(myBusinessTravel.getNumberOfTravelDays() == 0);
    }
    @Test
    public void testConstructorWithParametersNegativeDeparture() {
        BusinessTravel myBusinessTravel = new BusinessTravel(null, dateAfterWeek, 0, 0, 0);
        assertNull(myBusinessTravel.getDepartureDate());
        assertEquals(dateAfterWeek, myBusinessTravel.getArrivalDate());
        assertTrue(myBusinessTravel.getTravelTotalForward() == 0);
        assertTrue(myBusinessTravel.getTravelTotalBack() == 0);
        assertTrue(myBusinessTravel.getDailyAmount() == 0);
        assertTrue(myBusinessTravel.getNumberOfTravelDays() == 0);
    }
    @Test
    public void testConstructorWithParametersNegativeArrival() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, null, 0, 0, 0);
        assertEquals(dateToday, myBusinessTravel.getDepartureDate());
        assertNull(myBusinessTravel.getArrivalDate());
        assertTrue(myBusinessTravel.getTravelTotalForward() == 0);
        assertTrue(myBusinessTravel.getTravelTotalBack() == 0);
        assertTrue(myBusinessTravel.getDailyAmount() == 0);
        assertTrue(myBusinessTravel.getNumberOfTravelDays() == 0);
    }
    @Test
    public void testConstructorWithParametersNegativeDepArr() {
        BusinessTravel myBusinessTravel = new BusinessTravel(null, null, 0, 0, 0);
        assertNull(myBusinessTravel.getDepartureDate());
        assertNull(myBusinessTravel.getArrivalDate());
        assertTrue(myBusinessTravel.getTravelTotalForward() == 0);
        assertTrue(myBusinessTravel.getTravelTotalBack() == 0);
        assertTrue(myBusinessTravel.getDailyAmount() == 0);
        assertTrue(myBusinessTravel.getNumberOfTravelDays() == 0);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorWithParametersNegativeTotalForward() throws IllegalArgumentException {
        new BusinessTravel(dateToday, dateAfterWeek, -1, 0, 0);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorWithParametersNegativeTotalBack() throws IllegalArgumentException {
        new BusinessTravel(dateToday, dateAfterWeek, 0, -1, 0);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorWithParametersNegativeDailyAmount() throws IllegalArgumentException {
        new BusinessTravel(dateToday, dateAfterWeek, 0, 0, -1);
    }
    @Test
    public void testSetDepartureDate() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        myBusinessTravel.setDepartureDate(dateYesterday);
        assertEquals(dateYesterday, myBusinessTravel.getDepartureDate());
    }
    @Test
    public void testSetDepartureDateFromNull() {
        BusinessTravel myBusinessTravel = new BusinessTravel(null, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        myBusinessTravel.setDepartureDate(dateYesterday);
        assertEquals(dateYesterday, myBusinessTravel.getDepartureDate());
    }
    @Test
    public void testSetDepartureDateToNull() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        myBusinessTravel.setDepartureDate(null);
        assertNull(myBusinessTravel.getDepartureDate());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetDepartureDateToMoreThanArrival() throws IllegalArgumentException {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        myBusinessTravel.setDepartureDate(dateAfterCentury);
    }
    @Test
    public void testSetArrivalDate() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        myBusinessTravel.setArrivalDate(dateAfterCentury);
        assertEquals(dateAfterCentury, myBusinessTravel.getArrivalDate());
    }
    @Test
    public void testSetArrivalDateFromNull() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, null, travelTotalForward, travelTotalBack, dailyAmount);
        myBusinessTravel.setArrivalDate(dateAfterWeek);
        assertEquals(dateAfterWeek, myBusinessTravel.getArrivalDate());
    }
    @Test
    public void testSetArrivalDateToNull() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        myBusinessTravel.setArrivalDate(null);
        assertNull(myBusinessTravel.getArrivalDate());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetArrivalDateToLessThanDeparture() throws IllegalArgumentException {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        myBusinessTravel.setArrivalDate(dateYesterday);
    }
    @Test
    public void testSetTotalForward() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        myBusinessTravel.setTravelTotalForward(travelTotalForward2);
        assertEquals(travelTotalForward2, myBusinessTravel.getTravelTotalForward());
    }
    @Test
    public void testSetTotalForwardToZero() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        int zero = 0;
        myBusinessTravel.setTravelTotalForward(zero);
        assertEquals(zero, myBusinessTravel.getTravelTotalForward());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetTotalForwardToNegative() throws IllegalArgumentException {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        int negative = -1;
        myBusinessTravel.setTravelTotalForward(negative);
    }
    @Test
    public void testSetTotalBack() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        myBusinessTravel.setTravelTotalBack(travelTotalBack2);
        assertEquals(travelTotalBack2, myBusinessTravel.getTravelTotalBack());
    }
    @Test
    public void testSetTotalBackToZero() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        int zero = 0;
        myBusinessTravel.setTravelTotalBack(zero);
        assertEquals(zero, myBusinessTravel.getTravelTotalBack());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetTotalBackToNegative() throws IllegalArgumentException {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        int negative = -1;
        myBusinessTravel.setTravelTotalBack(negative);
    }
    @Test
    public void testSetDailyAmount() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        myBusinessTravel.setDailyAmount(dailyAmount2);
        assertEquals(dailyAmount2, myBusinessTravel.getDailyAmount());
    }
    @Test
    public void testSetDailyAmountToZero() {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        int zero = 0;
        myBusinessTravel.setDailyAmount(zero);
        assertEquals(zero, myBusinessTravel.getDailyAmount());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetDailyAmountToNegative() throws IllegalArgumentException {
        BusinessTravel myBusinessTravel = new BusinessTravel(dateToday, dateAfterWeek, travelTotalForward, travelTotalBack, dailyAmount);
        int negative = -1;
        myBusinessTravel.setDailyAmount(negative);
    }
}
