package Proyect.ProyectoV2.InterfacesServicio;

import Proyect.ProyectoV2.Modelos.DatosPersonales;
import java.util.List;
import java.util.Optional;

public interface IDatosServicio {
    
    public List<DatosPersonales> listar();
    public Optional<DatosPersonales> listarPorCedula(int cedula);
    public int guardar(DatosPersonales p);
    public void borrar(int cedula);
    
}
