package Proyect.ProyectoV2.Servicio;

import Proyect.ProyectoV2.Interfaces.IBolsasClap;
import Proyect.ProyectoV2.Interfaces.IBombonas;
import Proyect.ProyectoV2.InterfacesServicio.IBombonasServicio;
import Proyect.ProyectoV2.Modelos.BolsasClap;
import Proyect.ProyectoV2.Modelos.Bombonas;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BombonasServicio implements IBombonasServicio{
    
     @Autowired
    private IBombonas datos;

    @Override
    public List<Bombonas> listar() {
        return (List<Bombonas>) datos.findAll();
    }

    @Override
    public Optional<Bombonas> listarPorCedula(int cedula) {
        return datos.findById(cedula);
    }

    @Override
    public int guardar(Bombonas p) {
        int res=0;
        Bombonas bombonas = datos.save(p);
        if(!bombonas.equals(null)){
            res=1;
        }
        return res;            }

    @Override
    public void borrar(int cedula) {
    datos.deleteById(cedula);
    }
    
    public int calcularBombonas(){
    int bombonas = datos.contadorBombonas();
    return bombonas;
    }
    
    public int calcular10kg(){
    int kg10 = datos.contador10kg();
    return kg10;
    }
    
    public int calcular18kg(){
    int kg18 = datos.contador18kg();
    return kg18;
    }
    
        public int calcular43kg(){
    int kg43 = datos.contador43kg();
    return kg43;
    }
        
        public int calcularTotal(){
    int montoTotal = datos.MontoTotal();
    return montoTotal;
    }
        
}
