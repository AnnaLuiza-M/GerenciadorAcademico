package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
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

    @OneToMany(mappedBy = "programa")
    private List<ProfessorPrograma> professores = new ArrayList<>();

    @OneToOne(mappedBy = "programa")
    private Programa_referencia referencia;











}
