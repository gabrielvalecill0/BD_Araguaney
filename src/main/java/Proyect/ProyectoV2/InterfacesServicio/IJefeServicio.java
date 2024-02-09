package Proyect.ProyectoV2.InterfacesServicio;

import Proyect.ProyectoV2.Modelos.JefeFamilia;
import java.util.List;
import java.util.Optional;


public interface IJefeServicio {
    
    public List<JefeFamilia> listar();
    public Optional<JefeFamilia> listarPorCedula(int cedula);
    public int guardar(JefeFamilia p);
    public void borrar(int cedula);
    
}
