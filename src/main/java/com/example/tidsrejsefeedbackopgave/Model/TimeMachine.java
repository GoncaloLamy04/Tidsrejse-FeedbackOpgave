package com.example.tidsrejsefeedbackopgave.Model;


public class TimeMachine {
    private int id;
    private String name;
    private int capacity;
    private String status;

    public TimeMachine(String name, int capacity, String status, int id){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.status = status;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public int getCapacity(){ return capacity; }
    public void setCapacity(int capacity){ this.capacity = capacity; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }

    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }

    @Override
    public String toString(){
        return id + "|" + name + "|" + capacity + "|" + status;
    }
}
