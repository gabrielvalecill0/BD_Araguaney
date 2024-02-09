
package Proyect.ProyectoV2.Servicio;

import Proyect.ProyectoV2.Interfaces.IBolsasClap;
import Proyect.ProyectoV2.InterfacesServicio.IBolsasClapServicio;
import Proyect.ProyectoV2.Modelos.BolsasClap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BolsasClapServicio implements IBolsasClapServicio{

    @Autowired
    private IBolsasClap datos;
    
    @Override
    public List<BolsasClap> listar() {
        return (List<BolsasClap>) datos.findAll();
    }

    @Override
    public Optional<BolsasClap> listarPorCedula(int cedula) {
        return datos.findById(cedula);
    }

    @Override
    public int guardar(BolsasClap p) {
    int res=0;
        BolsasClap bolsasClap = datos.save(p);
        if(!bolsasClap.equals(null)){
            res=1;
        }
        return res;        }

    @Override
    public void borrar(int cedula) {
    datos.deleteById(cedula);
    }
    
    public int calcularBolsas(){
    int bolsas = datos.contadorBolsas();
    return bolsas;
    }
    
    public int calcularTotal(){
    int MontoTotal = datos.MontoTotal();
    return MontoTotal;
    }
    
}
