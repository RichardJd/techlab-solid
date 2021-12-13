package com.ciandt.techlab.solid.controller;

import com.ciandt.techlab.solid.model.Client;
import com.ciandt.techlab.solid.repository.ClientRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository repository;

    @PostMapping
    public Client save(@RequestBody  Client client) {
        return repository.save(client);
    }

    @GetMapping
    public List<Client> findAll() {
        return repository.findAll();
    }
}
