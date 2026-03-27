package com.user.reservas;

import com.user.reservas.models.Sala;
import com.user.reservas.models.Usuario;
import com.user.reservas.repositories.SalaRepository;
import com.user.reservas.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository uRepo, SalaRepository sRepo) {
        return args -> {
            Usuario u = new Usuario();
            u.setNome("Usuario Teste");
            u.setEmail("teste@email.com");
            u.setSenha("123456");
            uRepo.save(u);

            Sala s = new Sala();
            s.setNome("Sala de Reunião A");
            s.setCapacidade(10);
            sRepo.save(s);
            
            System.out.println("Dados de teste inseridos com sucesso!");
        };
    }
}