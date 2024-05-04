package com.heyeriic.orderofserviceapp.domain.technician;

import com.heyeriic.orderofserviceapp.domain.orderOfService.OrderOfService;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialty;
    @Column(unique = true)
    private String document;
    @OneToMany(mappedBy = "technician")
    private List<OrderOfService> orderOfServices;

    public Technician() {
    }

    public Technician(
        String name,
        String specialty,
        String document,
        List<OrderOfService> orderOfServices
    ) {
        this.name = name;
        this.specialty = specialty;
        this.document = document;
        this.orderOfServices = orderOfServices;
    }

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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public List<OrderOfService> getOrderOfServices() {
        return orderOfServices;
    }

    public void setOrderOfServices(List<OrderOfService> orderOfServices) {
        this.orderOfServices = orderOfServices;
    }
}
