package gestion.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Emf {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

}
