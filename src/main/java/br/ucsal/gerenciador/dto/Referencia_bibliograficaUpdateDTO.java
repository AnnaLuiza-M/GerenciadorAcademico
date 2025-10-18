package br.ucsal.gerenciador.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Referencia_bibliograficaUpdateDTO {


        @NotNull
        @Size(min = 2, max = 255)
        private String titulo;

        @NotNull
        @Size(min = 2, max = 255)
        private String autor;

        @NotNull
        private String ano;

        @NotNull
        private String categoria;

        @NotNull
        private boolean ativo;

        public Referencia_bibliograficaUpdateDTO() {}

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getAno() {
            return ano;
        }

        public void setAno(String ano) {
            this.ano = ano;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public boolean isAtivo() {
            return ativo;
        }

        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
        }
    }

