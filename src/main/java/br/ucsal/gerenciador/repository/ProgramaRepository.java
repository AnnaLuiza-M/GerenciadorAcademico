package br.ucsal.gerenciador.repository;

import br.ucsal.gerenciador.model.entities.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramaRepository extends JpaRepository<Programa, Integer> {
}
