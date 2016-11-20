package archivoImprimir.gestion.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
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
    private String detallesTrabajo;
    
    public Trabajo() {
    }
    
    public Trabajo( OrdenTrabajo ordenTabajo){
    	this.ordenTrabajo = ordenTabajo;
    }
    


	@Override
	public String toString() {
		return "Trabajo id: " + id + "\n"
				+"....................................." + "\n"
				+ " tipoTrabajo = " + tipoTrabajo + "\n"
				+ " estado = "+ estado+ "\n"
				+ " total = " + total + "\n"
				+ " detallesTrabajo = " + detallesTrabajo + "\n"
				+ " OrdenTrabajo = " + ordenTrabajo.getId() + "\n"
				+".....................................";
	}//    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrdenTrabajo getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public TipoTrabajo getTipoTrabajo() {
		return tipoTrabajo;
	}

	public void setTipoTrabajo(TipoTrabajo tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}

	public EstadoTrabajo getEstado() {
		return estado;
	}

	public void setEstado(EstadoTrabajo estado) {
		this.estado = estado;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getDetallesTrabajo() {
		return detallesTrabajo;
	}

	public void setDetallesTrabajo(String detalle) {
		this.detallesTrabajo = detalle;
	}
    
    
    
    

}