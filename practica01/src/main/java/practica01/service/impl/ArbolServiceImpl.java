
package practica01.service.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practica01.dao.ArbolDao;
import practica01.domain.Arbol;
import practica01.service.ArbolService;

@Service
public class ArbolServiceImpl implements ArbolService{
    
   @Autowired
    ArbolDao arbolDao;
    
    @Override
    @Transactional()
    public List<Arbol> getArbol() {
        return arbolDao.findAll();
        
    }
}
