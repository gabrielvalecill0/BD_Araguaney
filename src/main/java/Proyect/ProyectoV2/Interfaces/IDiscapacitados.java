package Proyect.ProyectoV2.Interfaces;

import Proyect.ProyectoV2.Modelos.Discapacitados;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiscapacitados extends CrudRepository<Discapacitados,Integer>{
    
}
