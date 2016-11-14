package gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import archivoImprimir.gestion.pojo.EstadoTrabajo;
import archivoImprimir.gestion.pojo.OrdenTrabajo;
import archivoImprimir.gestion.pojo.TipoTrabajo;
import archivoImprimir.gestion.pojo.Trabajo;

public class OrdenTrabajoDao {
	
	
	private static EntityManagerFactory emf = Emf.emf;
	
	// Create, Read, Update and Delete
	
	public void createOrden() {

		EntityManager man = emf.createEntityManager();
		OrdenTrabajo orden = new OrdenTrabajo();
		 
    	man.getTransaction().begin();
    	man.persist(orden);
    	orden.setTotal(0);
    	
    	
    	
    	
    	
    	
    	
    	
    	man.getTransaction().commit();
    	man.close();

	}
	
	public void readAllOrdenes(){
		EntityManager man = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List <Object>lista = man.createQuery("from OrdenTrabajo").getResultList();
		for (Object orden : lista) {
			System.out.println(orden.toString());
			}
		}
	
	public OrdenTrabajo readOrden(Long id) {
		EntityManager man = emf.createEntityManager();
		
		OrdenTrabajo orden = man.find(OrdenTrabajo.class, id);
		System.out.println(orden.toString());
		return orden;
		
	}
	
	public void adjuntarTrabajo(Long idOrden,Long idTrabajo) {
		EntityManager man = emf.createEntityManager();
		Trabajo trabajo = man.find(Trabajo.class, idTrabajo);
		OrdenTrabajo orden = man.find(OrdenTrabajo.class, idOrden);
		man.getTransaction().begin();
		man.merge(orden);
		man.persist(trabajo);
		trabajo.setOrdenTrabajo(orden);
		man.getTransaction().commit();
		man.close();
    	
		
	}
	
public void listarTrabajos(Long idOrden){
	EntityManager man = emf.createEntityManager();
	OrdenTrabajo orden = man.find(OrdenTrabajo.class, idOrden);
	man.getTransaction().begin();
	man.merge(orden);
	String trabajos = orden.getTrabajos().toString();
	System.out.println(trabajos);
	man.close();
}

}