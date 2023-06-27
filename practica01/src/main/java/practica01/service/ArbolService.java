package practica01.service;

import java.util.List;
import practica01.domain.Arbol;

public interface ArbolService {

    public List<Arbol> getArbol();
    
    public Arbol getArbol(Arbol arbol);
    public void save(Arbol arbol);
    public void delete (Arbol arbol);
    

}
