package mapper;
import java.util.List;

import dto.*;
import model.entities.Matriz_Curricular;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface Matriz_CurricularMapper {

    // DTO → Entidade (para criação)
    Matriz_Curricular toEntity(Matriz_CurricularCreateDTO dto);

    // Entidade → DTO (para resposta)
    Matriz_CurricularResponseDTO toResponseDTO(Matriz_Curricular entity);

    // DTO → Entidade (para atualização parcial)
    void updateFromDto(Matriz_CurricularUpdateDTO dto, @MappingTarget Matriz_Curricular entity);

    // Lista de Entidades → Lista de DTOs
    List<Matriz_CurricularResponseDTO> toResponseDTOList(List<Matriz_Curricular> entities);
}
