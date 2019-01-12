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
public class Feeder {
    private int id;
    private int stationId;

    public Feeder(int id, int stationId) {
        this.id = id;
        this.stationId = stationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Override
    public String toString() {
        return "Feeder{" + "id=" + id + ", stationId=" + stationId + '}';
    }
    
    
}
