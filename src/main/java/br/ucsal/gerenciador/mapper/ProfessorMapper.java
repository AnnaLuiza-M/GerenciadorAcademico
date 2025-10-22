package br.ucsal.gerenciador.mapper;

import br.ucsal.gerenciador.dto.ProfessorCreateDTO;
import br.ucsal.gerenciador.dto.ProfessorResponseDTO;
import br.ucsal.gerenciador.dto.ProfessorUpdateDTO;
import br.ucsal.gerenciador.model.entities.Professor;
import br.ucsal.gerenciador.model.entities.Programa; // 1. IMPORTAR
import org.mapstruct.Mapper;
import org.mapstruct.Mapping; // 2. IMPORTAR
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.stream.Collectors; // 3. IMPORTAR

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProfessorMapper {


    @Mapping(target = "programa", ignore = true)
    Professor toEntity(ProfessorCreateDTO dto);



    @Mapping(source = "programa", target = "programa_ids")
    ProfessorResponseDTO toResponseDTO(Professor entity);



    @Mapping(target = "programa", ignore = true)
    void updateFromDto(ProfessorUpdateDTO dto, @MappingTarget Professor entity);



    List<ProfessorResponseDTO> toResponseDTOList(List<Professor> entities);



    default List<Integer> mapProgramas(List<Programa> programas) {
        if (programas == null) {
            return null;
        }
        return programas.stream()
                .map(Programa::getId) // Pega o ID de cada Programa
                .collect(Collectors.toList());
    }
}