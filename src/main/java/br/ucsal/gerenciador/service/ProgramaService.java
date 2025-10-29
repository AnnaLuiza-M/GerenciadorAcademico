package br.ucsal.gerenciador.service;

import br.ucsal.gerenciador.dto.ProgramaCreateDTO;
import br.ucsal.gerenciador.dto.ProgramaResponseDTO;
import br.ucsal.gerenciador.dto.ProgramaUpdateDTO;
import br.ucsal.gerenciador.mapper.ProgramaMapper;
import br.ucsal.gerenciador.model.entities.Professor; // <-- IMPORTADO
import br.ucsal.gerenciador.model.entities.Programa;
import br.ucsal.gerenciador.repository.ProfessorRepository; // <-- IMPORTADO
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ucsal.gerenciador.repository.ProgramaRepository;

import java.util.List;

@Service
@Transactional
public class ProgramaService {

    private final ProgramaRepository repository;
    private final ProgramaMapper mapper;
    private final ProfessorRepository professorRepository; // <-- ADICIONADO

    // Construtor atualizado
    public ProgramaService(ProgramaRepository repository, ProgramaMapper mapper, ProfessorRepository professorRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.professorRepository = professorRepository;
    }

    // Método 'create' atualizado
    public ProgramaResponseDTO create(ProgramaCreateDTO dto) {

        // 1. O Mapper converte os campos simples (ementa, objetivos, etc.)
        Programa programa = mapper.toEntity(dto);

        // 2. Verificamos se o DTO enviou IDs de professores
        if (dto.getProfessores_ids() != null && !dto.getProfessores_ids().isEmpty()) {

            // 3. Buscamos as entidades REAIS de Professor no banco
            List<Professor> professores = professorRepository.findAllById(dto.getProfessores_ids());

            // 4. Associamos os professores encontrados ao programa
            programa.setProfessores(professores);
        }

        // 5. Agora sim salvamos o programa, já com suas associações
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

    // Método 'update' atualizado
    public ProgramaResponseDTO update(Integer id, ProgramaUpdateDTO dto) {

        Programa programa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));

        // O Mapper atualiza os campos simples (ementa, objetivos, etc.)
        mapper.updateFromDto(dto, programa);

        // Lógica manual para atualizar a lista de professores
        // (Assumindo que seu ProgramaUpdateDTO também tenha 'professores_ids')
        if (dto.getProfessores_ids() != null) {

            List<Professor> professores = professorRepository.findAllById(dto.getProfessores_ids());

            programa.setProfessores(professores);
        }

        repository.save(programa);

        return mapper.toResponseDTO(programa);
    }

    public void delete(Integer id) {
        Programa programa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));
        repository.delete(programa);
    }
}