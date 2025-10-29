package br.ucsal.gerenciador.dto;


public class ProfessorUpdateDTO {

    private String nome_completo;
    private Long numero_registro;
    private String escola_vinculada;
    private Boolean ativo;

    public ProfessorUpdateDTO() {
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public Long getNumero_registro() {
        return numero_registro;
    }

    public void setNumero_registro(Long numero_registro) {
        this.numero_registro = numero_registro;
    }

    public String getEscola_vinculada() {
        return escola_vinculada;
    }

    public void setEscola_vinculada(String escola_vinculada) {
        this.escola_vinculada = escola_vinculada;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}