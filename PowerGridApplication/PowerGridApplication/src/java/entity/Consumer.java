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
public class Consumer {
    private int id;
    private String consumerType;
    private int feederId;

    public Consumer(int id,String consumerType, int feederId) {
        this.id = id;
        this.consumerType = consumerType;
        this.feederId = feederId;
    }

    public int getId() {
        return id;
    }

    public String getConsumerType() {
        return consumerType;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public int getFeederId() {
        return feederId;
    }

    public void setFeederId(int feederId) {
        this.feederId = feederId;
    }

    public void setConsumerType(String consumerType) {
        this.consumerType = consumerType;
    }

    @Override
    public String toString() {
        return "Consumer{" + "id=" + id + ", consumerType=" + consumerType + ", feederId=" + feederId + '}';
    }
    
    
    
}
