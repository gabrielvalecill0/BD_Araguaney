package Proyect.ProyectoV2.InterfacesServicio;

import Proyect.ProyectoV2.Modelos.Enfermos;
import java.util.List;
import java.util.Optional;

public interface IEnfermosServicio {
 
    public List<Enfermos> listar();
    public Optional<Enfermos> listarPorCedula(int cedula);
    public int guardar(Enfermos p);
    public void borrar(int cedula);
    
}
