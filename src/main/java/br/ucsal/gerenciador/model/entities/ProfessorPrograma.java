package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
public class ProfessorPrograma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_professor", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "id_programa", nullable = false)
    private Programa programa;

    private LocalDateTime dataInicioEdicao = LocalDateTime.now();
    private LocalDateTime dataFimEdicao;
    private String alteracoes;


}
