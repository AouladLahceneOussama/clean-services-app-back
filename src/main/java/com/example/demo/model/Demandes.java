package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;

// import java.sql.Timestamp;

// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "demandes")

public class Demandes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_demand;

    @ManyToOne
    @JoinColumn(name = "id_emp", nullable = false)
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "id_ser", nullable = false)
    private Services service;

    public Demandes() {
    }

    public Demandes(Long id_demand, String phone, long id_ser, String client_name, String adress, String position_gps,
            String description, Date date, Time time, String phone1, String statut, int isDeleted) {
        this.id_demand = id_demand;
        this.employee.phone = phone;
        this.service.id_ser = id_ser;
        this.client_name = client_name;
        this.adress = adress;
        this.position_gps = position_gps;
        this.description = description;
        this.date = date;
        this.time = time;
        this.phone = phone1;
        this.statut = statut;
        this.isDeleted = isDeleted;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getId_demand() {
        return this.id_demand;
    }

    public void setId_demand(Long id_demand) {
        this.id_demand = id_demand;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public String getEmployee() {
        return this.employee.phone;
    }

    public long getService() {
        return this.service.id_ser;
    }

    public String getClient_name() {
        return this.client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getStatut() {
        return this.statut;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPosition_gps() {
        return this.position_gps;
    }

    public void setPosition_gps(String position_gps) {
        this.position_gps = position_gps;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Demandes id_demand(Long id_demand) {
        setId_demand(id_demand);
        return this;
    }

    public Demandes employee(Employees employee) {
        setEmployee(employee);
        return this;
    }

    public Demandes client_name(String client_name) {
        setClient_name(client_name);
        return this;
    }

    public Demandes phone(String phone) {
        setPhone(phone);
        return this;
    }

    public Demandes adress(String adress) {
        setAdress(adress);
        return this;
    }

    public Demandes position_gps(String position_gps) {
        setPosition_gps(position_gps);
        return this;
    }

    public Demandes description(String description) {
        setDescription(description);
        return this;
    }

    public Demandes date(Date date) {
        setDate(date);
        return this;
    }

    public Demandes time(Time time) {
        setTime(time);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id_demand='" + getId_demand() + "'" +
                " id_emp='" + getEmployee() + "'" +
                " id_ser='" + getService() + "'" +
                ", client_name='" + getClient_name() + "'" +
                ", phone='" + getPhone() + "'" +
                ", adress='" + getAdress() + "'" +
                ", position_gps='" + getPosition_gps() + "'" +
                ", description='" + getDescription() + "'" +
                ", date='" + getDate() + "'" +
                ", time='" + getTime() + "'" +
                ", statut='" + getStatut() + "'" +
                "}";
    }

    private int isDeleted = 0;
    private String client_name;
    private String phone;
    private String adress;
    private String position_gps;
    private String description;
    private Date date;
    private Time time;
    private String statut;

}
