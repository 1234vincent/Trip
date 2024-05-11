package demo.dto;

import java.math.BigDecimal;

public class PreferenceDTO {
    private int preferenceId;
    private int userId;
    private BigDecimal budget;
    private String travelMode;
    private boolean likesNature;
    private boolean likesCulture;
    private boolean likesAdventure;

    // Getters
    public int getPreferenceId() {
        return preferenceId;
    }

    public int getUserId() {
        return userId;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public boolean isLikesNature() {
        return likesNature;
    }

    public boolean isLikesCulture() {
        return likesCulture;
    }

    public boolean isLikesAdventure() {
        return likesAdventure;
    }

    // Setters
    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    public void setLikesNature(boolean likesNature) {
        this.likesNature = likesNature;
    }

    public void setLikesCulture(boolean likesCulture) {
        this.likesCulture = likesCulture;
    }

    public void setLikesAdventure(boolean likesAdventure) {
        this.likesAdventure = likesAdventure;
    }
}
