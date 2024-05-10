package com.heyeriic.orderofserviceapp.domain.client;

import com.heyeriic.orderofserviceapp.domain.client.payload.request.CreateClientRequest;
import com.heyeriic.orderofserviceapp.domain.client.payload.response.ClientResponse;
import com.heyeriic.orderofserviceapp.domain.config.error.CustomException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements IClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientResponse create(CreateClientRequest clientRequest) {
        Client client = clientMapper.toEntity(clientRequest);
        checkIfClientAlreadyExist(client.getEmail());
        return clientMapper.toDto(clientRepository.save(client));
    }

    @Override
    public ClientResponse findById(Long id) {
        return clientMapper.toDto(findClientById(id));
    }

    @Override
    public ClientResponse findByEmail(String email) {
        return clientMapper.toDto(findClientByEmail(email));
    }

    @Override
    public List<ClientResponse> findAll() {
        Page<Client> clients = clientRepository.findAll(
                PageRequest.of(0, 20, Sort.by("name"))
        );
        return clients
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse update(Long id, CreateClientRequest clientRequest) {
        Client client = findClientById(id);
        BeanUtils.copyProperties(clientRequest, client, "id");
        return clientMapper.toDto(clientRepository.save(client));
    }

    private Client findClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(
                        () -> new CustomException("client not found", HttpStatus.NOT_FOUND)
                );
    }

    private Client findClientByEmail(String email) {
        Client client = clientRepository.findByEmail(email);
        if (client == null) {
            throw new CustomException("client not found", HttpStatus.NOT_FOUND);
        }
        return client;
    }

    private void checkIfClientAlreadyExist(String email) {
        Client client = clientRepository.findByEmail(email);
        if (client != null) {
            throw new CustomException("client already registered.", HttpStatus.CONFLICT);
        }
    }
}
