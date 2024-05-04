package com.heyeriic.orderofserviceapp.domain.client;

import com.heyeriic.orderofserviceapp.domain.orderOfService.OrderOfService;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "client")
    private List<OrderOfService> orderOfServices;

    public Client () {
    }

    public Client(
        String name,
        String address,
        String phone,
        String email,
        List<OrderOfService> orderOfServices
    ) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderOfService> getOrderOfServices() {
        return orderOfServices;
    }

    public void setOrderOfServices(List<OrderOfService> orderOfServices) {
        this.orderOfServices = orderOfServices;
    }
}
