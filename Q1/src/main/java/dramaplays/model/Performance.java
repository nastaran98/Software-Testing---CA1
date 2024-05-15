package src.main.java.dramaplays.model;

import java.util.HashSet;
import java.util.Set;

public class Performance {

    public final String playID;
    public int audience;

    public Performance(String playID, int audience) {
        if (playID == null || playID.trim().isEmpty()) {
            throw new IllegalArgumentException("Play ID cannot be null or empty");
        }
        if (audience < 0) {
            throw new IllegalArgumentException("Audience cannot be negative");
        }
        this.playID = playID;
        this.audience = audience;
    }

    public String getPlayID() {
        return playID;
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        if (audience < 0) {
            throw new IllegalArgumentException("Audience cannot be negative");
        }
        this.audience = audience;
    }
}
