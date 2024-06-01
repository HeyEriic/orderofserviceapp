package com.heyeriic.orderofserviceapp.domain.technician;

import com.heyeriic.orderofserviceapp.domain.technician.payload.request.CreateTechnicianRequest;
import com.heyeriic.orderofserviceapp.domain.technician.payload.response.TechnicianResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/technicians")
public class TechnicianController {
    private final ITechnicianService technicianService;

    public TechnicianController(ITechnicianService technicianService) {
        this.technicianService = technicianService;
    }

    @PostMapping
    public ResponseEntity<TechnicianResponse> save(@RequestBody CreateTechnicianRequest technicianRequest) {
        TechnicianResponse technicianResponse = technicianService.create(technicianRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(technicianResponse);
    }

    @GetMapping
    public ResponseEntity<List<TechnicianResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(technicianService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicianResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(technicianService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TechnicianResponse> update(
            @PathVariable Long id, @RequestBody CreateTechnicianRequest technicianRequest
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(technicianService.update(id, technicianRequest));
    }
}
