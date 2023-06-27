package practica01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practica01.service.ArbolService;

@Controller
@RequestMapping("/arbol")
@Slf4j
public class ArbolController {
    
    @Autowired
    ArbolService arbolService;
    
    @GetMapping("/listado")
    public String page(Model model) {
        log.info("Consumo del regreso /arbol/listado");
        var arboles = arbolService.getArbol();
        model.addAttribute("listaArboles", arboles);
        model.addAttribute("totalArboles", arboles.size());
        return "/arbol/listado";
    }
    
}
