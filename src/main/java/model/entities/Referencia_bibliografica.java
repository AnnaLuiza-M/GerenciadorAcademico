package model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import model.enums.Categoria_referencia;
import model.enums.Tipo_referencia;

import java.time.LocalDate;

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
