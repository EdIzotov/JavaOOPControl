package organisation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import static java.lang.Math.toIntExact;

public class FullDayEmployee extends Employee implements InterfaceFullDayEmployee {
    private ArrayList<BusinessTravel> businessTravelsArray;

    public FullDayEmployee(String firstName, String lastName) {
        super(firstName, lastName);
        businessTravelsArray = new ArrayList<>();
    }
    public FullDayEmployee(String firstName, String lastName, JobTitles position, int salary) {
        super(firstName, lastName, position, salary);
        businessTravelsArray = new ArrayList<>();
    }
    public FullDayEmployee(String firstName, String lastName, JobTitles position, int salary, Date hireDate) {
        super(firstName, lastName, position, salary, hireDate);
        businessTravelsArray = new ArrayList<>();
    }
    public int getMonthPremiumAmount() {
        int monthPremiumAmount;
        Date hireDate = super.getEmployeeHireDate();
        Calendar calendarNow = Calendar.getInstance();
        Calendar calendarHire = Calendar.getInstance();
        calendarHire.setTime(hireDate);
        int years = calendarNow.get(Calendar.YEAR) - calendarHire.get(Calendar.YEAR);
        if ((calendarHire.get(Calendar.MONTH) > calendarNow.get(Calendar.MONTH)) || (calendarHire.get(Calendar.MONTH) == calendarNow.get(Calendar.MONTH) && 
        calendarHire.get(Calendar.DATE) > calendarNow.get(Calendar.DATE))) {
            if (years > 0) {
                years--;
            }
        }
        monthPremiumAmount = Math.round((float) years / 20f * (float) getEmployeeSalary());
        if (calendarNow.get(Calendar.MONTH) == 0) {
            monthPremiumAmount += getEmployeeSalary();
        }
        return monthPremiumAmount;
    }
    public void addBusinessTravel(BusinessTravel businessTravel) {
        businessTravelsArray.add(businessTravel);        
    }
    public void removeBusinessTravel(Date departureDate) {
        for (BusinessTravel busTrav: businessTravelsArray) {
            if ((departureDate.getTime() / InterfaceBusinessTravel.DAYS_BETWEEN_DATES) == (busTrav.getArrivalDate().getTime() / InterfaceBusinessTravel.DAYS_BETWEEN_DATES)) {
                businessTravelsArray.remove(busTrav);
            }
        }
    }
    public BusinessTravel getBusinessTravel(Date businessTravelDate) {
        for (BusinessTravel busTrav: businessTravelsArray) {
            if ((businessTravelDate.getTime() >= busTrav.getDepartureDate().getTime()) && businessTravelDate.getTime() <= busTrav.getArrivalDate().getTime()) {
                return businessTravelsArray.get(businessTravelsArray.indexOf(busTrav));
            }
        }
        return null;
    }
    public int getBusinessTravelDaysAvg() {
        int businessTravelDays = 0;
        for (BusinessTravel busTrav: businessTravelsArray) {
            businessTravelDays += busTrav.getNumberOfTravelDays();
        }
        return Math.round(((float) businessTravelDays) / ((float) businessTravelsArray.size()));
    }
    public int getDaysBetweenBusinessTravelsAvg() {
        Date hire = getEmployeeHireDate();
        Calendar myCalendar = Calendar.getInstance();
        int daysOfWork = toIntExact((myCalendar.getTimeInMillis() - hire.getTime()) / InterfaceBusinessTravel.DAYS_BETWEEN_DATES);
        return ((daysOfWork - (getBusinessTravelDaysAvg() * this.businessTravelsArray.size())) / (this.businessTravelsArray.size() - 1));
    }
}
