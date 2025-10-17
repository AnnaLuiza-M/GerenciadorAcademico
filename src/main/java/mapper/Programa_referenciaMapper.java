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
    Programa_referencia toEntity(Programa_referenciaCreateDTO dto);

    // Entidade → DTO (para resposta)
    Programa_referenciaResponseDTO toResponseDTO(Programa_referencia entity);

    // DTO → Entidade (para atualização parcial)
    void updateFromDto(Programa_referenciaUpdateDTO dto, @MappingTarget Programa_referencia entity);

    // Lista de Entidades → Lista de DTOs
    List<Programa_referenciaResponseDTO> toResponseDTOList(List<Programa_referencia> entities);
}
