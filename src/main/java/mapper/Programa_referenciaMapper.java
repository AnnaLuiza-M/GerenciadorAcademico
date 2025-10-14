package mapper;
import dto.*;
import model.entities.Programa_referencia;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;


@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface Programa_referenciaMapper {
    // DTO → Entidade (para criação)
    Programa_referencia toEntity(Programa_ReferenciaCreateDTO dto);

    // Entidade → DTO (para resposta)
    Programa_ReferenciaResponseDTO toResponseDTO(Programa_referencia entity);

    // DTO → Entidade (para atualização parcial)
    void updateFromDto(Programa_ReferenciaUpdateDTO dto, @MappingTarget Programa_referencia entity);

    // Lista de Entidades → Lista de DTOs
    List<Programa_ReferenciaResponseDTO> toResponseDTOList(List<Programa_referencia> entities);
}
