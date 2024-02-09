package Proyect.ProyectoV2.Interfaces;

import Proyect.ProyectoV2.Modelos.DatosPersonales;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDatosPersonales extends CrudRepository<DatosPersonales,Integer>{

    @Query(value = "SELECT COUNT(*) FROM datos_personales WHERE TIMESTAMPDIFF(YEAR, f_nacimiento, CURDATE()) < 11;",nativeQuery= true)
    int contadorNinos();
    
    @Query(value = "SELECT COUNT(*) FROM datos_personales WHERE TIMESTAMPDIFF(YEAR, f_nacimiento, CURDATE()) > 59;",nativeQuery= true)
    int contadorMayores();       
}
