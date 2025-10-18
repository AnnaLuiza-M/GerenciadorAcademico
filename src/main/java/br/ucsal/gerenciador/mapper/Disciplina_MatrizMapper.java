package br.ucsal.gerenciador.mapper;
import br.ucsal.gerenciador.dto.Disciplina_MatrizCreateDTO;
import br.ucsal.gerenciador.dto.Disciplina_MatrizResponseDTO;
import br.ucsal.gerenciador.dto.Disciplina_MatrizUpdateDTO;
import br.ucsal.gerenciador.model.entities.Disciplina_Matriz;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;


@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface Disciplina_MatrizMapper {
    // DTO → Entidade (para criação)
    Disciplina_Matriz toEntity(Disciplina_MatrizCreateDTO dto);

    // Entidade → DTO (para resposta)
    Disciplina_MatrizResponseDTO toResponseDTO(Disciplina_Matriz entity);

    // DTO → Entidade (para atualização parcial)
    void updateFromDto(Disciplina_MatrizUpdateDTO dto, @MappingTarget Disciplina_Matriz entity);

    // Lista de Entidades → Lista de DTOs
    List<Disciplina_MatrizResponseDTO> toResponseDTOList(List<Disciplina_Matriz> entities);


}
