package com.user.reservas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id") // Isso cria a FK (Chave Estrangeira)
    private Usuario usuario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sala_id") // Isso cria a FK (Chave Estrangeira)
    private Sala sala;

    @NotNull
    private LocalDateTime inicio;

    @NotNull
    private LocalDateTime fim;

    public Reserva() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }
    public LocalDateTime getInicio() { return inicio; }
    public void setInicio(LocalDateTime inicio) { this.inicio = inicio; }
    public LocalDateTime getFim() { return fim; }
    public void setFim(LocalDateTime fim) { this.fim = fim; }
}