package Proyect.ProyectoV2.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name="Bombonas")
public class Bombonas {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idBombona;
    int bombonasAComprar,referencia,monto,kg10,kg18,kg43;
    
    boolean efectivo;

    private String fecha;
    
    @ManyToOne
    @JoinColumn(name = "cedulaJefe", referencedColumnName = "cedulaJefe")
    private JefeFamilia jefeFamilia;

    public Bombonas() {}

    public Bombonas(int idBombona, int bombonasAComprar, int referencia, int monto, int kg10, int kg18, int kg43, boolean efectivo, String fecha, JefeFamilia jefeFamilia) {
        this.idBombona = idBombona;
        this.bombonasAComprar = bombonasAComprar;
        this.referencia = referencia;
        this.monto = monto;
        this.kg10 = kg10;
        this.kg18 = kg18;
        this.kg43 = kg43;
        this.efectivo = efectivo;
        this.fecha = fecha;
        this.jefeFamilia = jefeFamilia;
    }

    public int getIdBombona() {
        return idBombona;
    }

    public void setIdBombona(int idBombona) {
        this.idBombona = idBombona;
    }

    public int getBombonasAComprar() {
        return bombonasAComprar;
    }

    public void setBombonasAComprar(int bombonasAComprar) {
        this.bombonasAComprar = bombonasAComprar;
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

    public int getKg10() {
        return kg10;
    }

    public void setKg10(int kg10) {
        this.kg10 = kg10;
    }

    public int getKg18() {
        return kg18;
    }

    public void setKg18(int kg18) {
        this.kg18 = kg18;
    }

    public int getKg43() {
        return kg43;
    }

    public void setKg43(int kg43) {
        this.kg43 = kg43;
    }

    public boolean isEfectivo() {
        return efectivo;
    }

    public void setEfectivo(boolean efectivo) {
        this.efectivo = efectivo;
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
