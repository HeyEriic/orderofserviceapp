package com.heyeriic.orderofserviceapp.domain.technician;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    Technician findByDocument(String document);
}
