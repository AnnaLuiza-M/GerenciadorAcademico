package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity
public class Programa_referencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne
    @JoinColumn(name = "programa_id")
    private Programa programa;

    @OneToMany(mappedBy = "programaReferencia", cascade = CascadeType.ALL)
    private List<Referencia_bibliografica> referencias_bibliograficas;



}
