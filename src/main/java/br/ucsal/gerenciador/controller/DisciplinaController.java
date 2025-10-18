package br.ucsal.gerenciador.controller;

import br.ucsal.gerenciador.dto.DisciplinaCreateDTO;
import br.ucsal.gerenciador.dto.DisciplinaResponseDTO;
import br.ucsal.gerenciador.dto.DisciplinaUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.ucsal.gerenciador.service.DisciplinaService;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>>  findAll() {
        List<DisciplinaResponseDTO> disciplina = disciplinaService.findAll();
        return ResponseEntity.ok(disciplina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> findById(@PathVariable int id) {
        DisciplinaResponseDTO disciplina = disciplinaService.findById(id);

        if (disciplina == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(disciplina);
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> create(@RequestBody @Valid DisciplinaCreateDTO novoDisciplina) {
        DisciplinaResponseDTO disciplinaCriado = disciplinaService.create(novoDisciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> update(@PathVariable int id, @RequestBody @Valid DisciplinaUpdateDTO novoDisciplina) {
        DisciplinaResponseDTO disciplinaAtualizado = disciplinaService.update(id, novoDisciplina);

        if (disciplinaAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(disciplinaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> delete(@PathVariable int id){
        DisciplinaResponseDTO disciplina = disciplinaService.findById(id);

        if (disciplina == null) {
            return ResponseEntity.notFound().build();
        }
        disciplinaService.delete(id);
        return ResponseEntity.ok(disciplina);
    }
}