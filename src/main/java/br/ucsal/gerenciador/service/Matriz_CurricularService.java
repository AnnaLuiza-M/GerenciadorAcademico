package br.ucsal.gerenciador.service;

import br.ucsal.gerenciador.dto.Matriz_CurricularCreateDTO;
import br.ucsal.gerenciador.dto.Matriz_CurricularResponseDTO;
import br.ucsal.gerenciador.dto.Matriz_CurricularUpdateDTO;
import br.ucsal.gerenciador.mapper.Matriz_CurricularMapper;
import br.ucsal.gerenciador.model.entities.Matriz_Curricular;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ucsal.gerenciador.repository.Matriz_CurricularRepository;

import java.util.List;

@Service
@Transactional
public class Matriz_CurricularService {

    private final Matriz_CurricularRepository repository;
    private final Matriz_CurricularMapper mapper;

    public Matriz_CurricularService(Matriz_CurricularRepository repository, Matriz_CurricularMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Matriz_CurricularResponseDTO create(Matriz_CurricularCreateDTO dto){
        Matriz_Curricular matriz_Curricular = mapper.toEntity(dto);
        matriz_Curricular = repository.save(matriz_Curricular);
        return mapper.toResponseDTO(matriz_Curricular);
    }

    public Matriz_CurricularResponseDTO findById(Integer id){
        Matriz_Curricular matriz_Curricular = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matriz Curricular não encontrada"));
        return mapper.toResponseDTO(matriz_Curricular);
    }

    public List<Matriz_CurricularResponseDTO> findAll(){return mapper.toResponseDTOList(repository.findAll());}

    public Matriz_CurricularResponseDTO update(Integer id, Matriz_CurricularUpdateDTO dto){
        Matriz_Curricular matriz_curricular = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matriz Curricular não encontrada"));

        mapper.updateFromDto(dto, matriz_curricular);
        matriz_curricular = repository.save(matriz_curricular);
        return mapper.toResponseDTO(matriz_curricular);
    }

    public void delete(Integer id) {
        Matriz_Curricular matriz_curricular = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matriz Curricular não encontrada"));
        repository.delete(matriz_curricular);
    }
}
