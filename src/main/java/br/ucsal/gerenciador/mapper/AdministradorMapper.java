package br.ucsal.gerenciador.mapper;

import br.ucsal.gerenciador.dto.AdministradorCreateDTO;
import br.ucsal.gerenciador.dto.AdministradorResponseDTO;
import br.ucsal.gerenciador.dto.AdministradorUpdateDTO;
import br.ucsal.gerenciador.model.entities.Administrador;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

    @Mapper(
            componentModel = "spring",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    public interface AdministradorMapper {

        Administrador toEntity(AdministradorCreateDTO dto);

        AdministradorResponseDTO toResponseDTO(Administrador entity);

        void updateFromDto(AdministradorUpdateDTO dto, @MappingTarget Administrador entity);

        List<AdministradorResponseDTO> toResponseDTOList(List<Administrador> entities);
    }


