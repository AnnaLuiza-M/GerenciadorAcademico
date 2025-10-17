package mapper;
import dto.*;
import model.entities.ProfessorPrograma;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;


@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProfessorProgramaMapper {

    // DTO → Entidade (para criação)
    ProfessorPrograma toEntity(ProfessorProgramaCreateDTO dto);

    // Entidade → DTO (para resposta)
    ProfessorProgramaResponseDTO toResponseDTO(ProfessorPrograma entity);

    // DTO → Entidade (para atualização parcial)
    void updateFromDto(ProfessorProgramaUpdateDTO dto, @MappingTarget ProfessorPrograma entity);

    // Lista de Entidades → Lista de DTOs
    List<ProfessorProgramaResponseDTO> toResponseDTOList(List<ProfessorPrograma> entities);

}
