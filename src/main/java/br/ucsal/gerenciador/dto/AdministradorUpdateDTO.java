//package br.ucsal.gerenciador.dto;
//
//import jakarta.persistence.Column;
//import jakarta.validation.constraints.NotNull;
//
//import java.io.Serial;
//
//public class AdministradorUpdateDTO {
//
//    @NotNull
//    private String nome_completo;
//
//    @Column(unique = true)
//    @Serial
//    private long numero_registro;
//
//    public AdministradorUpdateDTO() {
//    }
//
//    public String getNome_completo() {
//        return nome_completo;
//    }
//
//    public void setNome_completo(String nome_completo) {
//        this.nome_completo = nome_completo;
//    }
//
//    public long getNumero_registro() {
//        return numero_registro;
//    }
//
//    public void setNumero_registro(long numero_registro) {
//        this.numero_registro = numero_registro;
//    }
//}
