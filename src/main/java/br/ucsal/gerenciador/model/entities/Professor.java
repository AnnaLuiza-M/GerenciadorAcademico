package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serial;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Professor extends Usuario {

    @Column(nullable = false)
    private String nome_completo;

    @Column(unique = true)
    @Serial
    private long numero_registro;

    @Column(nullable = false)
    private String escola_vinculada;

    private boolean ativo = true;

    @ManyToMany(mappedBy = "professores")
    private List<Programa> programa;

}