package com.heyeriic.orderofserviceapp.domain.client;

import com.heyeriic.orderofserviceapp.domain.client.payload.request.CreateClientRequest;
import com.heyeriic.orderofserviceapp.domain.client.payload.response.ClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> save(@RequestBody CreateClientRequest clientRequest) {
        ClientResponse clientResponse = clientService.create(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getOne(@PathVariable Long id) {
        ClientResponse clientResponse = clientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(clientResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable Long id, @RequestBody CreateClientRequest clientRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.update(id, clientRequest));
    }
}
