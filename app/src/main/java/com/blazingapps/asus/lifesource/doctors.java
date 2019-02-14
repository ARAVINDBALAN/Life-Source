package com.blazingapps.asus.lifesource;

import java.util.List;

public class doctors {
    public String name;
    public String speciality;
    public String available;

    public doctors(String name, String speciality, String available) {
        this.name = name;
        this.speciality = speciality;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String getAvailable() {
        return available;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
