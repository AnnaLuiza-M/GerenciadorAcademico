package br.ucsal.gerenciador.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMINISTRADOR,
    ROLE_PROFESSOR;

    @Override
    public String getAuthority() {
        return name();
    }
}