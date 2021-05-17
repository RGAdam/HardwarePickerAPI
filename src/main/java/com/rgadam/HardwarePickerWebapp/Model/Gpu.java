package com.rgadam.HardwarePickerWebapp.Model;

import javax.persistence.*;

@Entity
@Table(name = "gpu")
public class Gpu {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Columns
    @Column(name = "Name")
    private String name;

    @Column(name = "Vram")
    private Integer vram;

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

    public Integer getVram() {
        return vram;
    }

    public void setVram(Integer vram) {
        this.vram = vram;
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
