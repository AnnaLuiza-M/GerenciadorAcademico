package br.ucsal.gerenciador.controller;

import br.ucsal.gerenciador.dto.DisciplinaCreateDTO;
import br.ucsal.gerenciador.dto.DisciplinaResponseDTO;
import br.ucsal.gerenciador.dto.DisciplinaUpdateDTO;
import br.ucsal.gerenciador.service.DisciplinaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {


    private final DisciplinaService disciplinaService;


    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>> findAll() {
        List<DisciplinaResponseDTO> disciplina = disciplinaService.findAll();
        return ResponseEntity.ok(disciplina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> findById(@PathVariable int id) {

        DisciplinaResponseDTO disciplina = disciplinaService.findById(id);
        return ResponseEntity.ok(disciplina);
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> create(@RequestBody @Valid DisciplinaCreateDTO novoDisciplina) {
        DisciplinaResponseDTO disciplinaCriado = disciplinaService.create(novoDisciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaCriado);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> update(@PathVariable int id, @RequestBody @Valid DisciplinaUpdateDTO novoDisciplina) {
        DisciplinaResponseDTO disciplinaAtualizado = disciplinaService.update(id, novoDisciplina);

        return ResponseEntity.ok(disciplinaAtualizado);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {

        disciplinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}