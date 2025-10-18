package br.ucsal.gerenciador.controller;

import br.ucsal.gerenciador.dto.ProgramaCreateDTO;
import br.ucsal.gerenciador.dto.ProgramaResponseDTO;
import br.ucsal.gerenciador.dto.ProgramaUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.ucsal.gerenciador.service.ProgramaService;

import java.util.List;

@RestController
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    ProgramaService programaService;

    public ProgramaController(ProgramaService programaService) {
        this.programaService = programaService;
    }

    @GetMapping
    public ResponseEntity<List<ProgramaResponseDTO>>  findAll() {
        List<ProgramaResponseDTO> programa = programaService.findAll();
        return ResponseEntity.ok(programa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaResponseDTO> findById(@PathVariable int id) {
        ProgramaResponseDTO programa = programaService.findById(id);

        if (programa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(programa);
    }

    @PostMapping
    public ResponseEntity<ProgramaResponseDTO> create(@RequestBody @Valid ProgramaCreateDTO novoPrograma) {
        ProgramaResponseDTO adminstradorCriado = programaService.create(novoPrograma);
        return ResponseEntity.status(HttpStatus.CREATED).body(adminstradorCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaResponseDTO> update(@PathVariable int id, @RequestBody @Valid ProgramaUpdateDTO novoPrograma) {
        ProgramaResponseDTO programaAtualizado = programaService.update(id, novoPrograma);

        if (programaAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(programaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProgramaResponseDTO> delete(@PathVariable int id){
        ProgramaResponseDTO programa = programaService.findById(id);

        if (programa == null) {
            return ResponseEntity.notFound().build();
        }
        programaService.delete(id);
        return ResponseEntity.ok(programa);
    }
}