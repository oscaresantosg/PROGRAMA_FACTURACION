package co.edu.uptc.gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.modelo.Cliente;
import co.edu.uptc.modelo.Producto;
public class TablaDosImpuestos extends JPanel{
	private JTable tablaresumen;
	private DefaultTableModel model;
	
	
	 public TablaDosImpuestos() {
		 
		 
		 JScrollPane scrollPane = new JScrollPane();
		 add(scrollPane);
		 
		 tablaresumen=new JTable();
		 model=new DefaultTableModel();
		 tablaresumen.setModel(model);
		 model.addColumn("Impuesto");
		 model.addColumn("Base Gravable");
		 model.addColumn("total");
			//variables de la tabla 
		 scrollPane.setViewportView(tablaresumen);
		 tablaresumen.setPreferredScrollableViewportSize(new Dimension(350, 60));
			
		       add(scrollPane); }
				
			
	 public void llenarTabla(ArrayList<Producto> productos) {
  	   for (Producto producto: productos) {
  		   Object[]fila=new Object[3];
  		   fila[0]=producto.getPrecioIVAincluido();
  		   fila[1]=producto.getTotalBase();
  		   fila[2]=producto.getTotalImpuesto();
  		   model.addRow(fila);
  	   }
     }









}
				

			 


