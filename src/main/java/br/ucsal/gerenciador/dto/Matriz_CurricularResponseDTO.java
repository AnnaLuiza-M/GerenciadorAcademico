package br.ucsal.gerenciador.dto;

import java.util.List;

public class Matriz_CurricularResponseDTO {

    private int id;
    private String nome_matriz;
    private String turno;
    private String campus;
    private String habilitacao;
    private boolean ativo;

    private int horas_complementares;
    private int horas_obrigatorias;
    private int horas_eletivas;
    private int horas_tcc;

    private List<Integer> disciplina_ids;

    public Matriz_CurricularResponseDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getHoras_complementares() {
        return horas_complementares;
    }

    public void setHoras_complementares(int horas_complementares) {
        this.horas_complementares = horas_complementares;
    }

    public int getHoras_obrigatorias() {
        return horas_obrigatorias;
    }

    public void setHoras_obrigatorias(int horas_obrigatorias) {
        this.horas_obrigatorias = horas_obrigatorias;
    }

    public int getHoras_eletivas() {
        return horas_eletivas;
    }

    public void setHoras_eletivas(int horas_eletivas) {
        this.horas_eletivas = horas_eletivas;
    }

    public int getHoras_tcc() {
        return horas_tcc;
    }

    public void setHoras_tcc(int horas_tcc) {
        this.horas_tcc = horas_tcc;
    }

    public List<Integer> getDisciplina_ids() {
        return disciplina_ids;
    }

    public void setDisciplina_ids(List<Integer> disciplina_ids) {
        this.disciplina_ids = disciplina_ids;
    }
}