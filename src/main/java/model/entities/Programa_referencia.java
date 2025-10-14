package model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Programa_referencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne
    @JoinColumn(name = "programa_id")
    private Programa programa;

    @OneToMany(mappedBy = "Programa_referencia")
    private List<Referencia_bibliografica> referencias_bibliograficas;



}
