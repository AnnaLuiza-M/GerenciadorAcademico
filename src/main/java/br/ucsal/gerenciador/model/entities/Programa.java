package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @OneToMany(mappedBy = "programa")
    private List<Disciplina> disciplinas = new ArrayList<>();

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

    @ManyToMany
    @JoinTable(
            name = "programa_professor", // Nome da nova tabela que será criada
            joinColumns = @JoinColumn(name = "programa_id"), // Coluna para o ID de Programa
            inverseJoinColumns = @JoinColumn(name = "professor_id") // Coluna para o ID de Professor
    )
    private List<Professor> professores;

    @OneToMany(mappedBy = "programa")
    private List<Referencia_bibliografica> referencias = new ArrayList<>(); // <-- É uma Lista


}