package br.ucsal.gerenciador.controller;

import br.ucsal.gerenciador.dto.Matriz_CurricularCreateDTO;
import br.ucsal.gerenciador.dto.Matriz_CurricularResponseDTO;
import br.ucsal.gerenciador.dto.Matriz_CurricularUpdateDTO;
import br.ucsal.gerenciador.service.Matriz_CurricularService; // Import do Service
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Import geral

import java.util.List;

@RestController
@RequestMapping("/matriz_curricular")
public class Matriz_CurricularController {

    // --- CORREÇÃO DE INJEÇÃO (MELHOR PRÁTICA) ---
    // 1. O service é 'final'
    // 2. O '@Autowired' no campo foi removido (redundante)
    private final Matriz_CurricularService matriz_CurricularService;

    // 3. Injeção de dependência apenas pelo construtor
    public Matriz_CurricularController(Matriz_CurricularService matriz_CurricularService) {
        this.matriz_CurricularService = matriz_CurricularService;
    }

    @GetMapping
    public ResponseEntity<List<Matriz_CurricularResponseDTO>> findAll() {
        List<Matriz_CurricularResponseDTO> matriz_Curricular = matriz_CurricularService.findAll();
        return ResponseEntity.ok(matriz_Curricular);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matriz_CurricularResponseDTO> findById(@PathVariable int id) {
        // A verificação de 'null' foi removida,
        // pois o service já lança exceção se não encontrar.
        Matriz_CurricularResponseDTO matriz_Curricular = matriz_CurricularService.findById(id);
        return ResponseEntity.ok(matriz_Curricular);
    }

    @PostMapping
    public ResponseEntity<Matriz_CurricularResponseDTO> create(@RequestBody @Valid Matriz_CurricularCreateDTO novoMatriz_Curricular) {
        Matriz_CurricularResponseDTO matriz_CurricularCriado = matriz_CurricularService.create(novoMatriz_Curricular);
        return ResponseEntity.status(HttpStatus.CREATED).body(matriz_CurricularCriado);
    }

    // --- CORREÇÃO PRINCIPAL ---
    // 4. Anotação mudada de @PutMapping para @PatchMapping
    @PatchMapping("/{id}")
    public ResponseEntity<Matriz_CurricularResponseDTO> update(@PathVariable int id, @RequestBody @Valid Matriz_CurricularUpdateDTO novoMatriz_Curricular) {
        Matriz_CurricularResponseDTO matriz_CurricularAtualizado = matriz_CurricularService.update(id, novoMatriz_Curricular);
        // A verificação de 'null' foi removida.
        return ResponseEntity.ok(matriz_CurricularAtualizado);
    }

    // --- CORREÇÃO DO DELETE (MELHOR PRÁTICA) ---

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        // O 'service.delete(id)' já contém a lógica para
        // verificar se a matriz existe antes de deletar.
        matriz_CurricularService.delete(id);
        return ResponseEntity.noContent().build();
    }
}