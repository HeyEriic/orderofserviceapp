package com.heyeriic.orderofserviceapp.domain.technician;

import com.heyeriic.orderofserviceapp.domain.technician.payload.request.CreateTechnicianRequest;
import com.heyeriic.orderofserviceapp.domain.technician.payload.response.TechnicianResponse;

import java.util.List;

public interface ITechnicianService {
    TechnicianResponse create(CreateTechnicianRequest technicianRequest);
    TechnicianResponse findById(Long id);
    TechnicianResponse findByDocument(String document);
    List<TechnicianResponse> findAll();
    TechnicianResponse update(Long id, CreateTechnicianRequest technicianRequest);
}
