package Proyect.ProyectoV2.Administradores;

import Proyect.ProyectoV2.ExportExcel.ExportBolsasClap;
import Proyect.ProyectoV2.ExportExcel.ExportBombonas;
import Proyect.ProyectoV2.Modelos.BolsasClap;
import Proyect.ProyectoV2.Modelos.Bombonas;
import Proyect.ProyectoV2.Servicio.BolsasClapServicio;
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
public class BolsasClapAdministrador {

    @Autowired
    private BolsasClapServicio servicio;
    
    @GetMapping("/BolsasClap")
    public String index(Model model){
        List<BolsasClap> datos = servicio.listar();
        int bolsas = servicio.calcularBolsas();
        int montoTotal = servicio.calcularTotal();
        
        model.addAttribute("objectoBolsasClap",datos);
        model.addAttribute("bolsas",bolsas);
        model.addAttribute("montoTotal",montoTotal);
    return "BolsasClap.html";
    }

    @GetMapping("/BolsasClapIngresar")
    public String ingresar (Model model){
        model.addAttribute("BolsasClap",new BolsasClap());
        return "FormatoBolsasClap.html";
    }
    
    @PostMapping("/BolsasClapGuardar")
    public String save(@Valid BolsasClap p,Model model){
        servicio.guardar(p);
        return "redirect:/BolsasClap";
    }
    
    @GetMapping("/BolsasClapEditar{cedula}")
    public String editar (@PathVariable int cedula, Model model){
    Optional <BolsasClap> bolsasClap=servicio.listarPorCedula(cedula);
    model.addAttribute("BolsasClap",bolsasClap);
    return "FormatoBolsasClap.html";
    }
    
    @GetMapping("/BolsasClapEliminar/{cedula}")
    public String borrar (Model model, @PathVariable int cedula){
    servicio.borrar(cedula);
    return "redirect:/BolsasClap";
    }
    
    @GetMapping("/BolsasClapExportar")
    public void exportar(HttpServletResponse response) throws IOException {
    response.setContentType("application/octet-stream");
    
    String cabecera = "Content-Disposition";
    String valor = "attachment; filename=BolsasClap.xlsx";
    
    response.setHeader(cabecera,valor);
    
    List<BolsasClap> datos = servicio.listar();
    
    ExportBolsasClap exportar = new ExportBolsasClap(datos);
    exportar.exportar(response);
    
    }
}