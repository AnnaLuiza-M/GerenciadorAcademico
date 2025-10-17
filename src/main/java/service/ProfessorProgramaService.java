package service;

import dto.ProfessorProgramaCreateDTO;
import dto.ProfessorProgramaResponseDTO;
import dto.ProfessorProgramaUpdateDTO;
import mapper.ProfessorProgramaMapper;
import model.entities.ProfessorPrograma;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ProfessorProgramaRepository;

import java.util.List;

@Service
@Transactional
public class ProfessorProgramaService {

    private final ProfessorProgramaRepository repository;
    private final ProfessorProgramaMapper mapper;

    public ProfessorProgramaService(ProfessorProgramaRepository repository, ProfessorProgramaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public ProfessorProgramaResponseDTO create(ProfessorProgramaCreateDTO dto) {
        ProfessorPrograma professorPrograma = mapper.toEntity(dto);
        repository.save(professorPrograma);
        return mapper.toResponseDTO(professorPrograma);
    }


    public ProfessorProgramaResponseDTO findById(Integer id) {
        ProfessorPrograma professorPrograma = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relação Professor-Programa não encontrada"));
        return mapper.toResponseDTO(professorPrograma);
    }


    public List<ProfessorProgramaResponseDTO> findAll() {
        return mapper.toResponseDTOList(repository.findAll());
    }


    public ProfessorProgramaResponseDTO update(Integer id, ProfessorProgramaUpdateDTO dto) {
        ProfessorPrograma professorPrograma = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relação Professor-Programa não encontrada"));

        mapper.updateFromDto(dto, professorPrograma);
        repository.save(professorPrograma);

        return mapper.toResponseDTO(professorPrograma);
    }


    public void delete(Integer id) {
        ProfessorPrograma professorPrograma = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relação Professor-Programa não encontrada"));
        repository.delete(professorPrograma);
    }
}
