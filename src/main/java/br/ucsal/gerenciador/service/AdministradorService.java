//package br.ucsal.gerenciador.service;
//
//import br.ucsal.gerenciador.dto.AdministradorCreateDTO;
//import br.ucsal.gerenciador.dto.AdministradorResponseDTO;
//import br.ucsal.gerenciador.dto.AdministradorUpdateDTO;
//import br.ucsal.gerenciador.mapper.AdministradorMapper;
//import br.ucsal.gerenciador.model.entities.Administrador;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import br.ucsal.gerenciador.repository.AdministradorRepository;
//
//
//import java.util.List;
//
//@Service
//@Transactional
//public class AdministradorService {
//
//    private final AdministradorRepository repository;
//    private final AdministradorMapper mapper;
//
//    public AdministradorService(AdministradorRepository repository, AdministradorMapper mapper) {
//        this.repository = repository;
//        this.mapper = mapper;
//    }
//
//    public AdministradorResponseDTO create(AdministradorCreateDTO dto) {
//        Administrador Administrador = mapper.toEntity(dto);
//        repository.save(Administrador);
//        return mapper.toResponseDTO(Administrador);
//    }
//
//    public AdministradorResponseDTO findById(Integer id) {
//        Administrador Administrador = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Administrador não encontrado"));
//        return mapper.toResponseDTO(Administrador);
//    }
//
//    public List<AdministradorResponseDTO> findAll() {
//        return mapper.toResponseDTOList(repository.findAll());
//    }
//
//    public AdministradorResponseDTO update(Integer id, AdministradorUpdateDTO dto) {
//        Administrador Administrador = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Administrador não encontrado"));
//
//        mapper.updateFromDto(dto, Administrador);
//        repository.save(Administrador);
//
//        return mapper.toResponseDTO(Administrador);
//    }
//
//    public void delete(Integer id) {
//        Administrador Administrador = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Administrador não encontrada"));
//        repository.delete(Administrador);
//    }
//
//}
