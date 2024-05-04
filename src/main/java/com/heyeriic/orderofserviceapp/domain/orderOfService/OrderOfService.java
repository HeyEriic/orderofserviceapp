package com.heyeriic.orderofserviceapp.domain.orderOfService;

import com.heyeriic.orderofserviceapp.domain.client.Client;
import com.heyeriic.orderofserviceapp.domain.service.Service;
import com.heyeriic.orderofserviceapp.domain.technician.Technician;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class OrderOfService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate openDate;
    private LocalDate closingDate;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;
    @OneToMany(mappedBy = "orderOfService")
    private List<Service> services;
    private OrderStatusEnum status;

    public OrderOfService() {
    }

    public OrderOfService(
        LocalDate openDate,
        LocalDate closingDate,
        Client client,
        Technician technician,
        List<Service> services,
        OrderStatusEnum status)
    {
        this.openDate = openDate;
        this.closingDate = closingDate;
        this.client = client;
        this.technician = technician;
        this.services = services;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }
}
