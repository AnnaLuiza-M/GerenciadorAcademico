package br.ucsal.gerenciador.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.ucsal.gerenciador.dto.Matriz_CurricularCreateDTO;
import br.ucsal.gerenciador.dto.Matriz_CurricularResponseDTO;
import br.ucsal.gerenciador.dto.Matriz_CurricularUpdateDTO;
import br.ucsal.gerenciador.model.entities.Disciplina;
import br.ucsal.gerenciador.model.entities.Matriz_Curricular;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface Matriz_CurricularMapper {

    @Mapping(target = "disciplinas", ignore = true)
    Matriz_Curricular toEntity(Matriz_CurricularCreateDTO dto);


    @Mapping(source = "disciplinas", target = "disciplina_ids")
    Matriz_CurricularResponseDTO toResponseDTO(Matriz_Curricular entity);


    @Mapping(target = "disciplinas", ignore = true)
    void updateFromDto(Matriz_CurricularUpdateDTO dto, @MappingTarget Matriz_Curricular entity);


    List<Matriz_CurricularResponseDTO> toResponseDTOList(List<Matriz_Curricular> entities);


    default List<Integer> mapDisciplinas(List<Disciplina> disciplinas) {
        if (disciplinas == null) {
            return null;
        }
        return disciplinas.stream()
                .map(Disciplina::getId_disciplina)
                .collect(Collectors.toList());
    }
}