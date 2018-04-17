package organisation;

import java.util.ArrayList;
import java.util.Date;

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
        System.out.println(hireDate);
        return 0;
    }
    public void addBusinessTravel(BusinessTravel businessTravel) {
        businessTravelsArray.add(businessTravel);        
    }
    public void removeBusinessTravel(Date departureDate) {
        for (BusinessTravel busTrav: businessTravelsArray) {
            if ((departureDate.getTime() >= busTrav.getDepartureDate().getTime()) && departureDate.getTime() <= busTrav.getArrivalDate().getTime()) {
                businessTravelsArray.remove(busTrav);
                break;
            }
        }
    }
    public BusinessTravel getBusinessTravel(Date businessTravelDate) {
        for (BusinessTravel busTrav: businessTravelsArray) {
            if ((businessTravelDate.getTime() >= busTrav.getDepartureDate().getTime()) && businessTravelDate.getTime() <= busTrav.getArrivalDate().getTime()) {
                int indexOfBusTravel = businessTravelsArray.indexOf(busTrav);
                return businessTravelsArray.get(indexOfBusTravel);
            }
        }
        return null;
    }
    public int getBusinessTravelDaysAvg() {
        int businessTravelDays = 0;
        for (BusinessTravel busTrav: businessTravelsArray) {
            continue;
        }
        return 0;
    }
    public int getDaysBetweenBusinessTravelsAvg() {
        return 0;
    }
}
