package controller;

import dto.Programa_referenciaCreateDTO;
import dto.Programa_referenciaResponseDTO;
import dto.Programa_referenciaUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Programa_referenciaService;

import java.util.List;

@RestController
@RequestMapping("/programa_referencia")
public class Programa_referenciaController {

    @Autowired
    Programa_referenciaService programa_referenciaService;

    public Programa_referenciaController(Programa_referenciaService programa_referenciaService) {
        this.programa_referenciaService = programa_referenciaService;
    }

    @GetMapping
    public ResponseEntity<List<Programa_referenciaResponseDTO>>  findAll() {
        List<Programa_referenciaResponseDTO> programa_referencia = programa_referenciaService.findAll();
        return ResponseEntity.ok(programa_referencia);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Programa_referenciaResponseDTO> findById(@PathVariable int id) {
        Programa_referenciaResponseDTO programa_referencia = programa_referenciaService.findById(id);

        if (programa_referencia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(programa_referencia);
    }

    @PostMapping
    public ResponseEntity<Programa_referenciaResponseDTO> create(@RequestBody @Valid Programa_referenciaCreateDTO novoPrograma_referencia) {
        Programa_referenciaResponseDTO adminstradorCriado = programa_referenciaService.create(novoPrograma_referencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(adminstradorCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Programa_referenciaResponseDTO> update(@PathVariable int id, @RequestBody @Valid Programa_referenciaUpdateDTO novoPrograma_referencia) {
        Programa_referenciaResponseDTO programa_referenciaAtualizado = programa_referenciaService.update(id, novoPrograma_referencia);

        if (programa_referenciaAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(programa_referenciaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Programa_referenciaResponseDTO> delete(@PathVariable int id){
        Programa_referenciaResponseDTO programa_referencia = programa_referenciaService.findById(id);

        if (programa_referencia == null) {
            return ResponseEntity.notFound().build();
        }
        programa_referenciaService.delete(id);
        return ResponseEntity.ok(programa_referencia);
    }
}