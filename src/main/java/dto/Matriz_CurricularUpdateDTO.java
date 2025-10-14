package dto;

public class Matriz_CurricularUpdateDTO {


        private String nomeMatriz;
        private String turno;
        private String campus;
        private String habilitacao;
        private Integer horasComplementares;
        private Integer horasObrigatorias;
        private Integer horasEletivas;
        private Integer horasTcc;
        private Boolean ativo;

        public Matriz_CurricularUpdateDTO() {}

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

        public Integer getHorasComplementares() {
            return horasComplementares;
        }

        public void setHorasComplementares(Integer horasComplementares) {
            this.horasComplementares = horasComplementares;
        }

        public Integer getHorasObrigatorias() {
            return horasObrigatorias;
        }

        public void setHorasObrigatorias(Integer horasObrigatorias) {
            this.horasObrigatorias = horasObrigatorias;
        }

        public Integer getHorasEletivas() {
            return horasEletivas;
        }

        public void setHorasEletivas(Integer horasEletivas) {
            this.horasEletivas = horasEletivas;
        }

        public Integer getHorasTcc() {
            return horasTcc;
        }

        public void setHorasTcc(Integer horasTcc) {
            this.horasTcc = horasTcc;
        }

        public Boolean getAtivo() {
            return ativo;
        }

        public void setAtivo(Boolean ativo) {
            this.ativo = ativo;
        }
    }


