package com.example.demo.model;

import java.sql.Time;
import javax.persistence.*;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "workflow")
public class Workflow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_wf;

	@ManyToOne
	@JoinColumn(name = "id_emp", nullable = false)
	private Employees employee;

	private String day;

	@Nullable
	private Time wf_from;

	@Nullable
	private Time wf_to;

	private String statut = "off";

	public Workflow() {}

	public Workflow(Long id_wf, Employees employee, String day, Time wf_from, Time wf_to,String statut) {
		this.employee = employee;
		this.id_wf = id_wf;
		this.day = day;
		this.wf_from = wf_from;
		this.wf_to = wf_to;
		this.statut = statut;
	}

	public Workflow(Employees employee, String day) {
		this.employee = employee;
		this.day = day;
	}

	public Long getId_wf() {
		return this.id_wf;
	}

	public void setId_wf(Long id_wf) {
		this.id_wf = id_wf;
	}

	

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Time getWf_from() {
		return this.wf_from;
	}

	public void setWf_from(Time wf_from) {
		this.wf_from = wf_from;
	}

	public Time getWf_to() {
		return this.wf_to;
	}

	public void setWf_to(Time wf_to) {
		this.wf_to = wf_to;
	}

	public Workflow id_wf(Long id_wf) {
		setId_wf(id_wf);
		return this;
	}

	public Workflow employee(Employees employee) {
		setEmployee(employee);
		return this;
	}

	public Workflow day(String day) {
		setDay(day);
		return this;
	}

	public Workflow wf_from(Time wf_from) {
		setWf_from(wf_from);
		return this;
	}

	public Workflow wf_to(Time wf_to) {
		setWf_to(wf_to);
		return this;
	}

	@Override
	public String toString() {
		return "{" +
			" id_wf='" + getId_wf() + "'" +
			", day='" + getDay() + "'" +
			", wf_from='" + getWf_from() + "'" +
			", wf_to='" + getWf_to() + "'" +
			", statut='" + getStatut() + "'" +

			
			"}";
	}

}
