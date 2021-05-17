package com.rgadam.HardwarePickerWebapp.Model;

import javax.persistence.*;

@Entity
@Table(name = "build")
public class Build {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpu")
    private String cpu;

    @Column(name = "gpu")
    private String gpu;

    @Column(name = "mobo")
    private String mobo;

    @Column(name = "psu")
    private String psu;

    @Column(name = "ram")
    private String ram;

    public Build() {
    }

    public Build(Long id, String cpu, String gpu, String mobo, String psu, String ram) {
        this.id = id;
        this.cpu = cpu;
        this.gpu = gpu;
        this.mobo = mobo;
        this.psu = psu;
        this.ram = ram;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMobo() {
        return mobo;
    }

    public void setMobo(String mobo) {
        this.mobo = mobo;
    }

    public String getPsu() {
        return psu;
    }

    public void setPsu(String psu) {
        this.psu = psu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
