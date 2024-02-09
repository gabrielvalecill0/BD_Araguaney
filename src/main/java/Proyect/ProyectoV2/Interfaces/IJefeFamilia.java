package Proyect.ProyectoV2.Interfaces;

import Proyect.ProyectoV2.Modelos.JefeFamilia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJefeFamilia extends CrudRepository<JefeFamilia,Integer>{
    
}
