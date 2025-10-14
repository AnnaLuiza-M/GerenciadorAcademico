package mapper;
import java.util.List;

import dto.DisciplinaCreateDTO;
import dto.DisciplinaResponseDTO;
import dto.DisciplinaUpdateDTO;
import model.entities.Disciplina;
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


