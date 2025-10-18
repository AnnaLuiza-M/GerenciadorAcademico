package br.ucsal.gerenciador.repository;

import br.ucsal.gerenciador.model.entities.ProfessorPrograma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorProgramaRepository extends JpaRepository<ProfessorPrograma, Integer> {
}
