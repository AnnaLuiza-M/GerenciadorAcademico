package dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class Programa_referenciaUpdateDTO {


        @NotNull
        private List<Integer> idsReferenciasBibliograficas;

        public Programa_referenciaUpdateDTO() {}

        public List<Integer> getIdsReferenciasBibliograficas() {
            return idsReferenciasBibliograficas;
        }

        public void setIdsReferenciasBibliograficas(List<Integer> idsReferenciasBibliograficas) {
            this.idsReferenciasBibliograficas = idsReferenciasBibliograficas;
        }
    }


