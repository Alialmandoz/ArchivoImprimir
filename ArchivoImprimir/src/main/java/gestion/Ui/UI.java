package gestion.Ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import gestion.dao.ClienteDao;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class UI {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txttelefono;
	private JLabel lblApellido;
	private JLabel lblEmail;
	private JLabel lblTelefono;
	private ModeloCliente modelo= new ModeloCliente();
	private JTable laTabla;

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
		frame.setBounds(100, 100, 657, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(tabbedPane);
		
		
		
		modelo.cargar();
		
	
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Crear Orden de trabajo", null, panel, null);
		
		JPanel cargaCliente = new JPanel();
		tabbedPane.addTab("Cargar Nuevo Cliente", null, cargaCliente, "Aqui cargas nuevos clientes a la base de datos");
		cargaCliente.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(105, 11, 497, 20);
		cargaCliente.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(105, 42, 497, 20);
		txtApellido.setColumns(10);
		cargaCliente.add(txtApellido);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(105, 76, 497, 20);
		txtEmail.setColumns(10);
		cargaCliente.add(txtEmail);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(105, 107, 497, 20);
		txttelefono.setColumns(10);
		cargaCliente.add(txttelefono);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(49, 17, 46, 14);
		cargaCliente.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(49, 48, 46, 14);
		cargaCliente.add(lblApellido);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(49, 82, 46, 14);
		cargaCliente.add(lblEmail);
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(49, 113, 46, 14);
		cargaCliente.add(lblTelefono);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(105, 138, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ClienteDao cliente = new ClienteDao();
				cliente.crearCliente(txtNombre.getText(), txtApellido.getText(),
						txtEmail.getText(), Long.parseLong(txttelefono.getText()));
				
				laTabla.getModel().addTableModelListener(new TableModelListener() {
					@Override
					public void tableChanged(TableModelEvent e) {
						System.out.println("tabla cambiada");
						modelo.cargar();
						laTabla.setModel(modelo.tableModel);
					}
				});
				
				
				
				modelo.tableModel.fireTableChanged(new TableModelEvent(modelo.tableModel));
				vaciarCampo(txtApellido);
				vaciarCampo(txtEmail);
				vaciarCampo(txtNombre);
				vaciarCampo(txttelefono);
				
			}
		});
		cargaCliente.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vaciarCampo(txtApellido);
				vaciarCampo(txtEmail);
				vaciarCampo(txtNombre);
				vaciarCampo(txttelefono);
				
			}
		});
		btnCancelar.setBounds(467, 138, 89, 23);
		cargaCliente.add(btnCancelar);
		laTabla = new JTable(modelo.tableModel);
		JScrollPane scrollPane = new JScrollPane(laTabla);
		scrollPane.setBounds(49, 170, 553, 352);
		scrollPane.getVerticalScrollBar();
		cargaCliente.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Borrar Cliente", null, panel_1, "atencion no se puede deshacer");

	}
	
	
	private void vaciarCampo(JTextField campo){
		campo.setText("");
	}
}
