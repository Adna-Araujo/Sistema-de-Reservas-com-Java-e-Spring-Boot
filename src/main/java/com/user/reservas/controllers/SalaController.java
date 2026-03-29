package com.user.reservas.controllers;

import com.user.reservas.models.Sala;
import com.user.reservas.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    @Autowired
    private SalaRepository repository;

    @GetMapping
    public List<Sala> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Sala> criar(@RequestBody Sala sala) {
        Sala novaSala = repository.save(sala);
        return ResponseEntity.ok(novaSala);
    }
}