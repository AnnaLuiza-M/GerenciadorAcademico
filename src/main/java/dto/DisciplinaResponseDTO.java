package dto;

import model.enums.Classificacao_disciplina;
import model.enums.Tipo_disciplina;

public class DisciplinaResponseDTO {



        private int id;
        private String sigla;
        private String descricao;
        private int cargaHoraria;
        private Tipo_disciplina tipo;
        private Classificacao_disciplina classificacao;
        private boolean ativo;

        public DisciplinaResponseDTO() {}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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


