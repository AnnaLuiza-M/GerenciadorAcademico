package dto;

public class Disciplina_MatrizResponseDTO {

        private int id;
        private int idMatriz;
        private int idDisciplina;
        private String nomeDisciplina;
        private Integer idPreRequisito;
        private String nomePreRequisito;
        private int semestre;

        public Disciplina_MatrizResponseDTO() {}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIdMatriz() {
            return idMatriz;
        }

        public void setIdMatriz(int idMatriz) {
            this.idMatriz = idMatriz;
        }

        public int getIdDisciplina() {
            return idDisciplina;
        }

        public void setIdDisciplina(int idDisciplina) {
            this.idDisciplina = idDisciplina;
        }

        public String getNomeDisciplina() {
            return nomeDisciplina;
        }

        public void setNomeDisciplina(String nomeDisciplina) {
            this.nomeDisciplina = nomeDisciplina;
        }

        public Integer getIdPreRequisito() {
            return idPreRequisito;
        }

        public void setIdPreRequisito(Integer idPreRequisito) {
            this.idPreRequisito = idPreRequisito;
        }

        public String getNomePreRequisito() {
            return nomePreRequisito;
        }

        public void setNomePreRequisito(String nomePreRequisito) {
            this.nomePreRequisito = nomePreRequisito;
        }

        public int getSemestre() {
            return semestre;
        }

        public void setSemestre(int semestre) {
            this.semestre = semestre;
        }
    }


