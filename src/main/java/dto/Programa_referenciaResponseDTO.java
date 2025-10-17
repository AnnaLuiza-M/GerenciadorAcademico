package dto;

import java.util.List;

public class Programa_referenciaResponseDTO {


        private int id;
        private int idPrograma;
        private String nomePrograma;
        private List<Referencia_bibliograficaResponseDTO> referenciasBibliograficas;

        public Programa_referenciaResponseDTO() {}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public List<Referencia_bibliograficaResponseDTO> getReferenciasBibliograficas() {
            return referenciasBibliograficas;
        }

        public void setReferenciasBibliograficas(List<Referencia_bibliograficaResponseDTO> referenciasBibliograficas) {
            this.referenciasBibliograficas = referenciasBibliograficas;
        }
    }


