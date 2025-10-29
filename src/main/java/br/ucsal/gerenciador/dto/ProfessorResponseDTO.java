package br.ucsal.gerenciador.dto;

import java.util.List;

public class ProfessorResponseDTO {

    private String nome_completo;
    private long numero_registro;
    private String email;
    private String escola_vinculada;
    private int id;
    private boolean ativo = true;

    private List<Integer> programa_ids;

    public ProfessorResponseDTO() {
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public long getNumero_registro() {
        return numero_registro;
    }

    public void setNumero_registro(long numero_registro) {
        this.numero_registro = numero_registro;
    }

    public String getEscola_vinculada() {
        return escola_vinculada;
    }

    public void setEscola_vinculada(String escola_vinculada) {
        this.escola_vinculada = escola_vinculada;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Integer> getPrograma_ids() {
        return programa_ids;
    }

    public void setPrograma_ids(List<Integer> programa_ids) {
        this.programa_ids = programa_ids;
    }
}