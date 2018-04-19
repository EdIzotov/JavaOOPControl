package organisation;

import java.util.ArrayList;
import java.util.Date;

public class HalfDayEmployee extends Employee {
    private ArrayList<BusinessTravel> businessTravelsArray;

    public HalfDayEmployee(String firstName, String lastName) {
        super(firstName, lastName);
        businessTravelsArray = new ArrayList<>();
    }
    public HalfDayEmployee(String firstName, String lastName, JobTitles position, int salary) {
        super(firstName, lastName, position, salary);
        businessTravelsArray = new ArrayList<>();
    }
    public HalfDayEmployee(String firstName, String lastName, JobTitles position, int salary, Date hireDate) {
        super(firstName, lastName, position, salary, hireDate);
        businessTravelsArray = new ArrayList<>();
    }
    public int getMonthPremiumAmount() {
        return 0;
    }
    public void addBusinessTravel(BusinessTravel businessTravel) {
        businessTravelsArray.add(businessTravel);        
    }
}
