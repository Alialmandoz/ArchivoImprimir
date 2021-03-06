package gestion.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import archivoImprimir.gestion.pojo.EstadoTrabajo;
import archivoImprimir.gestion.pojo.OrdenTrabajo;
import archivoImprimir.gestion.pojo.TipoTrabajo;
import archivoImprimir.gestion.pojo.Trabajo;

public class TrabajoDao {
	
	
	private static EntityManagerFactory emf = Emf.emf;
	
	// Create, Read, Update and Delete
	
	public void createTrabajo() {

		EntityManager man = emf.createEntityManager();
		Trabajo trabajo = new Trabajo();
		 
    	man.getTransaction().begin();
    	
    	man.persist(trabajo);

    	LocalDateTime currentTime = LocalDateTime.now();
    	trabajo.setDetallesTrabajo("Trabajo encargado el: " + currentTime.toLocalDate());
    	man.getTransaction().commit();
    	
    	man.close();

	}
	
	
	
	public void crearTrabajo(Long idOrdenTrabajo) {
		EntityManager man = emf.createEntityManager();

		OrdenTrabajo ot = man.find(OrdenTrabajo.class, idOrdenTrabajo);
		Trabajo trabajo = new Trabajo(ot);
		man.getTransaction().begin();
		man.merge(ot);
		man.persist(trabajo);
		LocalDateTime currentTime = LocalDateTime.now();
    	trabajo.setDetallesTrabajo("Trabajo encargado el: " + currentTime.toLocalDate());
		man.getTransaction().commit();
		man.close();

	}
	
	
	
	
	public void readAllTrabajos(){
		EntityManager man = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List <Object>lista = man.createQuery("from Trabajo").getResultList();
		for (Object trabajo : lista) {
			System.out.println(trabajo.toString());
			}
		}
	
	public Trabajo readTrabajo(Long idTrabajo) {
		EntityManager man = emf.createEntityManager();
		
		Trabajo trabajo = man.find(Trabajo.class, idTrabajo);
		System.out.println(trabajo.toString());
		return trabajo;
		
	}
	
	public void updateTotal(Long idTrabajo, int total) {
		EntityManager man = emf.createEntityManager();
		Trabajo trabajo = man.find(Trabajo.class, idTrabajo);
		
		man.getTransaction().begin();
		man.merge(trabajo);
		
		trabajo.setTotal(total);
		
		man.getTransaction().commit();
		man.close();
	}
	
	public void updateTipo(Long idTrabajo, TipoTrabajo tipo) {
		EntityManager man = emf.createEntityManager();
		Trabajo trabajo = man.find(Trabajo.class, idTrabajo);
		
		man.getTransaction().begin();
		man.merge(trabajo);
		
		trabajo.setTipoTrabajo(tipo);
		
		man.getTransaction().commit();
		man.close();
	}
	
	public void updateEstado(Long idTrabajo, EstadoTrabajo estado) {
		EntityManager man = emf.createEntityManager();
		Trabajo trabajo = man.find(Trabajo.class, idTrabajo);
		
		man.getTransaction().begin();
		man.merge(trabajo);
		
		trabajo.setEstado(estado);
		
		man.getTransaction().commit();
		man.close();
	}
	
	public void updateDetalle(Long idTrabajo, String detalle) {
		EntityManager man = emf.createEntityManager();
		Trabajo trabajo = man.find(Trabajo.class, idTrabajo);
		
		man.getTransaction().begin();
		man.merge(trabajo);
		
		
		String oldDetalle = trabajo.getDetallesTrabajo();
		
		String newDetalle = detalle+"\n"+oldDetalle;
		
		
		
		trabajo.setDetallesTrabajo(newDetalle);
		
		man.getTransaction().commit();
		man.close();
	}
	
	
	
	public void updateIdOrden(Long idTrabajo,Long idOrden) {
		EntityManager man = emf.createEntityManager();
		
		OrdenTrabajo orden = man.find(OrdenTrabajo.class, idOrden);
		Trabajo trabajo = man.find(Trabajo.class, idTrabajo);
		
		man.getTransaction().begin();
		man.merge(trabajo);
		
		trabajo.setOrdenTrabajo(orden);
		
		man.getTransaction().commit();
		man.close();
	}

	public void deleteTrabajo(Long id ){
		EntityManager man = emf.createEntityManager();
		
		 Trabajo trabajo = man.find(Trabajo.class, id);
		
		man.getTransaction().begin();
		man.remove(trabajo);
		man.getTransaction().commit();
		
	}
	
	
	
	
	
	
	
	
	
	
}