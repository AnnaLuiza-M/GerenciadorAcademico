package dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ProfessorProgramaCreateDTO {


        @NotNull
        private int idProfessor;

        @NotNull
        private int idPrograma;

        private LocalDateTime dataInicioEdicao = LocalDateTime.now();
        private LocalDateTime dataFimEdicao;
        private String alteracoes;

        public ProfessorProgramaCreateDTO() {}

        public int getIdProfessor() {
            return idProfessor;
        }

        public void setIdProfessor(int idProfessor) {
            this.idProfessor = idProfessor;
        }

        public int getIdPrograma() {
            return idPrograma;
        }

        public void setIdPrograma(int idPrograma) {
            this.idPrograma = idPrograma;
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


