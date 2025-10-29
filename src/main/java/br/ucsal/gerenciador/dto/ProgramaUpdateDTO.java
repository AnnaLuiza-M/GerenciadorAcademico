package br.ucsal.gerenciador.dto;

import java.util.List; // 1. IMPORTADO

public class ProgramaUpdateDTO {

    // 2. CAMPO 'idDisciplina' REMOVIDO

    private String ementa;
    private String objetivos;
    private String conteudo_programatico;
    private String metodologia;
    private String sistema_avaliacao;
    private boolean ativo = true;

    // 3. CAMPO 'professores_ids' ADICIONADO
    private List<Integer> professores_ids;

    public ProgramaUpdateDTO() {
    }

    // 4. GETTERS/SETTERS de 'idDisciplina' REMOVIDOS

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

    // 5. GETTERS/SETTERS de 'professores_ids' ADICIONADOS
    public List<Integer> getProfessores_ids() {
        return professores_ids;
    }

    public void setProfessores_ids(List<Integer> professores_ids) {
        this.professores_ids = professores_ids;
    }
}