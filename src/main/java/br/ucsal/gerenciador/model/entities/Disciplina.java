package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;
import br.ucsal.gerenciador.model.enums.Classificacao_disciplina;
import br.ucsal.gerenciador.model.enums.Tipo_disciplina;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull
    @Column(length = 20, nullable = false, unique = true)
    private String sigla;

    @NotNull
    private String descricao;

    @NotNull
    private int carga_horaria;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Tipo_disciplina tipo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Classificacao_disciplina classificacao;

    private boolean ativo = true;

}
