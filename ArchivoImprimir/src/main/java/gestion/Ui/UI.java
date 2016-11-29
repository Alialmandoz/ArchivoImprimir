package gestion.Ui;

import java.awt.EventQueue;
import java.awt.dnd.MouseDragGestureRecognizer;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import archivoImprimir.gestion.pojo.Cliente;
import gestion.dao.ClienteDao;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class UI {

	
	private JFrame frame;
	private Modelo modelo= new Modelo();
	private JScrollPane scrollPane;
	private JScrollPane scrollPaneBorrar;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTable tablaCargar = modelo.crearTabla( ClienteDao.COLUMNAS, ClienteDao.CLIENTES().toArray(new Object[][] {}));
	private JTable tablaBorrar = modelo.crearTabla( ClienteDao.COLUMNAS, ClienteDao.CLIENTES().toArray(new Object[][] {}));
	private JTextField txtNomBorrar;
	private JTextField txtApellBorrar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 365, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(0, 0, 349, 561);
		frame.getContentPane().add(tabbedPane);
		
		
		
		////////////////////////////////BORRAR CLIENTE///////////////////////////////////////////////
		
		
		
		
		
		JPanel borrarCliente = new JPanel();
		borrarCliente.setBounds(0, 0, 784, 561);
		tabbedPane.addTab("Borrar Cliente", null, borrarCliente, "atencion esta accion no puede deshacerse");
		borrarCliente.setLayout(null);
		
		
		
		scrollPaneBorrar = new JScrollPane(tablaBorrar);
		scrollPaneBorrar.setBounds(10, 117, 321, 405);
		scrollPaneBorrar.getVerticalScrollBar();
		borrarCliente.add(scrollPaneBorrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 321, 101);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		borrarCliente.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBorrarNom = new JLabel("Nombre");
		lblBorrarNom.setBounds(10, 11, 110, 14);
		panel_1.add(lblBorrarNom);
		
		JLabel lblBorrarApe = new JLabel("Apellido");
		lblBorrarApe.setBounds(10, 39, 110, 14);
		panel_1.add(lblBorrarApe);
		
		txtNomBorrar = new JTextField();
		txtNomBorrar.setBounds(76, 8, 235, 20);
		panel_1.add(txtNomBorrar);
		txtNomBorrar.setColumns(10);
		
		txtApellBorrar = new JTextField();
		txtApellBorrar.setColumns(10);
		txtApellBorrar.setBounds(76, 36, 235, 20);
		panel_1.add(txtApellBorrar);
		
		JButton btnBuscarBorrar = new JButton("Buscar");
		btnBuscarBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteDao cliente = new ClienteDao();
				List<String[]> datos = cliente.readCliente(txtNomBorrar.getText(), txtApellBorrar.getText());

				tablaBorrar = new JTable(modelo.actualizarTabla(ClienteDao.COLUMNAS, datos.toArray(new Object[][] {})));
				scrollPaneBorrar.getViewport().setView(tablaBorrar);
				scrollPaneBorrar.setBounds(10, 117, 321, 405);
				scrollPaneBorrar.getVerticalScrollBar();
//				

				
			}
		});
		btnBuscarBorrar.setBounds(10, 67, 89, 23);
		panel_1.add(btnBuscarBorrar);
		
		JButton btnCancelarBorrar = new JButton("Actualizar");
		btnCancelarBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablaBorrar = new JTable(modelo.actualizarTabla(ClienteDao.COLUMNAS, ClienteDao.CLIENTES().toArray(new Object[][] {})));
				scrollPaneBorrar.getViewport().setView(tablaBorrar);
				scrollPaneBorrar.setBounds(10, 117, 321, 405);
				scrollPaneBorrar.getVerticalScrollBar();
				
				vaciarCampo(txtNomBorrar);
				vaciarCampo(txtApellBorrar);
			}
		});
		btnCancelarBorrar.setBounds(109, 67, 103, 23);
		panel_1.add(btnCancelarBorrar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(222, 67, 89, 23);
		panel_1.add(btnBorrar);
		
		
		
		
		
		
		////////////////////////////////CARGAR CLIENTE///////////////////////////////////////////////
		
		
		
		
		JPanel cargaCliente = new JPanel();
		tabbedPane.addTab("Cargar Nuevo Cliente", null, cargaCliente, "Aqui cargas nuevos clientes a la base de datos");
		cargaCliente.setLayout(null);
		
				scrollPane = new JScrollPane(tablaCargar);
				scrollPane.setBounds(25, 202, 302, 320);
				scrollPane.getVerticalScrollBar();
				cargaCliente.add(scrollPane);
				
				JPanel panel = new JPanel();
				panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel.setBounds(25, 18, 302, 173);
				cargaCliente.add(panel);
				panel.setLayout(null);
				
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setVerticalAlignment(SwingConstants.TOP);
				lblNombre.setBounds(10, 14, 125, 14);
				panel.add(lblNombre);
				
				JLabel label_1 = new JLabel("Apellido");
				label_1.setVerticalAlignment(SwingConstants.TOP);
				label_1.setBounds(10, 45, 125, 14);
				panel.add(label_1);
				
				JLabel label_2 = new JLabel("Email");
				label_2.setVerticalAlignment(SwingConstants.TOP);
				label_2.setBounds(10, 79, 125, 14);
				panel.add(label_2);
				
				JLabel label_3 = new JLabel("Telefono");
				label_3.setVerticalAlignment(SwingConstants.TOP);
				label_3.setBounds(10, 110, 125, 14);
				panel.add(label_3);
				
				txtTelefono = new JTextField();
				label_3.setLabelFor(txtTelefono);
				txtTelefono.setBounds(93, 107, 188, 20);
				panel.add(txtTelefono);
				txtTelefono.setColumns(10);
				
				txtEmail = new JTextField();
				label_2.setLabelFor(txtEmail);
				txtEmail.setBounds(93, 76, 188, 20);
				panel.add(txtEmail);
				txtEmail.setColumns(10);
				
				txtApellido = new JTextField();
				label_1.setLabelFor(txtApellido);
				txtApellido.setBounds(93, 42, 188, 20);
				panel.add(txtApellido);
				txtApellido.setColumns(10);
				
				txtNombre = new JTextField();
				lblNombre.setLabelFor(txtNombre);
				txtNombre.setBounds(93, 11, 188, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
				
				JButton bCargar = new JButton("Cargar");
				bCargar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ClienteDao cliente = new ClienteDao();
						cliente.crearCliente(txtNombre.getText(), txtApellido.getText(), txtEmail.getText(), Long.parseLong(txtTelefono.getText()));
						
						scrollPane = new JScrollPane(new JTable(modelo.actualizarTabla( ClienteDao.COLUMNAS, ClienteDao.CLIENTES().toArray(new Object[][] {}))));
						scrollPane.setBounds(25, 202, 302, 320);
						scrollPane.getVerticalScrollBar();
						cargaCliente.add(scrollPane);
//						
						vaciarCampo(txtNombre);
						vaciarCampo(txtApellido);
						vaciarCampo(txtEmail);
						vaciarCampo(txtTelefono);
						
						
						
					}
				});
				bCargar.setBounds(45, 138, 89, 23);
				panel.add(bCargar);
				
				JButton button_1 = new JButton("Cancelar");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						vaciarCampo(txtNombre);
						vaciarCampo(txtApellido);
						vaciarCampo(txtEmail);
						vaciarCampo(txtTelefono);
					}
				});
				button_1.setBounds(162, 138, 75, 23);
				panel.add(button_1);

	}
	
	
	private void vaciarCampo(JTextField campo){
		campo.setText("");
	}
}
