package com.rgadam.HardwarePickerWebapp.Model;

import javax.persistence.*;

@Entity
@Table(name = "psu")
public class Psu {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Columns
    @Column(name = "Name")
    private String name;

    @Column(name = "Wattage")
    private Integer wattage;

    @Column(name = "Qualification")
    private String qualification;

    @Column(name = "Price")
    private Float price;

    // Getters, Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWattage() {
        return wattage;
    }

    public void setWattage(Integer wattage) {
        this.wattage = wattage;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
