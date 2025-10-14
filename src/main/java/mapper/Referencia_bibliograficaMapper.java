package mapper;
import java.util.List;

import dto.*;
import model.entities.Referencia_bibliografica;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)

public interface Referencia_bibliograficaMapper {
    // DTO → Entidade (para criação)
    Referencia_bibliografica toEntity(Referencia_bibliograficaCreateDTO dto);

    // Entidade → DTO (para resposta)
    Referencia_bibliograficaResponseDTO toResponseDTO(Referencia_bibliografica entity);

    // DTO → Entidade (para atualização parcial)
    void updateFromDto(Referencia_bibliograficaUpdateDTO dto, @MappingTarget Referencia_bibliografica entity);

    // Lista de Entidades → Lista de DTOs
    List<Referencia_bibliograficaResponseDTO> toResponseDTOList(List<Referencia_bibliografica> entities);
}
