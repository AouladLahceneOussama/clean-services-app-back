package com.example.demo.model;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "employees")
public class Employees {

	@Id 
	@Pattern(regexp = "[0-9]{10}",message = "Phone must contain 10 numbers")
	public String phone;

	@OneToMany(targetEntity = Services.class, mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Services> services;
	
	@OneToMany(targetEntity = Workflow.class, mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Workflow> workflow;

	@NotBlank(message = "Name is required")
	private String full_name;

	private String image = "employee.png";

	@Email(message = "Invalid Email")
	@Nullable
	private String mail;
	
	private String statut = "off";

	@Nullable
	private String description;

	@Pattern(regexp = ".{8,16}",message = "Password must be between 8-16 character")
	private String password;
	private double latitude = 0.0;
    private double longitude = 0.0;
	
	public Employees() {}

	public Employees(String phone, List<Services> services, List<Workflow> workflow, String full_name, String mail, String statut, String description, String password,double latitude,double longitude,String image) {
		this.phone = phone;
		this.services = services;
		this.workflow = workflow;
		this.full_name = full_name;
		this.mail = mail;
		this.statut = statut;
		this.description = description;
		this.password = password;
		this.latitude = latitude;
		this.longitude = longitude;
		this.image = image;
	}

	public Employees(String phone, String full_name, String password) {
		this.phone = phone;
		this.full_name = full_name;
		this.password = password;
	}

	public Employees(String phone, double latitude, double longitude) {
		this.phone = phone;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Employees(String phone, String password) {
		this.phone = phone;
		this.password = password;
	}

	public Employees(String phone) {
		this.phone = phone;
	}

	public String getphone() {
		return this.phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public List<Services> getServices() {
		return this.services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	public List<Workflow> getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(List<Workflow> workflow) {
		this.workflow = workflow;
	}

	public String getFull_name() {
		return this.full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Employees phone(String phone) {
		setphone(phone);
		return this;
	}

	public Employees services(List<Services> services) {
		setServices(services);
		return this;
	}

	public Employees workflow(List<Workflow> workflow) {
		setWorkflow(workflow);
		return this;
	}

	public Employees full_name(String full_name) {
		setFull_name(full_name);
		return this;
	}

	

	public Employees mail(String mail) {
		setMail(mail);
		return this;
	}

	public Employees statut(String statut) {
		setStatut(statut);
		return this;
	}

	public Employees description(String description) {
		setDescription(description);
		return this;
	}

	public Employees password(String password) {
		setPassword(password);
		return this;
	}


	@Override
	public String toString() {
		return "{" +
			", services='" + getServices() + "'" +
			", workflow='" + getWorkflow() + "'" +
			", full_name='" + getFull_name() + "'" +
			", image='" + getImage() + "'" +
			", mail='" + getMail() + "'" +
			", statut='" + getStatut() + "'" +
			", description='" + getDescription() + "'" +
			", password='" + getPassword() + "'" +
			", latitude='" + getLatitude() + "'" +
			", longitude='" + getLongitude() + "'" +
			"}";
	}

    public void save(Employees emp) {
    }



}
