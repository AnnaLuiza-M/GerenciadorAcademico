package br.ucsal.gerenciador.dto;

import jakarta.validation.constraints.NotNull;

public class Disciplina_MatrizCreateDTO {

    @NotNull
    private int idMatriz;

    @NotNull
    private int idDisciplina;

    private Integer idPreRequisito; // opcional

    @NotNull
    private int semestre;

    public Disciplina_MatrizCreateDTO() {}

    public int getIdMatriz() {
        return idMatriz;
    }

    public void setIdMatriz(int idMatriz) {
        this.idMatriz = idMatriz;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Integer getIdPreRequisito() {
        return idPreRequisito;
    }

    public void setIdPreRequisito(Integer idPreRequisito) {
        this.idPreRequisito = idPreRequisito;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
