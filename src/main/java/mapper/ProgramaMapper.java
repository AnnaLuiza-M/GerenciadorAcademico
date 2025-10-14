package mapper;

import java.util.List;

import dto.*;
import model.entities.Programa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProgramaMapper {
    // DTO → Entidade (para criação)
    Programa toEntity(ProgramaCreateDTO dto);

    // Entidade → DTO (para resposta)
    ProgramaResponseDTO toResponseDTO(Programa entity);

    // DTO → Entidade (para atualização parcial)
    void updateFromDto(ProgramaUpdateDTO dto, @MappingTarget Programa entity);

    // Lista de Entidades → Lista de DTOs
    List<ProgramaResponseDTO> toResponseDTOList(List<Programa> entities);
}
