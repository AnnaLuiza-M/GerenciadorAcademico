package br.ucsal.gerenciador.dto;

import java.util.List;

public class Matriz_CurricularUpdateDTO {

    private String nome_matriz;
    private String turno;
    private String campus;
    private String habilitacao;
    private Integer horas_complementares;
    private Integer horas_obrigatorias;
    private Integer horas_eletivas;
    private Integer horas_tcc; // Corrigido de 'horasTcc'
    private Boolean ativo;

    private List<Integer> disciplina_ids;

    public Matriz_CurricularUpdateDTO() {
    }


    public String getNome_matriz() {
        return nome_matriz;
    }

    public void setNome_matriz(String nome_matriz) {
        this.nome_matriz = nome_matriz;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }

    public Integer getHoras_complementares() {
        return horas_complementares;
    }

    public void setHoras_complementares(Integer horas_complementares) {
        this.horas_complementares = horas_complementares;
    }

    public Integer getHoras_obrigatorias() {
        return horas_obrigatorias;
    }

    public void setHoras_obrigatorias(Integer horas_obrigatorias) {
        this.horas_obrigatorias = horas_obrigatorias;
    }

    public Integer getHoras_eletivas() {
        return horas_eletivas;
    }

    public void setHoras_eletivas(Integer horas_eletivas) {
        this.horas_eletivas = horas_eletivas;
    }

    public Integer getHoras_tcc() {
        return horas_tcc;
    }

    public void setHoras_tcc(Integer horas_tcc) {
        this.horas_tcc = horas_tcc;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Integer> getDisciplina_ids() {
        return disciplina_ids;
    }

    public void setDisciplina_ids(List<Integer> disciplina_ids) {
        this.disciplina_ids = disciplina_ids;
    }
}