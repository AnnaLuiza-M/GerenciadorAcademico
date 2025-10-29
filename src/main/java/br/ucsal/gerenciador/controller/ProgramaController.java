package br.ucsal.gerenciador.controller;

import br.ucsal.gerenciador.dto.ProgramaCreateDTO;
import br.ucsal.gerenciador.dto.ProgramaResponseDTO;
import br.ucsal.gerenciador.dto.ProgramaUpdateDTO;
import br.ucsal.gerenciador.service.ProgramaService; // Import do Service
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programa")
public class ProgramaController {

    // --- CORREÇÃO DE INJEÇÃO (MELHOR PRÁTICA) ---
    private final ProgramaService programaService;

    // Injeção de dependência apenas pelo construtor
    public ProgramaController(ProgramaService programaService) {
        this.programaService = programaService;
    }

    @GetMapping
    public ResponseEntity<List<ProgramaResponseDTO>> findAll() {
        List<ProgramaResponseDTO> programa = programaService.findAll();
        return ResponseEntity.ok(programa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaResponseDTO> findById(@PathVariable int id) {
        // A verificação de 'null' não é mais necessária,
        // pois o service lança uma exceção se não encontrar.
        ProgramaResponseDTO programa = programaService.findById(id);
        return ResponseEntity.ok(programa);
    }

    @PostMapping
    public ResponseEntity<ProgramaResponseDTO> create(@RequestBody @Valid ProgramaCreateDTO novoPrograma) {
        ProgramaResponseDTO programaCriado = programaService.create(novoPrograma);
        return ResponseEntity.status(HttpStatus.CREATED).body(programaCriado);
    }

    // --- CORREÇÃO PRINCIPAL ---
    // 1. Anotação mudada de @PutMapping para @PatchMapping
    @PatchMapping("/{id}")
    public ResponseEntity<ProgramaResponseDTO> update(@PathVariable int id, @RequestBody @Valid ProgramaUpdateDTO novoPrograma) {
        ProgramaResponseDTO programaAtualizado = programaService.update(id, novoPrograma);
        return ResponseEntity.ok(programaAtualizado);
    }

    // --- CORREÇÃO DO DELETE (MELHOR PRÁTICA) ---

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        // O 'service.delete(id)' já contém a lógica para
        // verificar se o programa existe antes de deletar.
        programaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}