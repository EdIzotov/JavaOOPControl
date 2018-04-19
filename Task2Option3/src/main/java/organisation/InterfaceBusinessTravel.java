package organisation;

import java.util.Date;

interface InterfaceBusinessTravel {
    public static final long DAYS_BETWEEN_DATES = 86400000;
    Date getDepartureDate();
    void setDepartureDate(Date departureDate);
    Date getArrivalDate();
    void setArrivalDate(Date arrivalDate);
    int getTravelTotalForward();
    void setTravelTotalForward(int travelTotalForward);
    int getTravelTotalBack();
    void setTravelTotalBack(int travelTotalBack);
    int getDailyAmount();
    void setDailyAmount(int travelTotalAmount);
    int getNumberOfTravelDays();
    int getTotalAmount();
}
