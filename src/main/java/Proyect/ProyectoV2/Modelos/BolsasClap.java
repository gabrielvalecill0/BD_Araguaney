package Proyect.ProyectoV2.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table (name = "BolsasClap")
public class BolsasClap {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idBolsa;
    int bolsasAComprar,referencia,monto;
    
    boolean efectivo;

    private String fecha;
    
    @ManyToOne
    @JoinColumn(name = "cedulaJefe", referencedColumnName = "cedulaJefe")
    private JefeFamilia jefeFamilia;

    public BolsasClap(){};

    public BolsasClap(int idBolsa, int bolsasAComprar, boolean efectivo, int referencia, int monto, String fecha, JefeFamilia jefeFamilia) {
        this.idBolsa = idBolsa;
        this.bolsasAComprar = bolsasAComprar;
        this.efectivo = efectivo;
        this.referencia = referencia;
        this.monto = monto;
        this.fecha = fecha;
        this.jefeFamilia = jefeFamilia;
    }

    public int getIdBolsa() {
        return idBolsa;
    }

    public void setIdBolsa(int idBolsa) {
        this.idBolsa = idBolsa;
    }

    public int getBolsasAComprar() {
        return bolsasAComprar;
    }

    public void setBolsasAComprar(int bolsasAComprar) {
        this.bolsasAComprar = bolsasAComprar;
    }

    public boolean getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(boolean efectivo) {
        this.efectivo = efectivo;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public JefeFamilia getJefeFamilia() {
        return jefeFamilia;
    }

    public void setJefeFamilia(JefeFamilia jefeFamilia) {
        this.jefeFamilia = jefeFamilia;
    }

    
}
