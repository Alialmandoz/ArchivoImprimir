package gestion.Ui;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class Modelo {

	public AbstractTableModel model = new DefaultTableModel();
	public JTable tabla;
	
	
	public JTable crearTabla(Object[] columnas, Object[][] datos) {
		DefaultTableModel model = new DefaultTableModel(datos,columnas);
		JTable tabla = new JTable(model);
		
		return tabla;
		}

	public AbstractTableModel actualizarTabla(Object[] columnas, Object[][] datos){
		System.out.println("pasando datos al modelo...");
		DefaultTableModel model = new DefaultTableModel(datos, columnas);
		return model;
	}

}
