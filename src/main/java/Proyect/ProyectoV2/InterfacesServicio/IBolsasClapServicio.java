package Proyect.ProyectoV2.InterfacesServicio;

import Proyect.ProyectoV2.Modelos.BolsasClap;
import Proyect.ProyectoV2.Modelos.JefeFamilia;
import java.util.List;
import java.util.Optional;

public interface IBolsasClapServicio {

    public List<BolsasClap> listar();
    public Optional<BolsasClap> listarPorCedula(int cedula);
    public int guardar(BolsasClap p);
    public void borrar(int cedula);
    
}
