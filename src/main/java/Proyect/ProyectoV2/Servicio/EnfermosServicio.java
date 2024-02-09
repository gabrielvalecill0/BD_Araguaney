package Proyect.ProyectoV2.Servicio;

import Proyect.ProyectoV2.Interfaces.IEnfermos;
import Proyect.ProyectoV2.InterfacesServicio.IEnfermosServicio;
import Proyect.ProyectoV2.Modelos.Enfermos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnfermosServicio implements IEnfermosServicio{

    @Autowired
    private IEnfermos datos;
    
    @Override
    public List<Enfermos> listar() {
        return (List<Enfermos>) datos.findAll();
    }

    @Override
    public Optional<Enfermos> listarPorCedula(int cedula) {
        return datos.findById(cedula);
    }

    @Override
    public int guardar(Enfermos p) {
        int res=0;
        Enfermos Enfermos = datos.save(p);
        if(!Enfermos.equals(null)){
            res=1;
        }
        return res;        }

    @Override
    public void borrar(int cedula) {
        datos.deleteById(cedula);
    }
    
}
