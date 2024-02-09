package Proyect.ProyectoV2.ExportExcel;

import Proyect.ProyectoV2.Modelos.BolsasClap;
import Proyect.ProyectoV2.Modelos.Bombonas;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportBolsasClap {
    
    
    private XSSFWorkbook libro;
    private XSSFSheet hoja;
    
    private List<BolsasClap> listaDatos;
    
    public ExportBolsasClap(List<BolsasClap> listaDatos){
    this.listaDatos = listaDatos;
    libro= new XSSFWorkbook();
    hoja = libro.createSheet("BolsasClap");
    
    }
    
    private void cabeceraTabla(){
        Row fila = hoja.createRow(0);
        
        CellStyle estilo = libro.createCellStyle();
        
        Cell celda = fila.createCell(0);
        celda.setCellValue("ID BOLSA");
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(1);
        celda.setCellValue("CEDULA JEFE");
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(2);
        celda.setCellValue("BOLSAS A COMPRAR");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("EFECTIVO");
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(4);
        celda.setCellValue("REFERENCIA");
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(5);
        celda.setCellValue("MONTO");
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(6);
        celda.setCellValue("FECHA");
        celda.setCellStyle(estilo);
        
    }
    
    private void escribirDatos(){
    int numeroFilas = 1;
    
    CellStyle estilo = libro.createCellStyle();
    
    for(BolsasClap dato : listaDatos){
        Row fila = hoja.createRow(numeroFilas++);
        
        Cell celda = fila.createCell(0);
        celda.setCellValue(dato.getIdBolsa());
        hoja.autoSizeColumn(0);
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(1);
        celda.setCellValue(dato.getJefeFamilia().getCedulaJefe());
        hoja.autoSizeColumn(1);
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(2);
        celda.setCellValue(dato.getBolsasAComprar());
        hoja.autoSizeColumn(2);
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(3);
        celda.setCellValue(dato.getEfectivo());
        hoja.autoSizeColumn(3);
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(4);
        celda.setCellValue(dato.getReferencia());
        hoja.autoSizeColumn(4);
        celda.setCellStyle(estilo);
    
        celda = fila.createCell(5);
        celda.setCellValue(dato.getMonto());
        hoja.autoSizeColumn(5);
        celda.setCellStyle(estilo);
        
        celda = fila.createCell(6);
        celda.setCellValue(dato.getFecha());
        hoja.autoSizeColumn(6);
        celda.setCellStyle(estilo);
    }
    }
    
    public void exportar(HttpServletResponse response) throws IOException {
    cabeceraTabla();
    escribirDatos();
    
    ServletOutputStream outputStream = response.getOutputStream();
    libro.write(outputStream);
    libro.close();
    outputStream.close();
    }
    
    
}
