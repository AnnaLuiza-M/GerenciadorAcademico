package br.ucsal.gerenciador.dto;

import br.ucsal.gerenciador.model.enums.Classificacao_disciplina;
import br.ucsal.gerenciador.model.enums.Tipo_disciplina;

public class DisciplinaUpdateDTO {

    private String descricao;
    private Integer carga_horaria;
    private Tipo_disciplina tipo;
    private Classificacao_disciplina classificacao;
    private Boolean ativo;

    private Integer programa_id;

    public DisciplinaUpdateDTO() {}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Integer carga_horaria) {
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }


    public Integer getPrograma_id() {
        return programa_id;
    }

    public void setPrograma_id(Integer programa_id) {
        this.programa_id = programa_id;
    }
}