package model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @OneToMany
    @JoinColumn(name="id_disciplina")
    private List<Disciplina> disciplinas;

    @NotNull
    private String ementa;

    @NotNull
    private String objetivos;

    @NotNull
    private String conteudo_programatico;

    @NotNull
    private String metodologia;

    @NotNull
    private String sistema_avaliacao;

    private boolean ativo = true;

    @OneToMany(mappedBy = "Programa")
    private List<ProfessorPrograma> professores = new ArrayList<>();

    @OneToOne(mappedBy = "Programa")
    private Programa_referencia referencia;











}
