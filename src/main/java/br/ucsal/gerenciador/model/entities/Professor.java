package br.ucsal.gerenciador.model.entities;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome_completo;

    @Column(unique = true)
    @Serial
    private long numero_registro;

    @Column(nullable = false)
    private String escola_vinculada;

    private boolean ativo = true;

    @OneToMany(mappedBy = "professor")
    private List<ProfessorPrograma> programas = new ArrayList<>();












}
