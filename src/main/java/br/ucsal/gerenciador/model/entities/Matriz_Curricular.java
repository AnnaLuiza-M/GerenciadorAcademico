package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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

    private boolean ativo = true;

    @ManyToMany
    @JoinTable(
            name = "matriz_disciplina",
            joinColumns = @JoinColumn(name = "matriz_curricular_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "disciplina_id",
                    referencedColumnName = "id_disciplina"
            )
    )
    private List<Disciplina> disciplinas; // O nome do campo é 'professores' (plural)





}
