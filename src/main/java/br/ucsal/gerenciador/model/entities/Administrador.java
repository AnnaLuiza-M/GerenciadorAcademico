package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Administrador extends Usuario {

    @Column(nullable = false)
    private String nome_completo;

    @Column(unique = true)
    @Serial
    private long numero_registro;

}
