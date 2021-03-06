package archivoImprimir.gestion.pojo;

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

import gestion.dao.TrabajoDao;

@Entity
@Table(name = "ORDEN_TRABAJO")
public class OrdenTrabajo {


	@Id
	@Column(name= "ID_ORDEN_TRABAJO")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	
	@Column(name = "LISTA_TRABAJOS")
	@OneToMany(mappedBy = "ordenTrabajo", cascade = CascadeType.ALL)
    private static List<Trabajo> listaTrabajos = new ArrayList<>();


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
    	listaTrabajos.add(trabajo);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public static void setTrabajos(List<Trabajo> trabajos) {
		OrdenTrabajo.listaTrabajos = trabajos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public List<Trabajo> getTrabajos() {
		return listaTrabajos;
		
	}
	
	public String ListarTrabajos(){
		String lista = null;
		
		for (Trabajo trabajo : listaTrabajos) {
			lista = trabajo.getId().toString();
		}
		return lista;
		}

	@Override
	public String toString() {
		return    "\n"+"....................................."
				+ "\n"+"OrdenTrabajo N:" + id+"\n"
				+ " Cliente: " + cliente.getNombre()+" "+cliente.getApellido() +"\n"
				+ " total: " + total+"\n" 
				+ "....................................."+"\n";
	}
}