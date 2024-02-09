 package Proyect.ProyectoV2.Administradores;

import Proyect.ProyectoV2.ExportExcel.ExportDatosPersonales;
import Proyect.ProyectoV2.InterfacesServicio.IDatosServicio;
import Proyect.ProyectoV2.Modelos.DatosPersonales;
import Proyect.ProyectoV2.Modelos.JefeFamilia;
import Proyect.ProyectoV2.Servicio.DatosServicio;
import Proyect.ProyectoV2.Servicio.JefeServicio;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class DatosPersonalesAdministrador {
    
    @Autowired
    private DatosServicio servicio;
    
    @GetMapping("/index")
    public String index(Model model){
        List<DatosPersonales> datos = servicio.listar();
        int ninos = servicio.calcularNinos();
        int mayores = servicio.calcularMayores();
        model.addAttribute("objectoListar",datos);
        model.addAttribute("calcularNinos",ninos);
        model.addAttribute("calcularMayores",mayores);
    return "DatosPersonales.html";
    }
    
    @GetMapping("/DatosPersonalesIngresar")
    public String ingresar (Model model){
        model.addAttribute("DatosPersonales",new DatosPersonales());
        return "FormatoDatosPersonales.html";
    }
    
    @PostMapping("/DatosPersonalesGuardar")
    public String save(@Valid DatosPersonales p,Model model){
        servicio.guardar(p);
        return "redirect:/index";
    }
    
    @GetMapping("/DatosPersonalesEditar{cedula}")
    public String editar (@PathVariable int cedula, Model model){
    Optional <DatosPersonales> datosPersonales=servicio.listarPorCedula(cedula);
    model.addAttribute("DatosPersonales",datosPersonales);
    return "FormatoDatosPersonales.html";
    }
    
    @GetMapping("/DatosPersonalesEliminar/{cedula}")
    public String borrar (Model model, @PathVariable int cedula){
    servicio.borrar(cedula);
    return "redirect:/index";
    }
    
    @GetMapping("/indexExportar")
    public void exportar(HttpServletResponse response) throws IOException {
    response.setContentType("application/octet-stream");
    
    String cabecera = "Content-Disposition";
    String valor = "attachment; filename=DatosPersonales.xlsx";
    
    response.setHeader(cabecera,valor);
    
    List<DatosPersonales> datos = servicio.listar();
    
    ExportDatosPersonales exportar = new ExportDatosPersonales(datos);
    exportar.exportar(response);
    
    }
  
}
