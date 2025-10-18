package controller;

import dto.ProfessorCreateDTO;
import dto.ProfessorResponseDTO;
import dto.ProfessorUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProfessorService;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>>  findAll() {
        List<ProfessorResponseDTO> professor = professorService.findAll();
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> findById(@PathVariable int id) {
        ProfessorResponseDTO professor = professorService.findById(id);

        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(professor);
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> create(@RequestBody @Valid ProfessorCreateDTO novoProfessor) {
        ProfessorResponseDTO professorCriado = professorService.create(novoProfessor);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> update(@PathVariable int id, @RequestBody @Valid ProfessorUpdateDTO novoProfessor) {
        ProfessorResponseDTO professorAtualizado = professorService.update(id, novoProfessor);

        if (professorAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(professorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> delete(@PathVariable int id){
        ProfessorResponseDTO professor = professorService.findById(id);

        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        professorService.delete(id);
        return ResponseEntity.ok(professor);
    }
}