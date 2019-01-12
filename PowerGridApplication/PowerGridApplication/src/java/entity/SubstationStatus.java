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
public class SubstationStatus {
    private int id;
    private boolean stationHB;
    private Date timeUpdated;
    private int plantId;

    public SubstationStatus(int id, boolean stationHB, Date timeUpdated, int plantId) {
        this.id = id;
        this.stationHB = stationHB;
        this.timeUpdated = timeUpdated;
        this.plantId = plantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStationHB() {
        return stationHB;
    }

    public void setStationHB(boolean stationHB) {
        this.stationHB = stationHB;
    }

    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    @Override
    public String toString() {
        return "SubstationStatus{" + "id=" + id + ", stationHB=" + stationHB + ", timeUpdated=" + timeUpdated + ", plantId=" + plantId + '}';
    }
    
    
}
