//package br.ucsal.gerenciador.controller;
//
//
//import br.ucsal.gerenciador.model.entities.Usuario;
//import br.ucsal.gerenciador.repository.UsuarioRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/auth")
//@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
//public class AuthController {
//
//    private final UsuarioRepository usuarioRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(request.getEmail());
//
//        if (usuarioOpt.isEmpty()) {
//            return ResponseEntity.status(401).body("Usuário não encontrado");
//        }
//
//        Usuario usuario = usuarioOpt.get();
//        if (!passwordEncoder.matches(request.getSenha(), usuario.getSenha())) {
//            return ResponseEntity.status(401).body("Senha incorreta");
//        }
//
//        return ResponseEntity.ok("Login realizado com sucesso! Bem-vindo");
//    }
//
//    public static class LoginRequest {
//        private String email;
//        private String senha;
//
//        // getters e setters obrigatórios
//        public String getEmail() { return email; }
//        public void setEmail(String email) { this.email = email; }
//        public String getSenha() { return senha; }
//        public void setSenha(String senha) { this.senha = senha; }
//    }
//}
