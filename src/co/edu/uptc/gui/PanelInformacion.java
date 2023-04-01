package co.edu.uptc.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelInformacion extends JPanel {

	private JTextArea txInformacion;
	
	public PanelInformacion(Eventos evento) {
		JLabel lbInfo= new JLabel(" ingrese la cadena de texto asi  Código|Descripción|Precio base|Porcentaje Impuesto|Cantidad");
		
		
		txInformacion= new JTextArea("");
		txInformacion.setPreferredSize(new Dimension(750, 120));
		
		JScrollPane sp = new JScrollPane(txInformacion);  
		JTextArea ta = new JTextArea();
		//JScrollPane sp = new JScrollPane(ta);  

		// Add the scroll pane into the content pane
	
		// getContentPane().add(sp);

		// Add the scroll pane into the content pane
		
		
		JButton accion1= new JButton(Eventos.CARGAR);
		 accion1.setBackground(new java.awt.Color(153, 255, 255));
	        accion1.setText("Cargar");
		
		accion1.addActionListener(evento);
		accion1.setActionCommand(Eventos.CARGAR);
		setLayout(new BorderLayout());
		
		add(lbInfo,BorderLayout.NORTH);
		
		add(txInformacion,BorderLayout.CENTER);
		add(accion1,BorderLayout.SOUTH);
		
	}
	
	public String obtenerDatos() {
		return txInformacion.getText();
		
	}
}
