//package gestion.Ui;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JScrollPane;
//
//public class Test extends JFrame {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Test frame = new Test();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public Test() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 555, 529);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		
//		
//		Modelo modelo = new Modelo();
//		
//		ArrayList<String> columnas = new ArrayList<String>() {/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//		{
//		    add("A");
//		    add("B");
//		    add("C");
//		}};
//		
//		String[] a = {"A", "B", "C"};
//		String[] b = {"D", "E", "F"};
//		String[] c = {"G", "H", "I"};
//		ArrayList<String[]> datos = new ArrayList<String[]>() {/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//		{
//		    add(a);
//		    add(b);
//		    add(c);
//		}};
//	
//		
//		JScrollPane scrollPane = new JScrollPane(modelo.crearTabla(columnas, datos));
//		scrollPane.setBounds(55, 119, 434, 339);
//		contentPane.add(scrollPane);
//	}
//}