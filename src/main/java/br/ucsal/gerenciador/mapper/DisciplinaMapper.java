package br.ucsal.gerenciador.mapper;
import java.util.List;
import java.util.stream.Collectors;

import br.ucsal.gerenciador.dto.DisciplinaCreateDTO;
import br.ucsal.gerenciador.dto.DisciplinaResponseDTO;
import br.ucsal.gerenciador.dto.DisciplinaUpdateDTO;
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
public interface DisciplinaMapper {


        @Mapping(target = "programa", ignore = true)
        Disciplina toEntity(DisciplinaCreateDTO dto);



        @Mapping(source = "id_disciplina", target = "id_disciplina") // 4. Mapeia a PK correta
        @Mapping(source = "programa.id", target = "programa_id") // 5. Mapeia o ID do pai
        @Mapping(source = "matrizesCurriculares", target = "matrizesCurriculares_ids") // 6. Mapeia a lista
        DisciplinaResponseDTO toResponseDTO(Disciplina entity);



        @Mapping(target = "programa", ignore = true)
        void updateFromDto(DisciplinaUpdateDTO dto, @MappingTarget Disciplina entity);



        List<DisciplinaResponseDTO> toResponseDTOList(List<Disciplina> entities);



        default List<Integer> mapMatrizesCurriculares(List<Matriz_Curricular> matrizes) {
                if (matrizes == null) {
                        return null;
                }
                return matrizes.stream()
                        .map(Matriz_Curricular::getId) // Pega o ID de cada Matriz
                        .collect(Collectors.toList());
        }
}