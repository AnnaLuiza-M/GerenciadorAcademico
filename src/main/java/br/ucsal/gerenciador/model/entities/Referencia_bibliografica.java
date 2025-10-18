package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import br.ucsal.gerenciador.model.enums.Categoria_referencia;
import br.ucsal.gerenciador.model.enums.Tipo_referencia;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
public class Referencia_bibliografica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String autor;

    @NotNull
    private String titulo;

    private String edicao;
    private String local;
    private String editora;
    private Integer ano;
    private String isbn;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Tipo_referencia tipo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Categoria_referencia categoria;

    private String url;
    private LocalDate dataAcesso;

    @ManyToOne
    @JoinColumn(name = "referencia_id")
    private Programa_referencia programaReferencia;


}
