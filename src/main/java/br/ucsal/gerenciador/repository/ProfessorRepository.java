package br.ucsal.gerenciador.repository;

import br.ucsal.gerenciador.model.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
