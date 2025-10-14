package model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Disciplina_Matriz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_matriz", nullable = false)
    private Matriz_Curricular matriz;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pre_requisito")
    private Disciplina preRequisito;

    @NotNull
    private int semestre;
}


