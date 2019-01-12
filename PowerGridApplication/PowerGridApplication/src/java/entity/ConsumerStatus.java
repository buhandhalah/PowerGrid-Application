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
public class ConsumerStatus {
    
    private int id;
    private boolean consumerHB;
    private double powerConsumed;
    private Date timeUpdated;
    private int consumerId;

    public ConsumerStatus(int id, boolean consumerHB, double powerConsumed, Date timeUpdated, int consumerId) {
        this.id = id;
        this.consumerHB = consumerHB;
        this.powerConsumed = powerConsumed;
        this.timeUpdated = timeUpdated;
        this.consumerId = consumerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isConsumerHB() {
        return consumerHB;
    }

    public void setConsumerHB(boolean consumerHB) {
        this.consumerHB = consumerHB;
    }

    public double getPowerConsumed() {
        return powerConsumed;
    }

    public void setPowerConsumed(double powerConsumed) {
        this.powerConsumed = powerConsumed;
    }

    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    @Override
    public String toString() {
        return "ConsumerStatus{" + "id=" + id + ", consumerHB=" + consumerHB + ", powerConsumed=" + powerConsumed + ", timeUpdated=" + timeUpdated + ", consumerId=" + consumerId + '}';
    }
    
    
}
