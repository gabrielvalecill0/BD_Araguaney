package Proyect.ProyectoV2.Modelos;

import jakarta.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table (name ="JefeFamilia")
public class JefeFamilia {
    
    @Id
    int cedulaJefe;
    int nroDiscapacitados,cargaFamiliar;
    
    boolean recibesBombonas,recibesClap;
    
    @OneToOne 
    @JoinColumn(name = "cedula", referencedColumnName ="cedula")
    private DatosPersonales datosPersonales;
    
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Integrantes> Integrantes;   
    
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BolsasClap> bolsasClap;   
    
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bombonas> bombonas;  
    
    public JefeFamilia(){};

    public JefeFamilia(int cedulaJefe, int nroDiscapacitados, int cargaFamiliar, boolean recibesBombonas, boolean recibesClap, DatosPersonales datosPersonales, List<Integrantes> Integrantes, List<BolsasClap> bolsasClap, List<Bombonas> bombonas) {
        this.cedulaJefe = cedulaJefe;
        this.nroDiscapacitados = nroDiscapacitados;
        this.cargaFamiliar = cargaFamiliar;
        this.recibesBombonas = recibesBombonas;
        this.recibesClap = recibesClap;
        this.datosPersonales = datosPersonales;
        this.Integrantes = Integrantes;
        this.bolsasClap = bolsasClap;
        this.bombonas = bombonas;
    }

    public int getCedulaJefe() {
        return cedulaJefe;
    }

    public void setCedulaJefe(int cedulaJefe) {
        this.cedulaJefe = cedulaJefe;
    }

    public int getNroDiscapacitados() {
        return nroDiscapacitados;
    }

    public void setNroDiscapacitados(int nroDiscapacitados) {
        this.nroDiscapacitados = nroDiscapacitados;
    }

    public int getCargaFamiliar() {
        return cargaFamiliar;
    }

    public void setCargaFamiliar(int cargaFamiliar) {
        this.cargaFamiliar = cargaFamiliar;
    }

    public boolean isRecibesBombonas() {
        return recibesBombonas;
    }

    public void setRecibesBombonas(boolean recibesBombonas) {
        this.recibesBombonas = recibesBombonas;
    }

    public boolean isRecibesClap() {
        return recibesClap;
    }

    public void setRecibesClap(boolean recibesClap) {
        this.recibesClap = recibesClap;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public List<Integrantes> getIntegrantes() {
        return Integrantes;
    }

    public void setIntegrantes(List<Integrantes> Integrantes) {
        this.Integrantes = Integrantes;
    }

    public List<BolsasClap> getBolsasClap() {
        return bolsasClap;
    }

    public void setBolsasClap(List<BolsasClap> bolsasClap) {
        this.bolsasClap = bolsasClap;
    }

    public List<Bombonas> getBombonas() {
        return bombonas;
    }

    public void setBombonas(List<Bombonas> bombonas) {
        this.bombonas = bombonas;
    }

    
    
}
