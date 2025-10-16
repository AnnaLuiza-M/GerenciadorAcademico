package service;

import dto.ProgramaCreateDTO;
import dto.ProgramaResponseDTO;
import dto.ProgramaUpdateDTO;
import mapper.ProgramaMapper;
import model.entities.Programa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ProgramaRepository;

import java.util.List;

@Service
@Transactional
public class ProgramaService {

    private final ProgramaRepository repository;
    private final ProgramaMapper mapper;

    public ProgramaService(ProgramaRepository repository, ProgramaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProgramaResponseDTO create(ProgramaCreateDTO dto) {
        Programa programa = mapper.toEntity(dto);
        repository.save(programa);
        return mapper.toResponseDTO(programa);
    }

    public ProgramaResponseDTO findById(Integer id) {
        Programa programa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));
        return mapper.toResponseDTO(programa);
    }

    public List<ProgramaResponseDTO> findAll() {
        return mapper.toResponseDTOList(repository.findAll());
    }

    public ProgramaResponseDTO update(Integer id, ProgramaUpdateDTO dto) {
        Programa programa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));

        mapper.updateFromDto(dto, programa);
        repository.save(programa);

        return mapper.toResponseDTO(programa);
    }

    public void delete(Integer id) {
        Programa programa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));
        repository.delete(programa);
    }
}
