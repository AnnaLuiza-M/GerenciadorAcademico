package dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import model.enums.Classificacao_disciplina;
import model.enums.Tipo_disciplina;

public class DisciplinaCreateDTO {

    @Size(min = 2, max = 20)
    private String sigla;

    @NotNull
    private String descricao;

    @NotNull
    private int cargaHoraria;

    @NotNull
    private Tipo_disciplina tipo;

    @NotNull
    private Classificacao_disciplina classificacao;

    private boolean ativo = true;

    public DisciplinaCreateDTO() {}

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Tipo_disciplina getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_disciplina tipo) {
        this.tipo = tipo;
    }

    public Classificacao_disciplina getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao_disciplina classificacao) {
        this.classificacao = classificacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
