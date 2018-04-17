package organisation;

import java.util.Date;

interface InterfaceBusinessTravel {
    public final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
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
