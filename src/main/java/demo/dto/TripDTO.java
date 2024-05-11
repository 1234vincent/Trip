package demo.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TripDTO {
    private int tripId;
    private int userId;
    private String startLocation;
    private String endLocation;
    private Date startDate;
    private Date endDate;
    private BigDecimal budget;

    // Getters
    public int getTripId() {
        return tripId;
    }

    public int getUserId() {
        return userId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    // Setters
    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
