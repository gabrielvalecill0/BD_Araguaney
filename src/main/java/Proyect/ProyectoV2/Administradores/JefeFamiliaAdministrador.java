package Proyect.ProyectoV2.Administradores;

import Proyect.ProyectoV2.ExportExcel.ExportDatosPersonales;
import Proyect.ProyectoV2.ExportExcel.ExportJefeFamilia;
import Proyect.ProyectoV2.Modelos.DatosPersonales;
import Proyect.ProyectoV2.Modelos.JefeFamilia;
import Proyect.ProyectoV2.Servicio.JefeServicio;
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
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class JefeFamiliaAdministrador {
    
    @Autowired
    private JefeServicio servicio;
    
    @GetMapping("/JefeFamilia")
    public String index(Model model){
        List<JefeFamilia> datos = servicio.listar();
        model.addAttribute("objectoJefe",datos);
    return "JefeFamilia.html";
    }
 
    @GetMapping("/JefeFamiliaIngresar")
    public String ingresar (Model model){
        model.addAttribute("JefeFamilia",new JefeFamilia());
        return "FormatoJefeFamilia.html";
    }
    
    @PostMapping("/JefeFamiliaGuardar")
    public String save(@Valid JefeFamilia p,Model model){
        servicio.guardar(p);
        return "redirect:/JefeFamilia";
    }
    
    @GetMapping("/JefeFamiliaEditar{cedula}")
    public String editar (@PathVariable int cedula, Model model){
    Optional <JefeFamilia> JefeFamilia=servicio.listarPorCedula(cedula);
    model.addAttribute("JefeFamilia",JefeFamilia);
    return "FormatoJefeFamilia.html";
    }
    
    @GetMapping("/JefeFamiliaEliminar/{cedula}")
    public String borrar (Model model, @PathVariable int cedula){
    servicio.borrar(cedula);
    return "redirect:/JefeFamilia";
    }
    
    @GetMapping("/JefeFamiliaExportar")
    public void exportar(HttpServletResponse response) throws IOException {
    response.setContentType("application/octet-stream");
    
    String cabecera = "Content-Disposition";
    String valor = "attachment; filename=JefeFamilia.xlsx";
    
    response.setHeader(cabecera,valor);
    
    List<JefeFamilia> datos = servicio.listar();
    
    ExportJefeFamilia exportar = new ExportJefeFamilia(datos);
    exportar.exportar(response);
    
    }
    
}
