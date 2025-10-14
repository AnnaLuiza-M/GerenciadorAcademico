package model.entities;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import org.hibernate.cache.spi.entry.StructuredCacheEntry;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nome_completo;

    @Column(unique = true)
    @Serial
    private long numero_registro;

    @NotNull
    private String escola_vinculada;

    private boolean ativo = true;

    @OneToMany(mappedBy = "professor")
    private List<ProfessorPrograma> programas = new ArrayList<>();












}
