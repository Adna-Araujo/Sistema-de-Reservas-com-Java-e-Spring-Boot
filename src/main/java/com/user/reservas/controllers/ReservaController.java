package com.user.reservas.controllers;

import com.user.reservas.models.Reserva;
import com.user.reservas.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> criar(@RequestBody Reserva reserva) {
        // O Service cuidará da lógica de conflito de horários
        Reserva novaReserva = reservaService.salvarReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReserva);
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listarTodas();
    }
}