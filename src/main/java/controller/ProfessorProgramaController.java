package controller;

import dto.ProfessorProgramaCreateDTO;
import dto.ProfessorProgramaResponseDTO;
import dto.ProfessorProgramaUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProfessorProgramaService;

import java.util.List;

@RestController
@RequestMapping("/professorPrograma")
public class ProfessorProgramaController {

    @Autowired
    ProfessorProgramaService professorProgramaService;

    public ProfessorProgramaController(ProfessorProgramaService professorProgramaService) {
        this.professorProgramaService = professorProgramaService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorProgramaResponseDTO>>  findAll() {
        List<ProfessorProgramaResponseDTO> professorProgramas = professorProgramaService.findAll();
        return ResponseEntity.ok(professorProgramas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorProgramaResponseDTO> findById(@PathVariable int id) {
        ProfessorProgramaResponseDTO professorPrograma = professorProgramaService.findById(id);

        if (professorPrograma == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(professorPrograma);
    }

    @PostMapping
    public ResponseEntity<ProfessorProgramaResponseDTO> create(@RequestBody @Valid ProfessorProgramaCreateDTO novoProfessorPrograma) {
        ProfessorProgramaResponseDTO adminstradorCriado = professorProgramaService.create(novoProfessorPrograma);
        return ResponseEntity.status(HttpStatus.CREATED).body(adminstradorCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorProgramaResponseDTO> update(@PathVariable int id, @RequestBody @Valid ProfessorProgramaUpdateDTO novoProfessorPrograma) {
        ProfessorProgramaResponseDTO professorProgramaAtualizado = professorProgramaService.update(id, novoProfessorPrograma);

        if (professorProgramaAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(professorProgramaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfessorProgramaResponseDTO> delete(@PathVariable int id){
        ProfessorProgramaResponseDTO professorPrograma = professorProgramaService.findById(id);

        if (professorPrograma == null) {
            return ResponseEntity.notFound().build();
        }
        professorProgramaService.delete(id);
        return ResponseEntity.ok(professorPrograma);
    }
}