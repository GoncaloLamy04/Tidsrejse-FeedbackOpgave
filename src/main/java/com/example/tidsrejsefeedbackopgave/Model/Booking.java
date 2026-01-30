package com.example.tidsrejsefeedbackopgave.Model;

public class Booking {
    private Customer customer;
    private Guide guide;
    private TimeMachine timemachine;
    private TimePeriod timeperiod;

    public Booking(TimePeriod timeperiod, Customer customer, Guide guide, TimeMachine timemachine){
        this.customer = customer;
        this.guide = guide;
        this.timemachine = timemachine;
        this.timeperiod = timeperiod;
    }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Guide getGuide() { return guide; }
    public void setGuide(Guide guide) { this.guide = guide; }

    public TimeMachine getTimemachine() { return timemachine; }
    public void setTimemachine(TimeMachine timemachine) { this.timemachine = timemachine; }

    public TimePeriod getTimeperiod() { return timeperiod; }
    public void setTimeperiod(TimePeriod timeperiod) { this.timeperiod = timeperiod; }

    @Override
    public String toString() {
        return customer + "|" + timemachine + "|" + timeperiod + "|" + guide;
    }
}
