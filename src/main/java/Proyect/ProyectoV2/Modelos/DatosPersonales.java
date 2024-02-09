package Proyect.ProyectoV2.Modelos;

import Proyect.ProyectoV2.Interfaces.IDatosPersonales;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table (name ="DatosPersonales")
public class DatosPersonales {
    
    @Id
    int cedula;
    String nombre,apellido,direccion,fNacimiento,fResidencia,status;
    
    int edad;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private JefeFamilia jefeFamilia;
  
    @OneToOne()
    private Enfermos enfermos;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Discapacitados discapacitados;

    @PostLoad
    public void calcularEdad() {
    LocalDate fechaNacimiento = LocalDate.parse(fNacimiento);
    edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
    
    }
    
    public DatosPersonales(){}

    public DatosPersonales(int cedula, String nombre, String apellido, String direccion, String fNacimiento, String fResidencia, String status, int edad, JefeFamilia jefeFamilia, Enfermos enfermos, Discapacitados discapacitados) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fNacimiento = fNacimiento;
        this.fResidencia = fResidencia;
        this.status = status;
        this.edad = edad;
        this.jefeFamilia = jefeFamilia;
        this.enfermos = enfermos;
        this.discapacitados = discapacitados;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getfResidencia() {
        return fResidencia;
    }

    public void setfResidencia(String fResidencia) {
        this.fResidencia = fResidencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public JefeFamilia getJefeFamilia() {
        return jefeFamilia;
    }

    public void setJefeFamilia(JefeFamilia jefeFamilia) {
        this.jefeFamilia = jefeFamilia;
    }

    public Enfermos getEnfermos() {
        return enfermos;
    }

    public void setEnfermos(Enfermos enfermos) {
        this.enfermos = enfermos;
    }

    public Discapacitados getDiscapacitados() {
        return discapacitados;
    }

    public void setDiscapacitados(Discapacitados discapacitados) {
        this.discapacitados = discapacitados;
    }

    
    
}
