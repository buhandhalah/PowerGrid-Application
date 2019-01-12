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
public class Substation {

    private int id;
    private double maxLoad;
    private String latitude;
    private String longitude;
    private int plant;

    public Substation(int id, double maxLoad, String latitude, String longitude, int plant) {
        this.id = id;
        this.maxLoad = maxLoad;
        this.latitude = latitude;
        this.longitude = longitude;
        this.plant = plant;
    }

    public int getPlant() {
        return plant;
    }

    public void setPlant(int plant) {
        this.plant = plant;
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

    public double getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    @Override
    public String toString() {
        return "Substation{" + "id=" + id + ", maxLoad=" + maxLoad + ", latitude=" + latitude + ", longitude=" + longitude + ", plant=" + plant + '}';
    }

}
