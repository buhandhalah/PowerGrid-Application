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
public class FuelPrice {
    private int id;
    private Date startDate;
    private Date endDate;
    private int EnergySource;

    public FuelPrice(int id, Date startDate, Date endDate, int EnergySource) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.EnergySource = EnergySource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getEnergySource() {
        return EnergySource;
    }

    public void setEnergySource(int EnergySource) {
        this.EnergySource = EnergySource;
    }

    @Override
    public String toString() {
        return "FuelPrice{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", EnergySource=" + EnergySource + '}';
    }
    
    
}
