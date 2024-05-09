package com.heyeriic.orderofserviceapp.domain.client;

import com.heyeriic.orderofserviceapp.domain.client.payload.request.CreateClientRequest;
import com.heyeriic.orderofserviceapp.domain.client.payload.response.ClientResponse;

import java.util.List;

public interface IClientService {
    ClientResponse create(CreateClientRequest clientRequest);
    ClientResponse findById(Long id);
    ClientResponse findByEmail(String email);
    List<ClientResponse> findAll();
    ClientResponse update(Long id, CreateClientRequest clientRequest);
}
