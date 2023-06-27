package practica01.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practica01.service.ArbolService;
import practica01.domain.Arbol;
import java.util.List;
import practica01.service.impl.ArbolServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import practica01.service.impl.FirebaseStorageServiceImpl;

@Controller
@RequestMapping("/arbol")
@Slf4j
public class ArbolController {
    
    @Autowired
    ArbolService arbolService;
    
    @GetMapping("/listado")
    public String page(Model model) {
        log.info("Consumo del regreso /arbol/listado");
        List<Arbol> arboles= arbolService.getArbol();
        model.addAttribute("listaArboles", arboles);
        model.addAttribute("totalArboles", arboles.size());
        return "/arbol/listado";
    }
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
     @GetMapping("/nuevo")
    public String ArbolNuevo(Arbol arbol) {
        return "/arbol/modifica";
    }
    
    @PostMapping("/guardar")
    public String categoriaGuardar(Arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            arbol.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "categoria", 
                            arbol.getIdArbol()));
        }
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }
    @GetMapping("/eliminar/{idArbol}")
    public String categoriaEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/categoria/listado";
    }
    @GetMapping("/modificar/{idArbol}")
    public String categoriaModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }

    
    
    
    
  
  
  
    
    
    
    
    
}
