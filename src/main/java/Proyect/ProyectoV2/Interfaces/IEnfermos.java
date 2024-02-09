package Proyect.ProyectoV2.Interfaces;

import Proyect.ProyectoV2.Modelos.Enfermos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnfermos extends CrudRepository<Enfermos,Integer>{
    
}
