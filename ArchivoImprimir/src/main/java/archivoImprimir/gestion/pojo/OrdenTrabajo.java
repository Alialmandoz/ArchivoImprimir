package archivoImprimir.gestion;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDEN_TRABAJO")
public class OrdenTrabajo {


	@Id
	@Column(name= "ID_ORDEN_TRABAJO")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	@OneToMany(mappedBy = "ordenTrabajo", cascade = CascadeType.ALL)
	@Column(name = "LISTA_TRABAJOS")
    private static List<Trabajo> trabajos = new ArrayList<>();


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;


	@Column(name = "TOTAL")
    private int total;

	
	
    public OrdenTrabajo() {
    
    }
    
    public OrdenTrabajo(Cliente cliente){
    	this.cliente = cliente;
    }

    public void adjuntarTrabajo(Trabajo trabajo) {
    	trabajos.add(trabajo);
		
	}
}