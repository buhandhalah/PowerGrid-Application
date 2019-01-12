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
public class PlantStatus {
    
    private int id;
    private boolean plantHD;
    private double powerProduced;
    private Date timeUpdated;
    private int plantId;

    public PlantStatus(int id, boolean plantHD, double powerProduced, Date timeUpdated, int plantId) {
        this.id = id;
        this.plantHD = plantHD;
        this.powerProduced = powerProduced;
        this.timeUpdated = timeUpdated;
        this.plantId = plantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPlantHD() {
        return plantHD;
    }

    public void setPlantHD(boolean plantHD) {
        this.plantHD = plantHD;
    }

    public double getPowerProduced() {
        return powerProduced;
    }

    public void setPowerProduced(double powerProduced) {
        this.powerProduced = powerProduced;
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
        return "PlantStatus{" + "id=" + id + ", plantHD=" + plantHD + ", powerProduced=" + powerProduced + ", timeUpdated=" + timeUpdated + ", plantId=" + plantId + '}';
    }
    
    
}
