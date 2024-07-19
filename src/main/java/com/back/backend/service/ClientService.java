package com.back.backend.service;

import com.back.backend.model.Client;
import com.back.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<Client> getAll() {

        return repository.findAll();
    }

    // Método para criar um novo cliente
    public Client createClient(Client client) {

        return repository.save(client);
    }

    public Client updateClient(Long id, Client clientDetails) {
        Optional<Client> optionalClient = repository.findById(id);

        if (((Optional<?>) optionalClient).isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setNome(clientDetails.getNome());
            existingClient.setTipo(clientDetails.getTipo());
            existingClient.setGenero(clientDetails.getGenero());
            existingClient.setDataNascimento(clientDetails.getDataNascimento());
            existingClient.setObservacao(clientDetails.getObservacao());
            existingClient.setInativo(clientDetails.isInativo());

            return repository.save(existingClient);
        } else {
            // Lidar com o caso onde o cliente com o ID fornecido não existe
            throw new RuntimeException("Client not found with id " + id);
        }
    }

    public void ClientdeleteClient(Long id) {
        Optional<Client> optionalClient = repository.findById(id);
        if (optionalClient.isPresent()) {
            repository.deleteById(id);
        } else {
            // Lidar com o caso onde o cliente com o ID fornecido não existe
            throw new RuntimeException("Client not found with id " + id);
        }
    }

}


