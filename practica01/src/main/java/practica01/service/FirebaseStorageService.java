
package practica01.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {
     public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "practica01-c8660.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "practica01";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "practica01-c8660-firebase-adminsdk-ok5vv-cd53cda7d8";
}
