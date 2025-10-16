package service;


import dto.Referencia_bibliograficaCreateDTO;
import dto.Referencia_bibliograficaResponseDTO;
import dto.Referencia_bibliograficaUpdateDTO;
import mapper.Referencia_bibliograficaMapper;
import model.entities.Referencia_bibliografica;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.Referencia_bibliograficaRepository;

import java.util.List;

@Service
@Transactional
public class Referencia_bibliograficaService {

    private final Referencia_bibliograficaRepository repository;
    private final Referencia_bibliograficaMapper mapper;

    public Referencia_bibliograficaService(Referencia_bibliograficaRepository repository, Referencia_bibliograficaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Referencia_bibliograficaResponseDTO create(Referencia_bibliograficaCreateDTO dto) {
        Referencia_bibliografica referencia = mapper.toEntity(dto);
        repository.save(referencia);
        return mapper.toResponseDTO(referencia);
    }

    public Referencia_bibliograficaResponseDTO findById(Integer id) {
        Referencia_bibliografica referencia = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referência bibliográfica não encontrada"));
        return mapper.toResponseDTO(referencia);
    }

    public List<Referencia_bibliograficaResponseDTO> findAll() {
        return mapper.toResponseDTOList(repository.findAll());
    }

    public Referencia_bibliograficaResponseDTO update(Integer id, Referencia_bibliograficaUpdateDTO dto) {
        Referencia_bibliografica referencia = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referência bibliográfica não encontrada"));

        mapper.updateFromDto(dto, referencia);
        repository.save(referencia);

        return mapper.toResponseDTO(referencia);
    }

    public void delete(Integer id) {
        Referencia_bibliografica referencia = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referência bibliográfica não encontrada"));
        repository.delete(referencia);
    }
}

