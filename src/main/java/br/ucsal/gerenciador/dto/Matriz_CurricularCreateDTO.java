package br.ucsal.gerenciador.dto;
import java.util.List;
import jakarta.validation.constraints.NotNull;

public class Matriz_CurricularCreateDTO {


    @NotNull
    private String nome_matriz;

    @NotNull
    private String turno;

    @NotNull
    private String campus;

    @NotNull
    private String habilitacao;

    @NotNull
    private int horas_complementares;

    @NotNull
    private int horas_obrigatorias;

    @NotNull
    private int horas_eletivas;

    @NotNull
    private int horas_tcc;

    private boolean ativo = true;

    private List<Integer> disciplina_ids;

    public Matriz_CurricularCreateDTO() {}

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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public List<Integer> getDisciplina_ids() {
        return disciplina_ids;
    }

    public void setDisciplina_ids(List<Integer> disciplina_ids) {
        this.disciplina_ids = disciplina_ids;
    }
}


