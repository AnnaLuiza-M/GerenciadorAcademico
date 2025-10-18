package br.ucsal.gerenciador.service;


import br.ucsal.gerenciador.dto.DisciplinaCreateDTO;
import br.ucsal.gerenciador.dto.DisciplinaResponseDTO;
import br.ucsal.gerenciador.dto.DisciplinaUpdateDTO;
import br.ucsal.gerenciador.mapper.DisciplinaMapper;
import br.ucsal.gerenciador.model.entities.Disciplina;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ucsal.gerenciador.repository.DisciplinaRepository;

import java.util.List;

@Service
@Transactional
public class DisciplinaService {

    private final DisciplinaRepository repository;
    private final DisciplinaMapper mapper;

    public DisciplinaService(DisciplinaRepository repository, DisciplinaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DisciplinaResponseDTO create(DisciplinaCreateDTO dto) {
        Disciplina disciplina = mapper.toEntity(dto);
        repository.save(disciplina);
        return mapper.toResponseDTO(disciplina);
    }

    public DisciplinaResponseDTO findById(Integer id) {
        Disciplina disciplina = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
        return mapper.toResponseDTO(disciplina);
    }

    public List<DisciplinaResponseDTO> findAll() {
        return mapper.toResponseDTOList(repository.findAll());
    }

    public DisciplinaResponseDTO update(Integer id, DisciplinaUpdateDTO dto) {
        Disciplina disciplina = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        mapper.updateFromDto(dto, disciplina);
        repository.save(disciplina);

        return mapper.toResponseDTO(disciplina);
    }

    public void delete(Integer id) {
        Disciplina disciplina = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
        repository.delete(disciplina);
    }
}
