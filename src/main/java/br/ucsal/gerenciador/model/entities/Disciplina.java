package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;
import br.ucsal.gerenciador.model.enums.Classificacao_disciplina;
import br.ucsal.gerenciador.model.enums.Tipo_disciplina;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Importa a entidade Programa para criar o relacionamento
import br.ucsal.gerenciador.model.entities.Programa;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_disciplina;


    @NotNull
    @Column(length = 20, nullable = false, unique = true)
    private String sigla;

    @NotNull
    private String descricao;


    @NotNull
    @Column(name = "carga_horaria")
    private int carga_horaria;


    @NotNull
    @Enumerated(EnumType.STRING)
    private Tipo_disciplina tipo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Classificacao_disciplina classificacao;

    private boolean ativo = true;


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programa_id")
    private Programa programa;

    @ManyToMany(mappedBy = "disciplinas")
    private List<Matriz_Curricular> matrizesCurriculares;
}