package br.ucsal.gerenciador.controller;

import br.ucsal.gerenciador.dto.ProfessorCreateDTO;
import br.ucsal.gerenciador.dto.ProfessorResponseDTO;
import br.ucsal.gerenciador.dto.ProfessorUpdateDTO;
import br.ucsal.gerenciador.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Import geral

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    // --- CORREÇÃO DE INJEÇÃO (MELHOR PRÁTICA) ---
    // 1. O service agora é 'final' (mais seguro)
    // 2. A anotação '@Autowired' no campo foi removida (redundante)
    private final ProfessorService professorService;

    // 3. A injeção é feita apenas pelo construtor (forma preferida do Spring)
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> findAll() {
        List<ProfessorResponseDTO> professor = professorService.findAll();
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> findById(@PathVariable int id) {
        // O service já lança exceção se não encontrar,
        // então não precisamos verificar 'null' aqui.
        ProfessorResponseDTO professor = professorService.findById(id);
        return ResponseEntity.ok(professor);
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> create(@RequestBody @Valid ProfessorCreateDTO novoProfessor) {
        ProfessorResponseDTO professorCriado = professorService.create(novoProfessor);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorCriado);
    }

    // --- CORREÇÃO PRINCIPAL ---
    // 4. Anotação mudada de @PutMapping para @PatchMapping
    @PatchMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> update(@PathVariable int id, @RequestBody @Valid ProfessorUpdateDTO novoProfessor) {
        ProfessorResponseDTO professorAtualizado = professorService.update(id, novoProfessor);
        // A verificação de 'null' foi removida pois o service
        // já lança exceção se o professor com 'id' não for encontrado.
        return ResponseEntity.ok(professorAtualizado);
    }

    // --- CORREÇÃO DO DELETE (MELHOR PRÁTICA) ---

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        // O 'service.delete(id)' já contém a lógica para
        // verificar se o professor existe antes de deletar.
        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}