package Proyect.ProyectoV2.Modelos;

import jakarta.persistence.*;
import java.util.logging.Logger;

@Entity
@Table (name ="Discapacitados")
public class Discapacitados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String discapacidad,observacion;
    
    @OneToOne 
    @JoinColumn(name = "cedula", referencedColumnName ="cedula")
    private DatosPersonales datosPersonales;
    
    public Discapacitados(){}    

    public Discapacitados(int id, String discapacidad, String observacion, DatosPersonales datosPersonales) {
        this.id = id;
        this.discapacidad = discapacidad;
        this.observacion = observacion;
        this.datosPersonales = datosPersonales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }
    
}
