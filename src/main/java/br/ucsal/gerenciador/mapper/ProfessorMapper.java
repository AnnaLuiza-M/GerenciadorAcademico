package br.ucsal.gerenciador.mapper;

import br.ucsal.gerenciador.dto.ProfessorCreateDTO;
import br.ucsal.gerenciador.dto.ProfessorResponseDTO;
import br.ucsal.gerenciador.dto.ProfessorUpdateDTO;
import br.ucsal.gerenciador.model.entities.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

    @Mapper(
            componentModel = "spring",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public interface ProfessorMapper {

        // DTO → Entidade (para criação)
        Professor toEntity(ProfessorCreateDTO dto);

        // Entidade → DTO (para resposta)
        ProfessorResponseDTO toResponseDTO(Professor entity);

        // DTO → Entidade (para atualização parcial)
        void updateFromDto(ProfessorUpdateDTO dto, @MappingTarget Professor entity);

        // Lista de Entidades → Lista de DTOs
        List<ProfessorResponseDTO> toResponseDTOList(List<Professor> entities);
    }

