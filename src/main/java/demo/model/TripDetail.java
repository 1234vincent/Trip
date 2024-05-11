package demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "trip_details")
public class TripDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailId;
    private int tripId;
    private String placeId;
    private String placeName;
    private String placeAddress;
    private Timestamp scheduledTime;

    // Getters
    public int getDetailId() {
        return detailId;
    }

    public int getTripId() {
        return tripId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public Timestamp getScheduledTime() {
        return scheduledTime;
    }

    // Setters
    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public void setScheduledTime(Timestamp scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}
