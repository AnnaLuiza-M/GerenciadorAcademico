package dto;

import jakarta.validation.constraints.NotNull;

public class Matriz_CurricularCreateDTO {


        @NotNull
        private String nomeMatriz;

        @NotNull
        private String turno;

        @NotNull
        private String campus;

        @NotNull
        private String habilitacao;

        @NotNull
        private int horasComplementares;

        @NotNull
        private int horasObrigatorias;

        @NotNull
        private int horasEletivas;

        @NotNull
        private int horasTcc;

        private boolean ativo = true;

        public Matriz_CurricularCreateDTO() {}

        public String getNomeMatriz() {
            return nomeMatriz;
        }

        public void setNomeMatriz(String nomeMatriz) {
            this.nomeMatriz = nomeMatriz;
        }

        public String getTurno() {
            return turno;
        }

        public void setTurno(String turno) {
            this.turno = turno;
        }

        public String getCampus() {
            return campus;
        }

        public void setCampus(String campus) {
            this.campus = campus;
        }

        public String getHabilitacao() {
            return habilitacao;
        }

        public void setHabilitacao(String habilitacao) {
            this.habilitacao = habilitacao;
        }

        public int getHorasComplementares() {
            return horasComplementares;
        }

        public void setHorasComplementares(int horasComplementares) {
            this.horasComplementares = horasComplementares;
        }

        public int getHorasObrigatorias() {
            return horasObrigatorias;
        }

        public void setHorasObrigatorias(int horasObrigatorias) {
            this.horasObrigatorias = horasObrigatorias;
        }

        public int getHorasEletivas() {
            return horasEletivas;
        }

        public void setHorasEletivas(int horasEletivas) {
            this.horasEletivas = horasEletivas;
        }

        public int getHorasTcc() {
            return horasTcc;
        }

        public void setHorasTcc(int horasTcc) {
            this.horasTcc = horasTcc;
        }

        public boolean isAtivo() {
            return ativo;
        }

        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
        }
    }


