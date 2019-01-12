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
public class EnergySource {

    private int id;
    private String sourceType;
    private double costPerWatt;

    public EnergySource(int id, String sourceType, double costPerWatt) {
        this.id = id;
        this.sourceType = sourceType;
        this.costPerWatt = costPerWatt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public double getCostPerWatt() {
        return costPerWatt;
    }

    public void setCostPerWatt(double costPerWatt) {
        this.costPerWatt = costPerWatt;
    }

    @Override
    public String toString() {
        return "Consumer{" + "id=" + id + ", sourceType=" + sourceType + ", costPerWatt=" + costPerWatt + '}';
    }
    
    
}
