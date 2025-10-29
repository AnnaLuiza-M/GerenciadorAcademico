package br.ucsal.gerenciador.mapper;

import java.util.List;

import br.ucsal.gerenciador.dto.Referencia_bibliograficaCreateDTO;
import br.ucsal.gerenciador.dto.Referencia_bibliograficaResponseDTO;
import br.ucsal.gerenciador.dto.Referencia_bibliograficaUpdateDTO;
import br.ucsal.gerenciador.model.entities.Referencia_bibliografica;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping; // 1. IMPORTAR
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface Referencia_bibliograficaMapper {

    // --- DTO -> Entidade (Criação) ---
    // 2. Ignora 'programa', pois o Service trata manualmente
    @Mapping(target = "programa", ignore = true)
    Referencia_bibliografica toEntity(Referencia_bibliograficaCreateDTO dto);


    // --- Entidade -> DTO (Resposta) ---
    // 3. Ensina a converter o objeto 'programa' no ID 'programa_id'
    @Mapping(source = "programa.id", target = "programa_id")
    Referencia_bibliograficaResponseDTO toResponseDTO(Referencia_bibliografica entity);


    // --- DTO -> Entidade (Atualização) ---
    // 4. Também ignora o campo
    @Mapping(target = "programa", ignore = true)
    void updateFromDto(Referencia_bibliograficaUpdateDTO dto, @MappingTarget Referencia_bibliografica entity);


    // --- Lista de Entidades -> Lista de DTOs ---
    List<Referencia_bibliograficaResponseDTO> toResponseDTOList(List<Referencia_bibliografica> entities);
}