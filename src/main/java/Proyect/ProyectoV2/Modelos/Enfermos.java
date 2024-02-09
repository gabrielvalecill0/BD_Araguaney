package Proyect.ProyectoV2.Modelos;

import jakarta.persistence.*;

@Entity
@Table (name ="Enfermos")
public class Enfermos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String enfermedad,observacion;
    
    @OneToOne 
    @JoinColumn(name = "cedula", referencedColumnName ="cedula")
    private DatosPersonales datosPersonales;
    
    public Enfermos(){}

    public Enfermos(int id, String enfermedad, String observacion, DatosPersonales datosPersonales) {
        this.id = id;
        this.enfermedad = enfermedad;
        this.observacion = observacion;
        this.datosPersonales = datosPersonales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
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
