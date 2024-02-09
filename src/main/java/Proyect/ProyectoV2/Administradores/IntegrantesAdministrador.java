package Proyect.ProyectoV2.Administradores;

import Proyect.ProyectoV2.ExportExcel.ExportIntegrantes;
import Proyect.ProyectoV2.ExportExcel.ExportJefeFamilia;
import Proyect.ProyectoV2.Modelos.Integrantes;
import Proyect.ProyectoV2.Modelos.JefeFamilia;
import Proyect.ProyectoV2.Servicio.IntegrantesServicio;
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
public class IntegrantesAdministrador {
    
    @Autowired
    private IntegrantesServicio servicio;
    
    @GetMapping("/Integrantes")
    public String index(Model model){
        List<Integrantes> datos = servicio.listar();
        model.addAttribute("objectoIntegrantes",datos);
    return "Integrantes.html";
    }
 
    @GetMapping("/IntegrantesIngresar")
    public String ingresar (Model model){
        model.addAttribute("Integrante",new Integrantes());
        return "FormatoIntegrantes.html";
    }
    
    @PostMapping("/IntegrantesGuardar")
    public String save(@Valid Integrantes p,Model model){
        servicio.guardar(p);
        return "redirect:/Integrantes";
    }
    
    @GetMapping("/IntegrantesEliminar/{cedula}")
    public String borrar (Model model, @PathVariable int cedula){
    servicio.borrar(cedula);
    return "redirect:/Integrantes";
    }
    
    @GetMapping("/IntegrantesExportar")
    public void exportar(HttpServletResponse response) throws IOException {
    response.setContentType("application/octet-stream");
    
    String cabecera = "Content-Disposition";
    String valor = "attachment; filename=Integrantes.xlsx";
    
    response.setHeader(cabecera,valor);
    
    List<Integrantes> datos = servicio.listar();
    
    ExportIntegrantes exportar = new ExportIntegrantes(datos);
    exportar.exportar(response);
    
    }
    
}
