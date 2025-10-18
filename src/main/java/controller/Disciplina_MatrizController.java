package controller;

import dto.Disciplina_MatrizCreateDTO;
import dto.Disciplina_MatrizResponseDTO;
import dto.Disciplina_MatrizUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Disciplina_MatrizService;

import java.util.List;

@RestController
@RequestMapping("/disciplina_Matriz")
public class Disciplina_MatrizController {

    @Autowired
    Disciplina_MatrizService disciplina_MatrizService;

    public Disciplina_MatrizController(Disciplina_MatrizService disciplina_MatrizService) {
        this.disciplina_MatrizService = disciplina_MatrizService;
    }

    @GetMapping
    public ResponseEntity<List<Disciplina_MatrizResponseDTO>>  findAll() {
        List<Disciplina_MatrizResponseDTO> disciplina_Matriz = disciplina_MatrizService.findAll();
        return ResponseEntity.ok(disciplina_Matriz);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina_MatrizResponseDTO> findById(@PathVariable int id) {
        Disciplina_MatrizResponseDTO disciplina_Matriz = disciplina_MatrizService.findById(id);

        if (disciplina_Matriz == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(disciplina_Matriz);
    }

    @PostMapping
    public ResponseEntity<Disciplina_MatrizResponseDTO> create(@RequestBody @Valid Disciplina_MatrizCreateDTO novoDisciplina_Matriz) {
        Disciplina_MatrizResponseDTO disciplina_MatrizCriado = disciplina_MatrizService.create(novoDisciplina_Matriz);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplina_MatrizCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina_MatrizResponseDTO> update(@PathVariable int id, @RequestBody @Valid Disciplina_MatrizUpdateDTO novoDisciplina_Matriz) {
        Disciplina_MatrizResponseDTO disciplina_MatrizAtualizado = disciplina_MatrizService.update(id, novoDisciplina_Matriz);

        if (disciplina_MatrizAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(disciplina_MatrizAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Disciplina_MatrizResponseDTO> delete(@PathVariable int id){
        Disciplina_MatrizResponseDTO disciplina_Matriz = disciplina_MatrizService.findById(id);

        if (disciplina_Matriz == null) {
            return ResponseEntity.notFound().build();
        }
        disciplina_MatrizService.delete(id);
        return ResponseEntity.ok(disciplina_Matriz);
    }
}