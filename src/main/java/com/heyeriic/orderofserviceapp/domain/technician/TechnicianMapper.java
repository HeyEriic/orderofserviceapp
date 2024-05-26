package com.heyeriic.orderofserviceapp.domain.technician;

import com.heyeriic.orderofserviceapp.domain.technician.payload.request.CreateTechnicianRequest;
import com.heyeriic.orderofserviceapp.domain.technician.payload.response.TechnicianResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnicianMapper {
    Technician toEntity(CreateTechnicianRequest technicianRequest);
    TechnicianResponse toDto(Technician technician);
    List<TechnicianResponse> toDto(List<Technician> technicians);
}
