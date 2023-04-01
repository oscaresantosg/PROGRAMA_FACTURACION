package co.edu.uptc.gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.modelo.Cliente;
import co.edu.uptc.modelo.Producto;

public class Tabla extends JPanel{
	private JTable tablaProductos;
	private DefaultTableModel model;


	 public Tabla() {
    
	 JScrollPane scrollPane = new JScrollPane();
	 add(scrollPane);
	 scrollPane.setBounds(10, 40, 800, 7); 
	 tablaProductos=new JTable();
	 model=new DefaultTableModel();
	 tablaProductos.setModel(model);
	 //model.addColumn("Tipo Documento");
	 //model.addColumn("Numero de Documento");
	 model.addColumn("Codigo");
	 model.addColumn("Descripcion");
	 model.addColumn("Cantidad");
	 model.addColumn("Precio base");
	 model.addColumn("IVA");
	 model.addColumn("Precio Total");
	
    scrollPane.setViewportView(tablaProductos);
    tablaProductos.setPreferredScrollableViewportSize(new Dimension(500, 60));
	add(scrollPane);	 }
 public void llenarTabla(ArrayList<Producto> productos) {
	 
	 for (Producto producto:productos) {
		 Object[]fila=new Object[6];
	//	 fila[0]=clientes.get();
		 fila[0]=producto.getCodigo();
		 fila[1]=producto.getDescripcion();
		 fila[2]=producto.getCantidad();
		 fila[3]=producto.getPrecioBase();
		 fila[4]=producto.getPrecioIVAincluido();
		 fila[5]=producto.getTotal();
		 model.addRow(fila);
		 
	 }
 }


	}
	 	 
