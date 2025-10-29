package br.ucsal.gerenciador.controller;

import br.ucsal.gerenciador.dto.Referencia_bibliograficaCreateDTO;
import br.ucsal.gerenciador.dto.Referencia_bibliograficaResponseDTO;
import br.ucsal.gerenciador.dto.Referencia_bibliograficaUpdateDTO;
import br.ucsal.gerenciador.service.Referencia_bibliograficaService; // Import do Service
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Import geral

import java.util.List;

@RestController
@RequestMapping("/referencia_bibliografica") // Mantido o endpoint original
public class Referencia_bibliograficaController {

    // --- CORREÇÃO DE INJEÇÃO (MELHOR PRÁTICA) ---
    private final Referencia_bibliograficaService referencia_bibliograficaService;

    // Injeção de dependência apenas pelo construtor
    public Referencia_bibliograficaController(Referencia_bibliograficaService referencia_bibliograficaService) {
        this.referencia_bibliograficaService = referencia_bibliograficaService;
    }

    @GetMapping
    public ResponseEntity<List<Referencia_bibliograficaResponseDTO>> findAll() {
        List<Referencia_bibliograficaResponseDTO> referencia_bibliografica = referencia_bibliograficaService.findAll();
        return ResponseEntity.ok(referencia_bibliografica);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Referencia_bibliograficaResponseDTO> findById(@PathVariable int id) {
        // A verificação de 'null' foi removida,
        // pois o service já lança exceção se não encontrar.
        Referencia_bibliograficaResponseDTO referencia_bibliografica = referencia_bibliograficaService.findById(id);
        return ResponseEntity.ok(referencia_bibliografica);
    }

    @PostMapping
    public ResponseEntity<Referencia_bibliograficaResponseDTO> create(@RequestBody @Valid Referencia_bibliograficaCreateDTO novoReferencia_bibliografica) {
        Referencia_bibliograficaResponseDTO referenciaCriada = referencia_bibliograficaService.create(novoReferencia_bibliografica);
        return ResponseEntity.status(HttpStatus.CREATED).body(referenciaCriada);
    }

    // --- CORREÇÃO PRINCIPAL ---
    // 1. Anotação mudada de @PutMapping para @PatchMapping
    @PatchMapping("/{id}")
    public ResponseEntity<Referencia_bibliograficaResponseDTO> update(@PathVariable int id, @RequestBody @Valid Referencia_bibliograficaUpdateDTO novoReferencia_bibliografica) {
        Referencia_bibliograficaResponseDTO referenciaAtualizada = referencia_bibliograficaService.update(id, novoReferencia_bibliografica);
        // A verificação de 'null' foi removida.
        return ResponseEntity.ok(referenciaAtualizada);
    }

    // --- CORREÇÃO DO DELETE (MELHOR PRÁTICA) ---

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        // O 'service.delete(id)' já contém a lógica para
        // verificar se a referência existe antes de deletar.
        referencia_bibliograficaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}