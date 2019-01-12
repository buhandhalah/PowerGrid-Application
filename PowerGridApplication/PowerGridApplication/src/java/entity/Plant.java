/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author StudentAdmin
 */
public class Plant {

    private int id;
    private int energySource;
    private double maxCapacity;
    private double fuelLevel;
    private String latitude;
    private String longitude;

    public Plant(int id, int energySource, double maxCapacity, double fuelLevel, String latitude, String longitude) {
        this.id = id;
        this.energySource = energySource;
        this.maxCapacity = maxCapacity;
        this.fuelLevel = fuelLevel;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnergySource() {
        return energySource;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setEnergySource(int energySource) {
        this.energySource = energySource;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    @Override
    public String toString() {
        return "Plant{" + "id=" + id + ", energySource=" + energySource + ", maxCapacity=" + maxCapacity + ", fuelLevel=" + fuelLevel + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

   

   

}
