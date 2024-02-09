package Proyect.ProyectoV2.Administradores;

import Proyect.ProyectoV2.ExportExcel.ExportDiscapacitados;
import Proyect.ProyectoV2.ExportExcel.ExportEnfermos;
import Proyect.ProyectoV2.Modelos.Discapacitados;
import Proyect.ProyectoV2.Modelos.Enfermos;
import Proyect.ProyectoV2.Servicio.DiscapacitadosServicio;
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
public class DiscapacitadosAdministrador {
    
    @Autowired
    private DiscapacitadosServicio servicio;
    
    @GetMapping("/Discapacitados")
    public String index(Model model){
        List<Discapacitados> datos = servicio.listar();
        model.addAttribute("objectoDiscapacitados",datos);
    return "Discapacitados.html";
    }
 
    @GetMapping("/DiscapacitadosIngresar")
    public String ingresar (Model model){
        model.addAttribute("Discapacitados",new Discapacitados());
        return "FormatoDiscapacitados.html";
    }
    
    @PostMapping("/DiscapacitadosGuardar")
    public String save(@Valid Discapacitados p,Model model){
        servicio.guardar(p);
        return "redirect:/Discapacitados";
    }
    
    @GetMapping("/DiscapacitadosEditar{cedula}")
    public String editar (@PathVariable int cedula, Model model){
    Optional <Discapacitados> Discapacitados=servicio.listarPorCedula(cedula);
    model.addAttribute("Discapacitados",Discapacitados);
    return "FormatoDiscapacitados.html";
    }
    
    @GetMapping("/DiscapacitadosEliminar{cedula}")
    public String borrar (Model model, @PathVariable int cedula){
    servicio.borrar(cedula);
    return "redirect:/Discapacitados";
    }
 
    @GetMapping("/DiscapacitadosExportar")
    public void exportar(HttpServletResponse response) throws IOException {
    response.setContentType("application/octet-stream");
    
    String cabecera = "Content-Disposition";
    String valor = "attachment; filename=Discapacitados.xlsx";
    
    response.setHeader(cabecera,valor);
    
    List<Discapacitados> datos = servicio.listar();
    
    ExportDiscapacitados exportar = new ExportDiscapacitados(datos);
    exportar.exportar(response);
    
    }
    
    
}
