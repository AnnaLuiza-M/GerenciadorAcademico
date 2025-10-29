package br.ucsal.gerenciador.service;

import br.ucsal.gerenciador.dto.Matriz_CurricularCreateDTO;
import br.ucsal.gerenciador.dto.Matriz_CurricularResponseDTO;
import br.ucsal.gerenciador.dto.Matriz_CurricularUpdateDTO;
import br.ucsal.gerenciador.mapper.Matriz_CurricularMapper;
import br.ucsal.gerenciador.model.entities.Disciplina;
import br.ucsal.gerenciador.model.entities.Matriz_Curricular;
import br.ucsal.gerenciador.repository.DisciplinaRepository;
import br.ucsal.gerenciador.repository.Matriz_CurricularRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Matriz_CurricularService {

    private final Matriz_CurricularRepository repository;
    private final Matriz_CurricularMapper mapper;
    private final DisciplinaRepository disciplinaRepository;


    public Matriz_CurricularService(Matriz_CurricularRepository repository, Matriz_CurricularMapper mapper, DisciplinaRepository disciplinaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.disciplinaRepository = disciplinaRepository;
    }


    public Matriz_CurricularResponseDTO create(Matriz_CurricularCreateDTO dto){

        Matriz_Curricular matriz_Curricular = mapper.toEntity(dto);


        if (dto.getDisciplina_ids() != null && !dto.getDisciplina_ids().isEmpty()) {


            List<Disciplina> disciplinas = disciplinaRepository.findAllById(dto.getDisciplina_ids());


            if (disciplinas.size() != dto.getDisciplina_ids().size()) {
                throw new EntityNotFoundException("Uma ou mais Disciplinas com os IDs fornecidos não foram encontradas.");
            }


            matriz_Curricular.setDisciplinas(disciplinas);
        }


        matriz_Curricular = repository.save(matriz_Curricular);
        return mapper.toResponseDTO(matriz_Curricular);
    }

    public Matriz_CurricularResponseDTO findById(Integer id){
        Matriz_Curricular matriz_Curricular = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matriz Curricular não encontrada"));
        return mapper.toResponseDTO(matriz_Curricular);
    }

    public List<Matriz_CurricularResponseDTO> findAll(){
        return mapper.toResponseDTOList(repository.findAll());
    }


    public Matriz_CurricularResponseDTO update(Integer id, Matriz_CurricularUpdateDTO dto){

        Matriz_Curricular matriz_curricular = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matriz Curricular não encontrada"));


        mapper.updateFromDto(dto, matriz_curricular);

        if (dto.getDisciplina_ids() != null) {

            List<Disciplina> disciplinas = disciplinaRepository.findAllById(dto.getDisciplina_ids());


            matriz_curricular.setDisciplinas(disciplinas);
        }

        matriz_curricular = repository.save(matriz_curricular);
        return mapper.toResponseDTO(matriz_curricular);
    }

    public void delete(Integer id) {
        Matriz_Curricular matriz_curricular = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matriz Curricular não encontrada"));
        repository.delete(matriz_curricular);
    }
}