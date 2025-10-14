package dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class Programa_ReferenciaUpdateDTO {


        @NotNull
        private List<Integer> idsReferenciasBibliograficas;

        public Programa_ReferenciaUpdateDTO() {}

        public List<Integer> getIdsReferenciasBibliograficas() {
            return idsReferenciasBibliograficas;
        }

        public void setIdsReferenciasBibliograficas(List<Integer> idsReferenciasBibliograficas) {
            this.idsReferenciasBibliograficas = idsReferenciasBibliograficas;
        }
    }


