package dto;

import model.enums.Classificacao_disciplina;
import model.enums.Tipo_disciplina;

public class DisciplinaUpdateDTO {


        private String descricao;
        private Integer cargaHoraria;
        private Tipo_disciplina tipo;
        private Classificacao_disciplina classificacao;
        private Boolean ativo;

        public DisciplinaUpdateDTO() {}

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Integer getCargaHoraria() {
            return cargaHoraria;
        }

        public void setCargaHoraria(Integer cargaHoraria) {
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

        public Boolean getAtivo() {
            return ativo;
        }

        public void setAtivo(Boolean ativo) {
            this.ativo = ativo;
        }
    }


