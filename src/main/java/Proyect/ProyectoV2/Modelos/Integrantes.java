package Proyect.ProyectoV2.Modelos;

import jakarta.persistence.*;


@Entity
@Table (name = "Integrantes")
public class Integrantes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @ManyToOne 
    @JoinColumn(name = "cedulaJefe", referencedColumnName ="cedulaJefe")
    private JefeFamilia jefeFamilia;
    
    @OneToOne 
    @JoinColumn(name = "cedula", referencedColumnName ="cedula")
    private DatosPersonales datosPersonales;
    
    public Integrantes(){}
    
    public Integrantes(int id, JefeFamilia jefeFamilia, DatosPersonales datosPersonales) {
        this.id = id;
        this.jefeFamilia = jefeFamilia;
        this.datosPersonales = datosPersonales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JefeFamilia getJefeFamilia() {
        return jefeFamilia;
    }

    public void setJefeFamilia(JefeFamilia jefeFamilia) {
        this.jefeFamilia = jefeFamilia;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }
    
}
