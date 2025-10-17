package service;

import dto.Disciplina_MatrizCreateDTO;
import dto.Disciplina_MatrizResponseDTO;
import dto.Disciplina_MatrizUpdateDTO;
import mapper.Disciplina_MatrizMapper;
import model.entities.Disciplina_Matriz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.Disciplina_MatrizRepository;

import java.util.List;

    @Service
    @Transactional
    public class Disciplina_MatrizService {

        private final Disciplina_MatrizRepository repository;
        private final Disciplina_MatrizMapper mapper;

        public Disciplina_MatrizService(Disciplina_MatrizRepository repository, Disciplina_MatrizMapper mapper) {
            this.repository = repository;
            this.mapper = mapper;
        }

        public Disciplina_MatrizResponseDTO create(Disciplina_MatrizCreateDTO dto) {
            Disciplina_Matriz disciplina_Matriz = mapper.toEntity(dto);
            repository.save(disciplina_Matriz);
            return mapper.toResponseDTO(disciplina_Matriz);
        }

        public Disciplina_MatrizResponseDTO findById(Integer id) {
            Disciplina_Matriz disciplina_Matriz = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Disciplina_Matriz não encontrada"));
            return mapper.toResponseDTO(disciplina_Matriz);
        }

        public List<Disciplina_MatrizResponseDTO> findAll() {
            return mapper.toResponseDTOList(repository.findAll());
        }

        public Disciplina_MatrizResponseDTO update(Integer id, Disciplina_MatrizUpdateDTO dto) {
            Disciplina_Matriz Disciplina_Matriz = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Disciplina_Matriz não encontrada"));

            mapper.updateFromDto(dto, Disciplina_Matriz);
            repository.save(Disciplina_Matriz);

            return mapper.toResponseDTO(Disciplina_Matriz);
        }

        public void delete(Integer id) {
            Disciplina_Matriz Disciplina_Matriz = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Disciplina_Matriz não encontrada"));
            repository.delete(Disciplina_Matriz);
        }
    }

