package com.example.tidsrejsefeedbackopgave.Model;

public class Guide {
    private String name;
    private String specialty;
    private int id;

    public Guide(String name, String specialty, int id) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return id + "|" + name + "|" + specialty;
    }
}

