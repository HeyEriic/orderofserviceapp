package com.heyeriic.orderofserviceapp.domain.service;

import com.heyeriic.orderofserviceapp.domain.orderOfService.OrderOfService;
import jakarta.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "order_of_service_id")
    private OrderOfService orderOfService;

    public Service() {
    }

    public Service(String description, Double price) {
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
