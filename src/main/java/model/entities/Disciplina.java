package model.entities;

import jakarta.persistence.*;
import model.enums.Classificacao_disciplina;
import model.enums.Tipo_disciplina;
import jakarta.validation.constraints.NotNull;



@Entity
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
