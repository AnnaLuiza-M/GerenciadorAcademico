package dto;

import jakarta.validation.constraints.NotNull;

public class ProgramaResponseDTO {

    private int id;
    private int idDisciplina;
    private String ementa;
    private String objetivos;
    private String conteudo_programatico;
    private String metodologia;
    private String sistema_avaliacao;
    private boolean ativo = true;


    public ProgramaResponseDTO() {
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
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
}
