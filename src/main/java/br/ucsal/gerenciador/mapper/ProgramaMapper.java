package br.ucsal.gerenciador.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.ucsal.gerenciador.dto.ProgramaCreateDTO;
import br.ucsal.gerenciador.dto.ProgramaResponseDTO;
import br.ucsal.gerenciador.dto.ProgramaUpdateDTO;

import br.ucsal.gerenciador.model.entities.Disciplina;
import br.ucsal.gerenciador.model.entities.Professor;
import br.ucsal.gerenciador.model.entities.Programa;
import br.ucsal.gerenciador.model.entities.Referencia_bibliografica;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProgramaMapper {


    @Mapping(target = "professores", ignore = true)
    @Mapping(target = "disciplinas", ignore = true)
    @Mapping(target = "referencias", ignore = true)
    Programa toEntity(ProgramaCreateDTO dto);



    @Mapping(source = "professores", target = "professores_ids")
    @Mapping(source = "disciplinas", target = "disciplina_ids")
    @Mapping(source = "referencias", target = "referencia_ids")
    ProgramaResponseDTO toResponseDTO(Programa entity);



    @Mapping(target = "professores", ignore = true)
    @Mapping(target = "disciplinas", ignore = true)
    @Mapping(target = "referencias", ignore = true)
    void updateFromDto(ProgramaUpdateDTO dto, @MappingTarget Programa entity);



    List<ProgramaResponseDTO> toResponseDTOList(List<Programa> entities);




    default List<Integer> mapProfessores(List<Professor> professores) {
        if (professores == null) {
            return null;
        }
        return professores.stream()
                .map(Professor::getId)
                .collect(Collectors.toList());
    }

    default List<Integer> mapDisciplinas(List<Disciplina> disciplinas) {
        if (disciplinas == null) {
            return null;
        }

        return disciplinas.stream()
                .map(Disciplina::getId_disciplina)
                .collect(Collectors.toList());
    }

    default List<Integer> mapReferencias(List<Referencia_bibliografica> referencias) {
        if (referencias == null) {
            return null;
        }
        return referencias.stream()
                .map(Referencia_bibliografica::getId)
                .collect(Collectors.toList());
    }
}