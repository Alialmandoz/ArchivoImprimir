package archivoImprimir.gestion.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente { 

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_CLIENTE")
	private Long id;


	@Column(name = "NOMBRE")
	private String nombre;

	
	@Column(name = "APELLIDO")
	private String apellido;


	@Column(name = "MAIL")
	private String mail;

	
	@Column(name = "TELEFONO")
	private Long telefono;


	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<OrdenTrabajo> ordenesTrabajo = new ArrayList<>();


	public Cliente() {
	}

	public Cliente( String nombre, String apellido, String mail, Long telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public List<OrdenTrabajo> getOrdenesTrabajo() {
		return ordenesTrabajo;
	}

	public void setOrdenesTrabajo(OrdenTrabajo trabajo) {
	ordenesTrabajo.add(trabajo) ;
	}

	@Override
	public String toString() {
		return "....................................."
				+"\n"+"Cliente id = " + id 
				+"\n"+"nombre = " + nombre 
				+"\n"+"apellido = " + apellido 
				+"\n"+ "mail = " + mail 
				+"\n"+"telefono = "	+ telefono +
				"\n"+"ordenesTrabajo = " + ordenesTrabajo+"\n"
				+"....................................."+"\n";
	}
	
	

}