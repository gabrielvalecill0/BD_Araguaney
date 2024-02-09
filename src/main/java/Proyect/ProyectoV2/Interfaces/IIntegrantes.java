package Proyect.ProyectoV2.Interfaces;

import Proyect.ProyectoV2.Modelos.Integrantes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIntegrantes extends CrudRepository<Integrantes,Integer>{
    
}
