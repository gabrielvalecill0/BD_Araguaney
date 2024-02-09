package Proyect.ProyectoV2.Servicio;

import Proyect.ProyectoV2.Interfaces.IDatosPersonales;
import Proyect.ProyectoV2.InterfacesServicio.IDatosServicio;
import Proyect.ProyectoV2.Modelos.DatosPersonales;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosServicio implements IDatosServicio{

    @Autowired
    private IDatosPersonales datos;
    
    @Override
    public List<DatosPersonales> listar() {
        return (List<DatosPersonales>) datos.findAll();
    }

    @Override
    public Optional<DatosPersonales> listarPorCedula(int cedula) {
        return datos.findById(cedula);
    }

    @Override
    public int guardar(DatosPersonales p) {
        int res=0;
        DatosPersonales datosPersonales = datos.save(p);
        if(!datosPersonales.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void borrar(int cedula) {
        datos.deleteById(cedula);
    }
    
    public int calcularNinos(){
    int ninos = datos.contadorNinos();
    return ninos;
    }
    
    public int calcularMayores(){
    int mayores = datos.contadorMayores();
    return mayores;
    }
    
}
