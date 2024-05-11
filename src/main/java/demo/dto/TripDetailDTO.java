package demo.dto;

public class TripDetailDTO {
    private int detailId;
    private int tripId;
    private String placeName;
    private String placeAddress;
    private String scheduledTime;  //数据化简成string

    // Getters
    public int getDetailId() {
        return detailId;
    }

    public int getTripId() {
        return tripId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    // Setters
    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}
