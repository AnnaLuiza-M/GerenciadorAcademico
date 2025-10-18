package br.ucsal.gerenciador.dto;

import java.time.LocalDateTime;

public class ProfessorProgramaResponseDTO {


        private int id;
        private int idProfessor;
        private String nomeProfessor;
        private int idPrograma;
        private String nomePrograma;
        private LocalDateTime dataInicioEdicao;
        private LocalDateTime dataFimEdicao;
        private String alteracoes;

        public ProfessorProgramaResponseDTO() {}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIdProfessor() {
            return idProfessor;
        }

        public void setIdProfessor(int idProfessor) {
            this.idProfessor = idProfessor;
        }

        public String getNomeProfessor() {
            return nomeProfessor;
        }

        public void setNomeProfessor(String nomeProfessor) {
            this.nomeProfessor = nomeProfessor;
        }

        public int getIdPrograma() {
            return idPrograma;
        }

        public void setIdPrograma(int idPrograma) {
            this.idPrograma = idPrograma;
        }

        public String getNomePrograma() {
            return nomePrograma;
        }

        public void setNomePrograma(String nomePrograma) {
            this.nomePrograma = nomePrograma;
        }

        public LocalDateTime getDataInicioEdicao() {
            return dataInicioEdicao;
        }

        public void setDataInicioEdicao(LocalDateTime dataInicioEdicao) {
            this.dataInicioEdicao = dataInicioEdicao;
        }

        public LocalDateTime getDataFimEdicao() {
            return dataFimEdicao;
        }

        public void setDataFimEdicao(LocalDateTime dataFimEdicao) {
            this.dataFimEdicao = dataFimEdicao;
        }

        public String getAlteracoes() {
            return alteracoes;
        }

        public void setAlteracoes(String alteracoes) {
            this.alteracoes = alteracoes;
        }
    }


