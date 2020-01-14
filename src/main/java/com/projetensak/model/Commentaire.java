package com.projetensak.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Commentaire implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public long getPriorite() {
		return priorite;
	}

	public void setPriorite(long priorite) {
		this.priorite = priorite;
	}

	@Id
	@GeneratedValue
	private long id;
	private String titre;
	private String message;
	private long priorite;
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private Employee employee; 
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private Tache tache;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
	
}
