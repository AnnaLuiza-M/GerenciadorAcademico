package dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;

public class ProfessorCreateDTO {

    @NotNull
    private String nome_completo;

    @Column(unique = true)
    @Serial
    private long numero_registro;

    @NotNull
    private String escola_vinculada;

    private boolean ativo = true;

    public ProfessorCreateDTO() {
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
}
