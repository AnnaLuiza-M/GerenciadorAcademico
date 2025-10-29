package br.ucsal.gerenciador.dto;

import br.ucsal.gerenciador.model.enums.Categoria_referencia;
import br.ucsal.gerenciador.model.enums.Tipo_referencia;
import java.time.LocalDate;

public class Referencia_bibliograficaResponseDTO {

    private int id;
    private String titulo;
    private String autor;
    private Integer ano;
    private Categoria_referencia categoria;
    private Tipo_referencia tipo;
    private boolean ativo;

    private String edicao;
    private String local;
    private String editora;
    private String isbn;
    private String url;
    private LocalDate data_acesso;

    private Integer programa_id; // <-- CORRIGIDO DE 'programaReferenciaId'


    public Referencia_bibliograficaResponseDTO() {}

    // --- Getters e Setters ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // ... (Getters e Setters para todos os outros campos) ...

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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Categoria_referencia getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria_referencia categoria) {
        this.categoria = categoria;
    }

    public Tipo_referencia getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_referencia tipo) {
        this.tipo = tipo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getData_acesso() {
        return data_acesso;
    }

    public void setData_acesso(LocalDate data_acesso) {
        this.data_acesso = data_acesso;
    }

    // --- GETTER/SETTER CORRIGIDO ---
    public Integer getPrograma_id() {
        return programa_id;
    }

    public void setPrograma_id(Integer programa_id) {
        this.programa_id = programa_id;
    }
}