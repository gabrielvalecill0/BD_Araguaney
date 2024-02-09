package Proyect.ProyectoV2.Interfaces;

import Proyect.ProyectoV2.Modelos.BolsasClap;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBolsasClap extends CrudRepository<BolsasClap,Integer>{
    
    @Query(value = "SELECT COALESCE(SUM(bolsasacomprar), 0) FROM bolsas_clap;",nativeQuery= true)
    int contadorBolsas();

    @Query(value = "SELECT COALESCE(SUM(monto), 0) FROM bolsas_clap;",nativeQuery= true)
    int MontoTotal();
    
}
