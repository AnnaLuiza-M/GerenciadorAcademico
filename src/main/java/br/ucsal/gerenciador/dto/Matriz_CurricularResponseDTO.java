package br.ucsal.gerenciador.dto;

import jakarta.validation.constraints.NotNull;

public class Matriz_CurricularResponseDTO {

    private String nomeMatriz;

    private String turno;

    private String campus;

    private String habilitacao;

    private int horasComplementares;

    private int horasObrigatorias;

    private int horasEletivas;

    public String getNomeMatriz() {
        return nomeMatriz;
    }

    public void setNomeMatriz(String nomeMatriz) {
        this.nomeMatriz = nomeMatriz;
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

    public int getHorasComplementares() {
        return horasComplementares;
    }

    public void setHorasComplementares(int horasComplementares) {
        this.horasComplementares = horasComplementares;
    }

    public int getHorasObrigatorias() {
        return horasObrigatorias;
    }

    public void setHorasObrigatorias(int horasObrigatorias) {
        this.horasObrigatorias = horasObrigatorias;
    }

    public int getHorasEletivas() {
        return horasEletivas;
    }

    public void setHorasEletivas(int horasEletivas) {
        this.horasEletivas = horasEletivas;
    }
}
