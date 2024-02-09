package Proyect.ProyectoV2.Administradores;

import Proyect.ProyectoV2.ExportExcel.ExportBolsasClap;
import Proyect.ProyectoV2.ExportExcel.ExportEnfermos;
import Proyect.ProyectoV2.Modelos.BolsasClap;
import Proyect.ProyectoV2.Modelos.Enfermos;
import Proyect.ProyectoV2.Servicio.EnfermosServicio;
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

@Controller
public class EnfermosAdministrador {
    
    @Autowired
    private EnfermosServicio servicio;
    
    @GetMapping("/Enfermos")
    public String index(Model model){
        List<Enfermos> datos = servicio.listar();
        model.addAttribute("objectoEnfermos",datos);
    return "Enfermos.html";
    }
 
    @GetMapping("/EnfermosIngresar")
    public String ingresar (Model model){
        model.addAttribute("Enfermos",new Enfermos());
        return "FormatoEnfermos.html";
    }
    
    @PostMapping("/EnfermosGuardar")
    public String save(@Valid Enfermos p,Model model){
        servicio.guardar(p);
        return "redirect:/Enfermos";
    }
    
    @GetMapping("/EnfermosEditar{cedula}")
    public String editar (@PathVariable int cedula, Model model){
    Optional <Enfermos> Enfermos=servicio.listarPorCedula(cedula);
    model.addAttribute("Enfermos",Enfermos);
    return "FormatoEnfermos.html";
    }
    
    @GetMapping("/EnfermosEliminar{cedula}")
    public String borrar (Model model, @PathVariable int cedula){
    servicio.borrar(cedula);
    return "redirect:/Enfermos";
    }
    
    @GetMapping("/EnfermosExportar")
    public void exportar(HttpServletResponse response) throws IOException {
    response.setContentType("application/octet-stream");
    
    String cabecera = "Content-Disposition";
    String valor = "attachment; filename=Enfermos.xlsx";
    
    response.setHeader(cabecera,valor);
    
    List<Enfermos> datos = servicio.listar();
    
    ExportEnfermos exportar = new ExportEnfermos(datos);
    exportar.exportar(response);
    
    }
    
}
