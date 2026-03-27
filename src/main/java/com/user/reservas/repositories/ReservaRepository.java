package com.user.reservas.repositories;

import com.user.reservas.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Aqui o Spring JPA já cria os métodos save, delete, findById etc.
}