package com.rgadam.HardwarePickerWebapp.Model;

import javax.persistence.*;

@Entity
@Table(name = "cpu")
public class Cpu {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Columns
    @Column(name = "Name")
    private String name;

    @Column(name = "Cores")
    private Integer cores;

    @Column(name = "Clockspeed")
    private Float clockspeed;

    @Column(name = "Socket")
    private String socket;

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

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public Float getClockspeed() {
        return clockspeed;
    }

    public void setClockspeed(Float clockspeed) {
        this.clockspeed = clockspeed;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
