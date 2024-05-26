package demo.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import demo.model.Travel;

public class TravelDTO {
    private int tripId;
    private int userId;
    private String startLocation;
    private String endLocation;
    private Date startDate;
    private Date endDate;
    private BigDecimal budget;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean likeCulture;
    private Boolean likeNature;
    private Boolean likeAdventure;
    private List<TravelDetailDTO> tripDetails;

    // Getters and Setters

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getLikeCulture() {
        return likeCulture;
    }

    public void setLikeCulture(Boolean likeCulture) {
        this.likeCulture = likeCulture;
    }

    public Boolean getLikeNature() {
        return likeNature;
    }

    public void setLikeNature(Boolean likeNature) {
        this.likeNature = likeNature;
    }

    public Boolean getLikeAdventure() {
        return likeAdventure;
    }

    public void setLikeAdventure(Boolean likeAdventure) {
        this.likeAdventure = likeAdventure;
    }

    public List<TravelDetailDTO> getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(List<TravelDetailDTO> tripDetails) {
        this.tripDetails = tripDetails;
    }
}
