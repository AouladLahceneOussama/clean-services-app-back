package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "service_img")
public class ServiceImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_ser", nullable = false)
    private Services service;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getServices() {
        return this.service.id_ser;
    }

    public void setEmployee(Services service) {
        this.service = service;
    }

    public ServiceImages() {
    }

    public ServiceImages(Long id, Services service, String name) {
        this.id = id;
        this.service = service;
        this.name = name;
    }

    public ServiceImages(Services service, String name) {
        this.service = service;
        this.name = name;
    }

}
