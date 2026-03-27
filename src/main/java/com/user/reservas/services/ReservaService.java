package com.user.reservas.services;

import com.user.reservas.models.Reserva;
import com.user.reservas.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    /**
     * Guarda uma reserva após validar se o horário está disponível.
     */
    public Reserva salvarReserva(Reserva novaReserva) {
        List<Reserva> reservasExistentes = reservaRepository.findAll();

        for (Reserva existente : reservasExistentes) {
            // Verifica se é a mesma sala
            if (existente.getSala().getId().equals(novaReserva.getSala().getId())) {
                
                // Lógica de conflito: (Início A < Fim B) E (Fim A > Início B)
                boolean conflito = novaReserva.getInicio().isBefore(existente.getFim()) &&
                                 novaReserva.getFim().isAfter(existente.getInicio());

                if (conflito) {
                    throw new RuntimeException("Conflito: A sala já está reservada para este período.");
                }
            }
        }

        return reservaRepository.save(novaReserva);
    }

    /**
     * Lista todas as reservas registadas.
     */
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }
}