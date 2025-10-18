package br.ucsal.gerenciador.dto;

public class AdministradorResponseDTO {

    private int id;
    private String nome_completo;
    private long numero_registro;

    public AdministradorResponseDTO() {
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
}
