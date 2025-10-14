package repository;

import model.entities.Matriz_Curricular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatrizCurricularRepository extends JpaRepository<Matriz_Curricular, Integer> {
}
