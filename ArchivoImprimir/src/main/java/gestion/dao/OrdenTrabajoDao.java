package gestion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import archivoImprimir.gestion.pojo.Cliente;
import archivoImprimir.gestion.pojo.OrdenTrabajo;
import archivoImprimir.gestion.pojo.Trabajo;

public class OrdenTrabajoDao {

	private static EntityManagerFactory emf = Emf.emf;

	// Create, Read, Update and Delete

	
	public void crearOrden(String nombre, String apellido) {
		EntityManager man = emf.createEntityManager();

		@SuppressWarnings("unchecked")

		List<Object> lista = man
				.createQuery("from Cliente c where nombre = '" 
							+ nombre.toLowerCase() + "' and apellido ='" 
							+ apellido.toLowerCase() + "'")
							.getResultList();
		Cliente cli = null;
		if (lista.size() == 1) {
			cli = (Cliente) lista.get(0);
		} else {
			System.out.println("no anduvo");
		}
		OrdenTrabajo ot = new OrdenTrabajo(cli);
		man.getTransaction().begin();
		man.merge(cli);
		man.persist(ot);
		man.getTransaction().commit();
		man.close();
		System.out.println("orden " + ot.getId() + " agregada a " + cli.getNombre() + " " + cli.getApellido());
	}
	
	
	
	
	public void readAllOrdenes() {
		EntityManager man = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<OrdenTrabajo> lista = man.createQuery("from OrdenTrabajo").getResultList();
		for (OrdenTrabajo orden : lista) {
			System.out.println(orden.toString());
		}
	}
	
	
	
	
	public OrdenTrabajo readOrden(Long id) {
		EntityManager man = emf.createEntityManager();

		OrdenTrabajo orden = man.find(OrdenTrabajo.class, id);
		System.out.println(orden.toString());
		return orden;
	}
	
	
	
	
	public void listarTrabajos(Long idOrden) {
		EntityManager man = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Trabajo>lista = man.createQuery("from Trabajo where ordenTrabajo ="+idOrden).getResultList();
		for (Trabajo trabajo : lista) {
			System.out.println(trabajo.toString());
		}
	}
	public void updateTotal(Long idOrden) {
		EntityManager man = emf.createEntityManager();
		OrdenTrabajo orden = man.find(OrdenTrabajo.class, idOrden);
		
		man.getTransaction().begin();
		man.merge(orden);
		
		orden.setTotal(calcularTotal(idOrden));
		
		man.getTransaction().commit();
		man.close();
	}
	
	private int calcularTotal(Long idOrden){
		EntityManager man = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Trabajo>lista = man.createQuery("from Trabajo where ordenTrabajo ="+idOrden).getResultList();
		
		int total = 0;
		for (Trabajo trabajo : lista) {
			
			total = total + trabajo.getTotal();
		}
		return total;
		
	}
}