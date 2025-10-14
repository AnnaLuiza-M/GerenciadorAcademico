package mapper;
import dto.*;
import model.entities.Programa;
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
    ProfessorProgramaMapper toEntity(ProfessorProgramaCreateDTO dto);

    // Entidade → DTO (para resposta)
    ProfessorProgramaResponseDTO toResponseDTO(ProfessorProgramaMapper entity);

    // DTO → Entidade (para atualização parcial)
    void updateFromDto(ProfessorProgramaUpdateDTO dto, @MappingTarget Programa entity);

    // Lista de Entidades → Lista de DTOs
    List<ProgramaResponseDTO> toResponseDTOList(List<Programa> entities);

}
