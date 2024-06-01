package com.heyeriic.orderofserviceapp.domain.technician;

import com.heyeriic.orderofserviceapp.config.error.CustomException;
import com.heyeriic.orderofserviceapp.domain.technician.payload.request.CreateTechnicianRequest;
import com.heyeriic.orderofserviceapp.domain.technician.payload.response.TechnicianResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnicianServiceImpl implements ITechnicianService {
    private final TechnicianRepository technicianRepository;
    private final TechnicianMapper technicianMapper;

    public TechnicianServiceImpl(TechnicianRepository technicianRepository, TechnicianMapper technicianMapper) {
        this.technicianRepository = technicianRepository;
        this.technicianMapper = technicianMapper;
    }

    @Override
    public TechnicianResponse create(CreateTechnicianRequest technicianRequest) {
        Technician technician = technicianMapper.toEntity(technicianRequest);
        checkIfTechnicianExist(technician.getDocument());
        return technicianMapper.toDto(technicianRepository.save(technician));
    }

    @Override
    public TechnicianResponse findById(Long id) {
        return technicianMapper.toDto(findTechnicianById(id));
    }

    @Override
    public TechnicianResponse findByDocument(String document) {
        return technicianMapper.toDto(findTechnicianByDocument(document));
    }

    @Override
    public List<TechnicianResponse> findAll() {
        Page<Technician> technicians = technicianRepository.findAll(
                PageRequest.of(0, 20, Sort.by("id"))
        );
        return technicians
                .stream()
                .map(technicianMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TechnicianResponse update(Long id, CreateTechnicianRequest technicianRequest) {
        Technician technician = findTechnicianById(id);
        BeanUtils.copyProperties(technicianRequest, technician, "id");
        return technicianMapper.toDto(technicianRepository.save(technician));
    }

    private void checkIfTechnicianExist(String document) {
        Technician technician = technicianRepository.findByDocument(document);
        if (technician != null) {
            throw new CustomException("technician already exists", HttpStatus.CONFLICT);
        }
    }

    private Technician findTechnicianById(Long id) {
        return technicianRepository.findById(id)
                .orElseThrow(
                        () -> new CustomException("technician not found", HttpStatus.NOT_FOUND)
                );
    }

    private Technician findTechnicianByDocument(String document) {
        Technician technician = technicianRepository.findByDocument(document);
        if (technician == null) {
            throw new CustomException("technician not found", HttpStatus.NOT_FOUND);
        }
        return technician;
    }
}
