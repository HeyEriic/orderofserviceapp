package com.heyeriic.orderofserviceapp.domain.client;

import com.heyeriic.orderofserviceapp.domain.client.payload.request.CreateClientRequest;
import com.heyeriic.orderofserviceapp.domain.client.payload.response.ClientResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toEntity(CreateClientRequest clientRequest);
    ClientResponse toDto(Client client);
    List<ClientResponse> toDto(List<Client> clients);
}
