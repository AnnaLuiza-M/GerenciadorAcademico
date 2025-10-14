package repository;

import model.entities.Administrador;
import model.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
}
