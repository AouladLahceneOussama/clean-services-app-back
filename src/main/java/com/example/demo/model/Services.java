package com.example.demo.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "services")
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id_ser;

	@ManyToOne
	@JoinColumn(name = "id_emp", nullable = false)
	private Employees employee;

	@Embedded
	@OneToMany(targetEntity = Demandes.class, mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Demandes> demandes;

	@Embedded
	@OneToMany(targetEntity = ServiceImages.class, mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ServiceImages> serviceImages;

	private String service_name;
	private String service_parent;
	private int prix;
	private String description;
	private String city;
	private String statut;

	public Services() {
	}

	public Services(Long id_ser, String employee, String service_name,
			String service_parent, int prix, String description, String city, String statut) {
		this.id_ser = id_ser;
		this.employee.phone = employee;
		this.service_name = service_name;
		this.service_parent = service_parent;
		this.prix = prix;
		this.description = description;
		this.city = city;
		this.statut = statut;
	}

	public Services(Employees employee, String service_name, String service_parent, int prix, String description,
			String city, String statut) {
		this.employee = employee;
		this.service_name = service_name;
		this.service_parent = service_parent;
		this.prix = prix;
		this.description = description;
		this.city = city;
		this.statut = statut;
	}

	public Long getId_ser() {
		return this.id_ser;
	}

	public void setId_ser(Long id_ser) {
		this.id_ser = id_ser;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public String getEmployee() {
		return this.employee.phone;
	}

	public List<ServiceImages> getServiceImages() {
		return this.serviceImages;
	}

	public void setServiceImages(List<ServiceImages> serviceImages) {
		this.serviceImages = serviceImages;
	}

	public String getService_name() {
		return this.service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getService_parent() {
		return this.service_parent;
	}

	public void setService_parent(String service_parent) {
		this.service_parent = service_parent;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Services id_ser(Long id_ser) {
		setId_ser(id_ser);
		return this;
	}

	public Services employee(Employees employee) {
		setEmployee(employee);
		return this;
	}

	public Services service_name(String service_name) {
		setService_name(service_name);
		return this;
	}

	public Services service_parent(String service_parent) {
		setService_parent(service_parent);
		return this;
	}

	public Services prix(int prix) {
		setPrix(prix);
		return this;
	}

	public Services description(String description) {
		setDescription(description);
		return this;
	}

	public Services statut(String statut) {
		setStatut(statut);
		return this;
	}

	@Override
	public String toString() {
		return "{" +
				" id_ser='" + getId_ser() + "'" +
				", service_name='" + getService_name() + "'" +
				", service_parent='" + getService_parent() + "'" +
				", prix='" + getPrix() + "'" +
				", description='" + getDescription() + "'" +
				", statut='" + getStatut() + "'" +
				"}";
	}

}
