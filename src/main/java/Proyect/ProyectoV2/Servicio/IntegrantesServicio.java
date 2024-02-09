package Proyect.ProyectoV2.Servicio;

import Proyect.ProyectoV2.Interfaces.IIntegrantes;
import Proyect.ProyectoV2.InterfacesServicio.IIntegrantesServicio;
import Proyect.ProyectoV2.Modelos.Integrantes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrantesServicio implements IIntegrantesServicio{

    @Autowired
    private IIntegrantes datos;
    
    @Override
    public List<Integrantes> listar() {
        return (List<Integrantes>) datos.findAll();
    }

    @Override
    public Optional<Integrantes> listarPorCedula(int cedula) {
        return datos.findById(cedula);
    }

    @Override
    public int guardar(Integrantes p) {
        int res=0;
        Integrantes Integrantes = datos.save(p);
        if(!Integrantes.equals(null)){
            res=1;
        }
        return res;            }

    @Override
    public void borrar(int cedula) {
        datos.deleteById(cedula);
    }
}
