package com.back.backend.controller;

import com.back.backend.model.Client;
import com.back.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")

public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping()
    public ResponseEntity<List<Client>> getAll() {

        return ResponseEntity.ok().body(clientService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientService.createClient(client);
        return ResponseEntity.ok(createdClient);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client updateClient = clientService.updateClient(id, client);
        return ResponseEntity.ok(updateClient);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientService.ClientdeleteClient(id);
        return ResponseEntity.noContent().build();
    }

}
