package archivoImprimir.gestion;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "TRABAJO")
public class Trabajo {
	
	@Id
	@Column(name = "ID_TRABAJO")
    private Long id;

    /**
     * 
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ORDEN_TRABAJO")
    private OrdenTrabajo ordenTrabajo;
    
    
    @Column(name= "TIPO_TRABAJO")
    private TipoTrabajo tipoTrabajo;

    /**
     * 
     */
    @Column(name= "ESTADO_TRABAJO")
    private EstadoTrabajo estado;
    
    
    @Column(name = "TOTAL")
    private int total;

    /**
     * 
     */
    @Column(name = "DETALLES")
    private ArrayList<String> detallesTrabajo;
    
    public Trabajo() {
    }
    
    public Trabajo(Long id){
    	this.id = id;
    }

}