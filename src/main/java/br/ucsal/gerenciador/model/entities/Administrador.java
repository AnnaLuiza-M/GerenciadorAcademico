package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Entity
@NoArgsConstructor
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nome_completo;

    @Column(unique = true)
    @Serial
    private long numero_registro;

}
