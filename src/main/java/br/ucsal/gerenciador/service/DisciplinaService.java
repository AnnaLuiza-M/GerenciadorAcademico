package br.ucsal.gerenciador.service;


import br.ucsal.gerenciador.dto.DisciplinaCreateDTO;
import br.ucsal.gerenciador.dto.DisciplinaResponseDTO;
import br.ucsal.gerenciador.dto.DisciplinaUpdateDTO;
import br.ucsal.gerenciador.mapper.DisciplinaMapper;
import br.ucsal.gerenciador.model.entities.Disciplina;
import br.ucsal.gerenciador.model.entities.Programa;
import br.ucsal.gerenciador.repository.ProgramaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ucsal.gerenciador.repository.DisciplinaRepository;

import java.util.List;

@Service
@Transactional
public class DisciplinaService {

    private final DisciplinaRepository repository;
    private final DisciplinaMapper mapper;
    private final ProgramaRepository programaRepository;


    public DisciplinaService(DisciplinaRepository repository, DisciplinaMapper mapper, ProgramaRepository programaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.programaRepository = programaRepository;
    }


    public DisciplinaResponseDTO create(DisciplinaCreateDTO dto) {


        Disciplina disciplina = mapper.toEntity(dto);


        Programa programa = programaRepository.findById(dto.getPrograma_id())
                .orElseThrow(() -> new EntityNotFoundException("Programa com ID " + dto.getPrograma_id() + " não encontrado."));

        disciplina.setPrograma(programa);


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


        if (dto.getPrograma_id() != null) {

            // Busca a nova entidade 'Programa'
            Programa novoPrograma = programaRepository.findById(dto.getPrograma_id())
                    .orElseThrow(() -> new EntityNotFoundException("Programa com ID " + dto.getPrograma_id() + " não encontrado."));

            // Troca o programa antigo pelo novo
            disciplina.setPrograma(novoPrograma);
        }

        // 4. Salva a entidade UMA VEZ, com todas as alterações aplicadas
        repository.save(disciplina);

        return mapper.toResponseDTO(disciplina);
    }

    public void delete(Integer id) {
        Disciplina disciplina = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
        repository.delete(disciplina);
    }
}