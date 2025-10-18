package br.ucsal.gerenciador.service;


import br.ucsal.gerenciador.dto.Programa_referenciaCreateDTO;
import br.ucsal.gerenciador.dto.Programa_referenciaResponseDTO;
import br.ucsal.gerenciador.dto.Programa_referenciaUpdateDTO;
import br.ucsal.gerenciador.mapper.Programa_referenciaMapper;
import br.ucsal.gerenciador.model.entities.Programa_referencia;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ucsal.gerenciador.repository.Programa_referenciaRepository;

import java.util.List;

@Service
@Transactional
public class Programa_referenciaService {

    private final Programa_referenciaRepository repository;
    private final Programa_referenciaMapper mapper;

    public Programa_referenciaService(Programa_referenciaRepository repository, Programa_referenciaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public Programa_referenciaResponseDTO create(Programa_referenciaCreateDTO dto) {
        Programa_referencia entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toResponseDTO(entity);
    }


    public Programa_referenciaResponseDTO findById(Integer id) {
        Programa_referencia entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa_referencia não encontrada"));
        return mapper.toResponseDTO(entity);
    }


    public List<Programa_referenciaResponseDTO> findAll() {
        return mapper.toResponseDTOList(repository.findAll());
    }


    public Programa_referenciaResponseDTO update(Integer id, Programa_referenciaUpdateDTO dto) {
        Programa_referencia entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa_referencia não encontrada"));

        mapper.updateFromDto(dto, entity);
        repository.save(entity);

        return mapper.toResponseDTO(entity);
    }


    public void delete(Integer id) {
        Programa_referencia entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa_referencia não encontrada"));
        repository.delete(entity);
    }
}
