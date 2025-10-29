package br.ucsal.gerenciador.dto;

import java.util.List;

public class ProgramaResponseDTO {

    private int id;


    private String ementa;
    private String objetivos;
    private String conteudo_programatico;
    private String metodologia;
    private String sistema_avaliacao;
    private boolean ativo = true;

    private List<Integer> disciplina_ids;
    private List<Integer> professores_ids;
    private List<Integer> referencia_ids;


    public ProgramaResponseDTO() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getConteudo_programatico() {
        return conteudo_programatico;
    }

    public void setConteudo_programatico(String conteudo_programatico) {
        this.conteudo_programatico = conteudo_programatico;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getSistema_avaliacao() {
        return sistema_avaliacao;
    }

    public void setSistema_avaliacao(String sistema_avaliacao) {
        this.sistema_avaliacao = sistema_avaliacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Integer> getDisciplina_ids() {
        return disciplina_ids;
    }

    public void setDisciplina_ids(List<Integer> disciplina_ids) {
        this.disciplina_ids = disciplina_ids;
    }

    public List<Integer> getProfessores_ids() {
        return professores_ids;
    }

    public void setProfessores_ids(List<Integer> professores_ids) {
        this.professores_ids = professores_ids;
    }

    public List<Integer> getReferencia_ids() {
        return referencia_ids;
    }

    public void setReferencia_ids(List<Integer> referencia_ids) {
        this.referencia_ids = referencia_ids;
    }
}