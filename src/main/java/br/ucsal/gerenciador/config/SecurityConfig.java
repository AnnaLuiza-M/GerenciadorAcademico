package br.ucsal.gerenciador.config;

import br.ucsal.gerenciador.service.UsuarioDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // permite @PreAuthorize nos controllers
@RequiredArgsConstructor
public class SecurityConfig {

    private final UsuarioDetailsService usuarioDetailsService;

    // 🔒 Configuração principal do Spring Security
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desativa CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        // 🔓 Endpoints públicos (ex: login, Swagger, etc.)
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

                        // 🔐 Acesso restrito por papel (ROLE)
//                        .requestMatchers("/professor/**").hasRole("ADMINISTRADOR")
                                .requestMatchers("/professor/**").hasAuthority("ROLE_ADMINISTRADOR")

//                        .requestMatchers("/api/professor/**").hasAnyRole("PROFESSOR", "ADMINISTRADOR")

                        // Tudo o mais precisa estar autenticado
                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> {}); // ativa Basic Auth

        return http.build();
    }

    // 🔐 Encoder de senhas (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // ⚙️ Authentication Manager padrão
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // Garante que o serviço de usuários do Spring Security use o nosso
    @Bean
    public UserDetailsService userDetailsService() {
        return usuarioDetailsService;
    }
}
