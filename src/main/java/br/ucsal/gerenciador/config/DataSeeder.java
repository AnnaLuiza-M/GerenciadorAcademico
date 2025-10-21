package br.ucsal.gerenciador.config;


import br.ucsal.gerenciador.model.entities.Administrador;
import br.ucsal.gerenciador.model.enums.Role;
import br.ucsal.gerenciador.repository.AdministradorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder {

    @Bean
    CommandLineRunner initAdmin(AdministradorRepository administradorRepository, PasswordEncoder encoder) {
        return args -> {
            // Evita duplicar o admin se já existir
            if (administradorRepository.count() == 0) {
                Administrador admin = new Administrador();
                admin.setEmail("admin@ucsal.br");
                admin.setSenha(encoder.encode("admin123"));
                admin.setNome_completo("Administrador Padrão");
                admin.setRole(Role.ROLE_ADMINISTRADOR);

                administradorRepository.save(admin);

            }
        };
    }
}