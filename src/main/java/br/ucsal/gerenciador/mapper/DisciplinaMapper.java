package br.ucsal.gerenciador.mapper;
import java.util.List;

import br.ucsal.gerenciador.dto.DisciplinaCreateDTO;
import br.ucsal.gerenciador.dto.DisciplinaResponseDTO;
import br.ucsal.gerenciador.dto.DisciplinaUpdateDTO;
import br.ucsal.gerenciador.model.entities.Disciplina;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface DisciplinaMapper {

        // DTO → Entidade (para criação)
        Disciplina toEntity(DisciplinaCreateDTO dto);

        // Entidade → DTO (para resposta)
        DisciplinaResponseDTO toResponseDTO(Disciplina entity);

        // DTO → Entidade (para atualização parcial)
        void updateFromDto(DisciplinaUpdateDTO dto, @MappingTarget Disciplina entity);

        // Lista de Entidades → Lista de DTOs
        List<DisciplinaResponseDTO> toResponseDTOList(List<Disciplina> entities);
    }


