package organisation;

import java.util.Date;

interface InterfaceFullDayEmployee {
    void addBusinessTravel(BusinessTravel businessTravel);
    void removeBusinessTravel(Date departureDate);
    BusinessTravel getBusinessTravel(Date businessTravelDate);
    int getBusinessTravelDaysAvg();
    int getDaysBetweenBusinessTravelsAvg();
}
