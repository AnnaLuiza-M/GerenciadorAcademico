package br.ucsal.gerenciador.service;

import br.ucsal.gerenciador.dto.ProfessorCreateDTO;
import br.ucsal.gerenciador.dto.ProfessorResponseDTO;
import br.ucsal.gerenciador.dto.ProfessorUpdateDTO;
import br.ucsal.gerenciador.mapper.ProfessorMapper;
import br.ucsal.gerenciador.model.entities.Professor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ucsal.gerenciador.repository.ProfessorRepository;

import java.util.List;

@Service
@Transactional
public class ProfessorService {

    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

    public ProfessorService(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProfessorResponseDTO create(ProfessorCreateDTO dto) {
        Professor professor = mapper.toEntity(dto);
        repository.save(professor);
        return mapper.toResponseDTO(professor);
    }

    public ProfessorResponseDTO findById(Integer id) {
        Professor professor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        return mapper.toResponseDTO(professor);
    }

    public List<ProfessorResponseDTO> findAll() {
        return mapper.toResponseDTOList(repository.findAll());
    }

    public ProfessorResponseDTO update(Integer id, ProfessorUpdateDTO dto) {
        Professor professor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        mapper.updateFromDto(dto, professor);
        repository.save(professor);

        return mapper.toResponseDTO(professor);
    }

    public void delete(Integer id) {
        Professor professor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        repository.delete(professor);
    }
}
