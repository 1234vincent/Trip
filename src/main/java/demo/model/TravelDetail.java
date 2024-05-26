package demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "travel_details")
public class TravelDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailId;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Travel trip;

    private String placeId;
    private String placeName;
    private String placeAddress;
    private Timestamp scheduledTime;

    // Getters and Setters

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public Travel getTrip() {
        return trip;
    }

    public void setTrip(Travel trip) {
        this.trip = trip;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public Timestamp getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Timestamp scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}
