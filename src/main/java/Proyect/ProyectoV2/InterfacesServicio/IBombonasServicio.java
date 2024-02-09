package Proyect.ProyectoV2.InterfacesServicio;


import Proyect.ProyectoV2.Modelos.Bombonas;
import java.util.List;
import java.util.Optional;

public interface IBombonasServicio {
    
    public List<Bombonas> listar();
    public Optional<Bombonas> listarPorCedula(int cedula);
    public int guardar(Bombonas p);
    public void borrar(int cedula);
    
}
