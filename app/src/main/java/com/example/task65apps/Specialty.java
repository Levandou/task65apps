package com.example.task65apps;



public class Specialty  {
    private String specialty_id;
    private String name;

    public String getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(String specialty_id) {
        this.specialty_id = specialty_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specialty{"+'\n' +
                "specialty_id='" + specialty_id + '\n' +
                ", name='" + name + '\n' +
                '}';
    }
}
