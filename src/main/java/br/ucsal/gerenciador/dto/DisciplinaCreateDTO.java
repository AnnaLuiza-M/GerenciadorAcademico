package br.ucsal.gerenciador.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import br.ucsal.gerenciador.model.enums.Classificacao_disciplina;
import br.ucsal.gerenciador.model.enums.Tipo_disciplina;

public class DisciplinaCreateDTO {

    @NotBlank
    @Size(min = 2, max = 20)
    private String sigla;

    @NotNull
    private String descricao;


    @NotNull
    private int carga_horaria;

    @NotNull
    private Tipo_disciplina tipo;

    @NotNull
    private Classificacao_disciplina classificacao;

    private boolean ativo = true;

    @NotNull
    private Integer programa_id;

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

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
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


    public Integer getPrograma_id() {
        return programa_id;
    }

    public void setPrograma_id(Integer programa_id) {
        this.programa_id = programa_id;
    }

}