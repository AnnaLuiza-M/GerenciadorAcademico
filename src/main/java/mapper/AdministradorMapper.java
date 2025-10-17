package mapper;

import dto.AdministradorCreateDTO;
import dto.AdministradorResponseDTO;
import dto.AdministradorUpdateDTO;
import model.entities.Administrador;
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


