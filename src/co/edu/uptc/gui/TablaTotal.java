package co.edu.uptc.gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.modelo.Producto;

public class TablaTotal extends JPanel{
	
	private JTable tablatot;
	private DefaultTableModel model;
	public TablaTotal() {
		
			 
			 
			 JScrollPane scrollPane = new JScrollPane();
			 add(scrollPane);
			 
			 tablatot=new JTable();
			 model=new DefaultTableModel();
			 tablatot.setModel(model);
			 model.addColumn("subtotal");
			 model.addColumn("total impuesto");
			 model.addColumn("total valor");
				//variables de la tabla 
			 scrollPane.setViewportView(tablatot);
			 tablatot.setPreferredScrollableViewportSize(new Dimension(350, 60));
				
			       add(scrollPane); }
					
				
		 public void llenarTabla(ArrayList<Producto> productos) {
	  	   for (Producto producto: productos) { //vector producto
	  		   Object[]fila=new Object[3];
	  		   fila[0]=producto.getSubTotal();
	  		   fila[1]=producto.getTotalImpuesto();
	  		   fila[2]=producto.getTotal();
	  		   model.addRow(fila);
	  	   }
	     }

			 


	}






