package br.ucsal.gerenciador.service;

import br.ucsal.gerenciador.dto.Referencia_bibliograficaCreateDTO;
import br.ucsal.gerenciador.dto.Referencia_bibliograficaResponseDTO;
import br.ucsal.gerenciador.dto.Referencia_bibliograficaUpdateDTO;
import br.ucsal.gerenciador.mapper.Referencia_bibliograficaMapper;
import br.ucsal.gerenciador.model.entities.Programa; // 1. IMPORTAR O PAI (Programa)
import br.ucsal.gerenciador.model.entities.Referencia_bibliografica;
import br.ucsal.gerenciador.repository.ProgramaRepository; // 2. IMPORTAR O REPOSITÓRIO DO PAI
import br.ucsal.gerenciador.repository.Referencia_bibliograficaRepository;
import jakarta.persistence.EntityNotFoundException; // 3. IMPORTAR
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Referencia_bibliograficaService {

    private final Referencia_bibliograficaRepository repository;
    private final Referencia_bibliograficaMapper mapper;
    private final ProgramaRepository programaRepository; // <-- 4. ADICIONAR CAMPO

    // 5. ATUALIZAR CONSTRUTOR
    public Referencia_bibliograficaService(Referencia_bibliograficaRepository repository,
                                           Referencia_bibliograficaMapper mapper,
                                           ProgramaRepository programaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.programaRepository = programaRepository;
    }

    // 6. ATUALIZAR MÉTODO 'create'
    public Referencia_bibliograficaResponseDTO create(Referencia_bibliograficaCreateDTO dto) {
        // Mapper converte campos simples. 'programa' vem nulo.
        Referencia_bibliografica referencia = mapper.toEntity(dto);

        // Lógica manual para o @ManyToOne
        // (Assumindo que o DTO tenha getPrograma_id())
        if (dto.getPrograma_id() != null) {
            Programa programa = programaRepository.findById(dto.getPrograma_id())
                    .orElseThrow(() -> new EntityNotFoundException("Programa com ID " + dto.getPrograma_id() + " não encontrado."));

            referencia.setPrograma(programa);
        }

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

    // 7. ATUALIZAR MÉTODO 'update'
    public Referencia_bibliograficaResponseDTO update(Integer id, Referencia_bibliograficaUpdateDTO dto) {
        Referencia_bibliografica referencia = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referência bibliográfica não encontrada"));

        mapper.updateFromDto(dto, referencia);

        // Lógica manual para atualizar a associação
        // (Assumindo que o UpdateDTO tenha getPrograma_id())
        if (dto.getPrograma_id() != null) {
            Programa programa = programaRepository.findById(dto.getPrograma_id())
                    .orElseThrow(() -> new EntityNotFoundException("Programa com ID " + dto.getPrograma_id() + " não encontrado."));

            referencia.setPrograma(programa);
        }

        repository.save(referencia);

        return mapper.toResponseDTO(referencia);
    }

    public void delete(Integer id) {
        Referencia_bibliografica referencia = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referência bibliográfica não encontrada"));
        repository.delete(referencia);
    }
}