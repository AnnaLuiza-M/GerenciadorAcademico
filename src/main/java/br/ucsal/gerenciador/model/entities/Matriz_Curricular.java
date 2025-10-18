package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Matriz_Curricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nome_matriz;

    @NotNull
    private String turno;

    @NotNull
    private String campus;

    @NotNull
    private String habilitacao;

    @NotNull
    private int horas_complementares;

    @NotNull
    private int horas_obrigatorias;

    @NotNull
    private int horas_eletivas;

    @NotNull
    private int horas_tcc;







}
