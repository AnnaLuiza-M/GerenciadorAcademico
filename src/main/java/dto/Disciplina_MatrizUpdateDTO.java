package dto;

import jakarta.validation.constraints.NotNull;

public class Disciplina_MatrizUpdateDTO {

        @NotNull
        private Integer idPreRequisito;

        @NotNull
        private Integer semestre;

        public Disciplina_MatrizUpdateDTO() {}

        public Integer getIdPreRequisito() {
            return idPreRequisito;
        }

        public void setIdPreRequisito(Integer idPreRequisito) {
            this.idPreRequisito = idPreRequisito;
        }

        public Integer getSemestre() {
            return semestre;
        }

        public void setSemestre(Integer semestre) {
            this.semestre = semestre;
        }
    }


