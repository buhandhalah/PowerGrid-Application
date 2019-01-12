/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.Date;
/**
 *
 * @author StudentAdmin
 */
public class FeederStatus {
    
    private int id;
    private boolean feederHB;
    private Date timeUpdated;
    private int feederId;

    public FeederStatus(int id, boolean feederHB, Date timeUpdated, int feederId) {
        this.id = id;
        this.feederHB = feederHB;
        this.timeUpdated = timeUpdated;
        this.feederId = feederId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFeederHB() {
        return feederHB;
    }

    public void setFeederHB(boolean feederHB) {
        this.feederHB = feederHB;
    }

    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public int getFeederId() {
        return feederId;
    }

    public void setFeederId(int feederId) {
        this.feederId = feederId;
    }

    @Override
    public String toString() {
        return "FeederStatus{" + "id=" + id + ", feederHB=" + feederHB + ", timeUpdated=" + timeUpdated + ", feederId=" + feederId + '}';
    }
    
    
}
