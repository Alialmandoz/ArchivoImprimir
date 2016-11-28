package gestion.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.common.collect.Lists;

import archivoImprimir.gestion.pojo.Cliente;

public class ClienteDao {

	public final static String[] COLUMNAS = { "Nombre", "Apellido", "Mail", "Telefono" };

	private static EntityManagerFactory emf = Emf.emf;

	public static final ArrayList<String[]> CLIENTES() {
		EntityManager man = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Cliente> lista = Lists.reverse(man.createQuery("from Cliente").getResultList());
		ArrayList<String[]> c = new ArrayList<>();

		for (Cliente cli : lista) {

			c.add(new String[] {cli.getNombre(), cli.getApellido(), cli.getMail(),
					cli.getTelefono().toString() });

		}
		return c;
	}

	public void crearCliente(String nombre, String apellido, String mail, Long telefono) {

		nombre = nombre.toLowerCase();
		apellido = apellido.toLowerCase();

		System.out.println("creando a " + nombre + " " + apellido);
		Cliente cliente = new Cliente(nombre, apellido, mail, telefono);
		EntityManager man = emf.createEntityManager();

		@SuppressWarnings("unchecked")
		List<Object> lista = man
				.createQuery("from Cliente c where nombre = '" + nombre + "' and apellido ='" + apellido + "'")
				.getResultList();
		// System.out.println(lista.size());
		if (lista.size() == 0) {
			man.getTransaction().begin();

			man.persist(cliente);

			man.getTransaction().commit();

			man.close();

		} else {
			System.out.println("el cliente " + cliente.getNombre() + " " + cliente.getApellido() + " ya existe");

		}
	}

	public ArrayList<String[]> readCliente(String nombre, String apellido) {
		EntityManager man = emf.createEntityManager();

		@SuppressWarnings("unchecked")
		List<Cliente> lista = man
				.createQuery("from Cliente c where nombre = '" + nombre + "' and apellido ='" + apellido + "'")
				.getResultList();
		
		ArrayList<String[]> c = new ArrayList<>();

		for (Cliente cli : lista) {

			c.add(new String[] {cli.getNombre(), cli.getApellido(), cli.getMail(),
					cli.getTelefono().toString() });

		}
		return c;
	}

	public int contarClientes() {
		EntityManager man = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Object> lista = man.createQuery("from Cliente").getResultList();
		return lista.size();

	}

	public int readAllClientes() {
		EntityManager man = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Object> lista = man.createQuery("from Cliente").getResultList();
		for (Object cliente : lista) {
			System.out.println(cliente.toString());
		}
		return lista.size();
	}

	public void updateNombre(Long idCliente, String nombre) {
		EntityManager man = emf.createEntityManager();
		Cliente cliente = man.find(Cliente.class, idCliente);

		man.getTransaction().begin();
		man.merge(cliente);

		cliente.setNombre(nombre.toLowerCase());

		man.getTransaction().commit();
		man.close();
	}

	public void updateApellido(Long idCliente, String apellido) {
		EntityManager man = emf.createEntityManager();
		Cliente cliente = man.find(Cliente.class, idCliente);

		man.getTransaction().begin();
		man.merge(cliente);

		cliente.setApellido(apellido.toLowerCase());

		man.getTransaction().commit();
		man.close();
	}

	public void updateMail(Long idCliente, String mail) {
		EntityManager man = emf.createEntityManager();
		Cliente cliente = man.find(Cliente.class, idCliente);

		man.getTransaction().begin();
		man.merge(cliente);

		cliente.setMail(mail.toLowerCase());

		man.getTransaction().commit();
		man.close();
	}

	public void updateTelefono(Long idCliente, Long telefono) {
		EntityManager man = emf.createEntityManager();
		Cliente cliente = man.find(Cliente.class, idCliente);

		man.getTransaction().begin();
		man.merge(cliente);

		cliente.setTelefono(telefono);

		man.getTransaction().commit();
		man.close();
	}

	public void deleteCliente(String nombre, String apellido) {
		EntityManager man = emf.createEntityManager();
		
		@SuppressWarnings("unchecked")
		List<Cliente> lista = man
				.createQuery("from Cliente c where nombre = '" + nombre + "' and apellido ='" + apellido + "'")
				.getResultList();
		
		for ( Cliente cliente : lista) {
			System.out.println(cliente);
			System.out.println(lista.size());
		}
		if (lista.size() == 1) {
			man.createQuery("delete Cliente where nombre = '" + nombre + "' and apellido ='" + apellido + "'");
			
		}else{System.out.println("mas de un resultado");}
		

	}

}
