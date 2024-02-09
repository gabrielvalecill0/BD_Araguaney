package Proyect.ProyectoV2.Servicio;

import Proyect.ProyectoV2.Interfaces.IDiscapacitados;
import Proyect.ProyectoV2.InterfacesServicio.IDiscapacitadosServicio;
import Proyect.ProyectoV2.Modelos.Discapacitados;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscapacitadosServicio implements IDiscapacitadosServicio{

    @Autowired
    private IDiscapacitados datos;
    
    @Override
    public List<Discapacitados> listar() {
        return (List<Discapacitados>) datos.findAll();
    }

    @Override
    public Optional<Discapacitados> listarPorCedula(int cedula) {
        return datos.findById(cedula);
    }

    @Override
    public int guardar(Discapacitados p) {
        int res=0;
        Discapacitados Discapacitados = datos.save(p);
        if(!Discapacitados.equals(null)){
            res=1;
        }
        return res;        }

    @Override
    public void borrar(int cedula) {
        datos.deleteById(cedula);
    }
    
}
