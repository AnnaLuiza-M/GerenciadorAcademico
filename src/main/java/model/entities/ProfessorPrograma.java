package model.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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
