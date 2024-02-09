package Proyect.ProyectoV2.Administradores;

import Proyect.ProyectoV2.ExportExcel.ExportBombonas;
import Proyect.ProyectoV2.ExportExcel.ExportJefeFamilia;
import Proyect.ProyectoV2.Modelos.BolsasClap;
import Proyect.ProyectoV2.Modelos.Bombonas;
import Proyect.ProyectoV2.Modelos.JefeFamilia;
import Proyect.ProyectoV2.Servicio.BolsasClapServicio;
import Proyect.ProyectoV2.Servicio.BombonasServicio;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class BombonasAdministrador {
    
     @Autowired
    private BombonasServicio servicio;

    @GetMapping("/Bombonas")
    public String index(Model model){
        List<Bombonas> datos = servicio.listar();
        int bombonas = servicio.calcularBombonas();
        int kg10 = servicio.calcular10kg();
        int kg18 = servicio.calcular18kg();
        int kg43 = servicio.calcular43kg();
        int montoTotal = servicio.calcularTotal();
        
        model.addAttribute("objectoBombonas",datos);
        model.addAttribute("calcularBombonas",bombonas);
        model.addAttribute("calcular10kg",kg10);
        model.addAttribute("calcular18kg",kg18);
        model.addAttribute("calcular43kg",kg43);
        model.addAttribute("montoTotal",montoTotal);
    return "Bombonas.html";
    }

    @GetMapping("/BombonasIngresar")
    public String ingresar (Model model){
        model.addAttribute("Bombonas",new Bombonas());
        return "FormatoBombonas.html";
    }
    
    @PostMapping("/BombonasGuardar")
    public String save(@Valid Bombonas p,Model model){
        servicio.guardar(p);
        return "redirect:/Bombonas";
    }
    
    @GetMapping("/BombonasEditar{cedula}")
    public String editar (@PathVariable int cedula, Model model){
    Optional <Bombonas> bombonas=servicio.listarPorCedula(cedula);
    model.addAttribute("Bombonas",bombonas);
    return "FormatoBombonas.html";
    }
    
    @GetMapping("/BombonasEliminar/{cedula}")
    public String borrar (Model model, @PathVariable int cedula){
    servicio.borrar(cedula);
    return "redirect:/Bombonas";
    }
    
    @GetMapping("/BombonasExportar")
    public void exportar(HttpServletResponse response) throws IOException {
    response.setContentType("application/octet-stream");
    
    String cabecera = "Content-Disposition";
    String valor = "attachment; filename=Bombonas.xlsx";
    
    response.setHeader(cabecera,valor);
    
    List<Bombonas> datos = servicio.listar();
    
    ExportBombonas exportar = new ExportBombonas(datos);
    exportar.exportar(response);
    
    }
    
}
