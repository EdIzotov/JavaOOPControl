package organisation;

import java.util.Date;

import static java.lang.Math.toIntExact;

public class BusinessTravel implements InterfaceBusinessTravel {
    private Date departureDate;
    private Date arrivalDate;
    private int travelTotalForward;
    private int travelTotalBack;
    private int dailyAmount;

    public BusinessTravel() {};
    public BusinessTravel(Date departureDate, Date arrivalDate, int travelTotalForward, int travelTotalBack, int dailyAmount) throws IllegalArgumentException {
        if ((departureDate != null) && (arrivalDate != null)) {
            if (departureDate.getTime() >= arrivalDate.getTime()) {
                throw new IllegalArgumentException("Arrival date can't be less that departure date: " + departureDate.toString() + " and " + arrivalDate.toString());
            }
        }
        if ((travelTotalForward < 0) || (travelTotalBack < 0) || (dailyAmount < 0)) {
            throw new IllegalArgumentException("TravelForward amount or TravelBack or DailyAmount is less that 0: " + 
            travelTotalForward + " " + travelTotalBack + " " + dailyAmount);
        }
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.travelTotalForward = travelTotalForward;
        this.travelTotalBack = travelTotalBack;
        this.dailyAmount = dailyAmount;
    }
    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        if ((departureDate != null) && (this.arrivalDate != null)) {
            if (departureDate.getTime() >= this.arrivalDate.getTime()) {
                throw new IllegalArgumentException("Arrival date can't be less that departure date: " + departureDate.toString() + " and " + this.arrivalDate.toString());
            }
        }
        this.departureDate = departureDate;
    }
    public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        if ((this.departureDate != null) && (arrivalDate != null)) {
            if (arrivalDate.getTime() <= this.departureDate.getTime()) {
                throw new IllegalArgumentException("Arrival date can't be less that departure date: " + arrivalDate.toString() + " and " + this.departureDate.toString());
            }
        }
        this.arrivalDate = arrivalDate;
    }
    public int getTravelTotalForward() {
        return travelTotalForward;
    }
    public void setTravelTotalForward(int travelTotalForward) {
        if (travelTotalForward < 0) {
            throw new IllegalArgumentException("TravelForward amount or TravelBack or DailyAmount is less that 0: " + travelTotalForward);
        }
        this.travelTotalForward = travelTotalForward;
    }
    public int getTravelTotalBack() {
        return travelTotalBack;
    }
    public void setTravelTotalBack(int travelTotalBack) {
        if (travelTotalBack < 0) {
            throw new IllegalArgumentException("TravelForward amount or TravelBack or DailyAmount is less that 0: " + travelTotalBack);
        }
        this.travelTotalBack = travelTotalBack;
    }
    public int getDailyAmount() {
        return dailyAmount;
    }
    public void setDailyAmount(int dailyAmount) {
        if (dailyAmount < 0) {
            throw new IllegalArgumentException("TravelForward amount or TravelBack or DailyAmount is less that 0: " + dailyAmount);
        }
        this.dailyAmount = dailyAmount;
    }
    public int getNumberOfTravelDays() throws IllegalArgumentException {
        long numberOfDays = 0;
        if ((this.departureDate != null) && (this.arrivalDate != null)) {
            numberOfDays = (this.arrivalDate.getTime() - this.departureDate.getTime()) / InterfaceBusinessTravel.DAYS_BETWEEN_DATES;
        }        
        if (numberOfDays < 0) {
            throw new IllegalArgumentException("Number of travel days less than zero: numberOfDays " + numberOfDays);
        }
        return toIntExact(numberOfDays);
    }
    public int getTotalAmount() {
        return travelTotalForward + travelTotalBack + dailyAmount * getNumberOfTravelDays();
    }
}
