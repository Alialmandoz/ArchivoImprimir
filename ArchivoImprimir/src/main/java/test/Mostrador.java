package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import archivoImprimir.gestion.Cliente;
import archivoImprimir.gestion.OrdenTrabajo;
import archivoImprimir.gestion.Trabajo;

/**
 * @author Ivan
 *
 */
public class Mostrador {
	
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	


    public static void main(String[] args) {
//    	
//    	Cliente el = new Cliente(1l, "el", "cliente", "no tiene", 123456789l);
//    	
//    	OrdenTrabajo orden = new OrdenTrabajo(el);
//    	
//    	
//    	
//    	EntityManager man = emf.createEntityManager();
//    	
//    	man.getTransaction().begin();
//    	
//    	man.persist(el);
//    	man.persist(orden);
//    	
//    	
//    	man.getTransaction().commit();
//    	man.close();
    	
    	crearCliente(1l,"ivan","almandoz","alialmandoz@gmail.com",2613835667l);
//    	crearCliente(2l,"kose","peres","jaseperes@gmail.com",2558899988554l);
//    	crearCliente(3l,"caro","cuore","carocuaore@gmail.com",2615558999l);
//    	crearCliente(4l,"piere","valmain","piervalmain@gmail.com",261555444777l);
    	
    	
    	
    	crearOrdenTrabajo(1l);
//    	crearOrdenTrabajo(1l);
    	
    	
    	
    	
    	
    	printCliente();
    	
    } 




	
	public static void crearCliente(Long id, String nombre, String apellido,String mail, Long telefono ) {
		
    	Cliente cliente = new Cliente(id, nombre, apellido, mail, telefono);
    	
    	EntityManager man = emf.createEntityManager();
    	
    	man.getTransaction().begin();
    	
    	man.persist(cliente);
    	
    	man.getTransaction().commit();
    	man.close();
	}
	
	
	/**
	 * @param idCliente : id del cliente a que se asociara esta orden
	 */
	public static void crearOrdenTrabajo(Long idCliente){
		EntityManager man = emf.createEntityManager();
		
		Cliente cli = man.find(Cliente.class, idCliente);
		
		OrdenTrabajo ot = new OrdenTrabajo(cli);

    	man.getTransaction().begin();
    	
    	man.merge(cli);
    	man.persist(ot);
    	
    	man.getTransaction().commit();
    	man.close();
	}
	
	public static void crearTrabajo(Long idOrdenTrabajo,Long idTrabajo) {
		EntityManager man = emf.createEntityManager();
		
		OrdenTrabajo ot = man.find(OrdenTrabajo.class, idOrdenTrabajo);
		Trabajo trabajo = new Trabajo(idTrabajo);
		

    	man.getTransaction().begin();
    	
    	man.merge(ot);
    	man.persist(trabajo);
    	
    	man.getTransaction().commit();
    	man.close();
		
	}
	public static void printCliente() {
		EntityManager man = emf.createEntityManager();
		
		@SuppressWarnings("unchecked")
		List <Cliente>lista = man.createQuery("FROM Cliente").getResultList();
		
		for (Cliente cliente : lista) {
			System.out.println(cliente.toString());
		}
	}

	
	public static void printOrden() {
		
		
	}
}