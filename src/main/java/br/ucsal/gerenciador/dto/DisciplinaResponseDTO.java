package br.ucsal.gerenciador.dto;

import br.ucsal.gerenciador.model.enums.Classificacao_disciplina;
import br.ucsal.gerenciador.model.enums.Tipo_disciplina;

import java.util.List;

public class DisciplinaResponseDTO {


    private int id_disciplina;
    private String sigla;
    private String descricao;
    private int carga_horaria;


    private Tipo_disciplina tipo;
    private Classificacao_disciplina classificacao;
    private boolean ativo;


    private Integer programa_id;
    private List<Integer> matrizesCurriculares_ids;


    public DisciplinaResponseDTO() {}


    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

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

    public List<Integer> getMatrizesCurriculares_ids() {
        return matrizesCurriculares_ids;
    }

    public void setMatrizesCurriculares_ids(List<Integer> matrizesCurriculares_ids) {
        this.matrizesCurriculares_ids = matrizesCurriculares_ids;
    }
}