package br.ucsal.gerenciador.controller;

import br.ucsal.gerenciador.dto.Matriz_CurricularCreateDTO;
import br.ucsal.gerenciador.dto.Matriz_CurricularResponseDTO;
import br.ucsal.gerenciador.dto.Matriz_CurricularUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.ucsal.gerenciador.service.Matriz_CurricularService;

import java.util.List;

@RestController
@RequestMapping("/Matrizes_Curricular")
public class Matriz_CurricularController {

    @Autowired
    Matriz_CurricularService matriz_CurricularService;

    public Matriz_CurricularController(Matriz_CurricularService Matriz_CurricularService) {
        this.matriz_CurricularService = Matriz_CurricularService;
    }

    @GetMapping
    public ResponseEntity<List<Matriz_CurricularResponseDTO>>  findAll() {
        List<Matriz_CurricularResponseDTO> matriz_Curricular = matriz_CurricularService.findAll();
        return ResponseEntity.ok(matriz_Curricular);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matriz_CurricularResponseDTO> findById(@PathVariable int id) {
        Matriz_CurricularResponseDTO matriz_Curricular = matriz_CurricularService.findById(id);

        if (matriz_Curricular == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matriz_Curricular);
    }

    @PostMapping
    public ResponseEntity<Matriz_CurricularResponseDTO> create(@RequestBody @Valid Matriz_CurricularCreateDTO novoMatriz_Curricular) {
        Matriz_CurricularResponseDTO matriz_CurricularCriado = matriz_CurricularService.create(novoMatriz_Curricular);
        return ResponseEntity.status(HttpStatus.CREATED).body(matriz_CurricularCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matriz_CurricularResponseDTO> update(@PathVariable int id, @RequestBody @Valid Matriz_CurricularUpdateDTO novoMatriz_Curricular) {
        Matriz_CurricularResponseDTO matriz_CurricularAtualizado = matriz_CurricularService.update(id, novoMatriz_Curricular);

        if (matriz_CurricularAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matriz_CurricularAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Matriz_CurricularResponseDTO> delete(@PathVariable int id){
        Matriz_CurricularResponseDTO matriz_Curricular = matriz_CurricularService.findById(id);

        if (matriz_Curricular == null) {
            return ResponseEntity.notFound().build();
        }
        matriz_CurricularService.delete(id);
        return ResponseEntity.ok(matriz_Curricular);
    }
}