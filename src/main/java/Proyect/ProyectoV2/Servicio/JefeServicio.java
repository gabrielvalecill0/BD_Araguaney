package Proyect.ProyectoV2.Servicio;

import Proyect.ProyectoV2.Interfaces.IJefeFamilia;
import Proyect.ProyectoV2.InterfacesServicio.IJefeServicio;
import Proyect.ProyectoV2.Modelos.JefeFamilia;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JefeServicio implements IJefeServicio{

    @Autowired
    private IJefeFamilia datos;
    
    @Override
    public List<JefeFamilia> listar() {
        return (List<JefeFamilia>) datos.findAll();
    }

    @Override
    public Optional<JefeFamilia> listarPorCedula(int cedula) {
        return datos.findById(cedula);
    }

    @Override
    public int guardar(JefeFamilia p) {
        int res=0;
        JefeFamilia jefeFamilia = datos.save(p);
        if(!jefeFamilia.equals(null)){
            res=1;
        }
        return res;    }

    @Override
    public void borrar(int cedula) {
        datos.deleteById(cedula);
    }

}
