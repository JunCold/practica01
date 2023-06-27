package practica01.dao;

import org.hibernate.query.criteria.JpaExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import practica01.domain.Arbol;

public interface ArbolDao extends JpaRepository<Arbol, Long> {
    //Mas adelante vamos a crear metodos ampliados
}
