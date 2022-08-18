package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Reviews{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_review;

    @ManyToOne
    @JoinColumn(name = "id_ser", nullable = false)
    private Services service;
	
    private String client_name;
    private String client_review;
    private int nb_stars;	
   	
    public Reviews() {}
    
    public Reviews(Long id_review, Services service, String client_name, String client_review, int nb_stars) {
        this.id_review = id_review;
        this.service = service;
        this.client_name = client_name;
        this.client_review = client_review;
        this.nb_stars = nb_stars;
    }

    public Reviews(Services service, String client_name, String client_review, int nb_stars) {
        this.service = service;
        this.client_name = client_name;
        this.client_review = client_review;
        this.nb_stars = nb_stars;
    }

    public Long getId_review() {
        return this.id_review;
    }

    public void setId_review(Long id_review) {
        this.id_review = id_review;
    }

    public Services getService() {
        return this.service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public String getClient_name() {
        return this.client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_review() {
        return this.client_review;
    }

    public void setClient_review(String client_review) {
        this.client_review = client_review;
    }

    public int getNb_stars() {
        return this.nb_stars;
    }

    public void setNb_stars(int nb_stars) {
        this.nb_stars = nb_stars;
    }

    @Override
    public String toString() {
        return "{" +
            " id_review='" + getId_review() + "'" +
            ", service='" + getService() + "'" +
            ", client_name='" + getClient_name() + "'" +
            ", client_review='" + getClient_review() + "'" +
            ", nb_stars='" + getNb_stars() + "'" +
            "}";
    }
    

}
