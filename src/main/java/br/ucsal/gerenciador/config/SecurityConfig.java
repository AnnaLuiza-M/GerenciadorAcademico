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
@EnableMethodSecurity // permite usar @PreAuthorize nos controllers
@RequiredArgsConstructor
public class SecurityConfig {

    private final UsuarioDetailsService usuarioDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desativa CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        // Endpoints públicos (ex: Swagger)
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

                        // Acesso restrito por papel (ROLE)
                        .requestMatchers("/professor/**").hasRole("ADMINISTRADOR")
                        .requestMatchers("/programa/**").hasAnyRole("PROFESSOR", "ADMINISTRADOR")

                        // Tudo o mais precisa estar autenticado
                        .anyRequest().permitAll()
                )
                .httpBasic(basic -> {}); // ativa autenticação Basic Auth

        return http.build();
    }

    // Encoder de senhas (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager padrão
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // Serviço de usuários personalizado
    @Bean
    public UserDetailsService userDetailsService() {
        return usuarioDetailsService;
    }
}
