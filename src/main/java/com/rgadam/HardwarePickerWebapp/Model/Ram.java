package com.rgadam.HardwarePickerWebapp.Model;

import javax.persistence.*;

@Entity
@Table(name = "ram")
public class Ram {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Columns
    @Column(name = "Name")
    private String name;

    @Column(name = "Memory")
    private Integer memory;

    @Column(name = "Clockspeed")
    private Float clockspeed;

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

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Float getClockspeed() {
        return clockspeed;
    }

    public void setClockspeed(Float clockspeed) {
        this.clockspeed = clockspeed;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
