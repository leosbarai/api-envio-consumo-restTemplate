package com.example.demo.consumo.controller;

import com.example.demo.consumo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumo")
public class ConsumoController {

    private final RestTemplate restTemplate;

    @Autowired
    public ConsumoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<Person> getPerson(@RequestBody Person person) {
        String url = "http://localhost:8080/envio";
        ResponseEntity<Person> response = restTemplate.postForEntity(url, person, Person.class);
        return ResponseEntity.ok(response.getBody());
    }
}
