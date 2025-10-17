package dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class Programa_referenciaCreateDTO {

        @NotNull
        private int idPrograma;

        @NotNull
        private List<Integer> idsReferenciasBibliograficas;

        public Programa_referenciaCreateDTO() {}

        public int getIdPrograma() {
            return idPrograma;
        }

        public void setIdPrograma(int idPrograma) {
            this.idPrograma = idPrograma;
        }

        public List<Integer> getIdsReferenciasBibliograficas() {
            return idsReferenciasBibliograficas;
        }

        public void setIdsReferenciasBibliograficas(List<Integer> idsReferenciasBibliograficas) {
            this.idsReferenciasBibliograficas = idsReferenciasBibliograficas;
        }
    }


