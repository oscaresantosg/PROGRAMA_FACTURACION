package co.edu.uptc.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.uptc.modelo.Producto;
import co.edu.uptc.negocio.TiendaBean;

public class VentanaPrincipal extends JFrame {
	private PanelAcciones texto;
	private PanelInformacion info;
	private TiendaBean tienda;
	private Tabla tabla;
	private TablaDosImpuestos tablaresumen;
	private TablaTotal tablaTotal;

	public VentanaPrincipal(){
		setTitle("PROGRAMA FACTURACION");
		setSize(1100,700);
		tienda= new TiendaBean();
		Eventos evento= new Eventos(this);
		info= new PanelInformacion(evento);
		texto= new PanelAcciones(evento);
		tabla=new Tabla();
		tablaresumen=new TablaDosImpuestos();
		tablaTotal=new TablaTotal();
		setLayout(new BorderLayout());
	
		JPanel ParteInformacion= new JPanel();
		ParteInformacion.add(info);
		ParteInformacion.add(texto);
		
		add(ParteInformacion, BorderLayout.NORTH);
		
		
		JPanel prod = new JPanel();
		prod.add(tabla);
		add(prod.add(tabla), BorderLayout.CENTER);
		
	    JPanel Tablas = new JPanel();
	    Tablas.add(tablaresumen);
		Tablas.add(tablaTotal);
		add(Tablas , BorderLayout.SOUTH);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		VentanaPrincipal main= new VentanaPrincipal();
		main.setVisible(true);
		
		
	}
	
	public void cargarInfo() {
		try {
		tienda.separarCadenas(info.obtenerDatos());
		JOptionPane.showMessageDialog(null, "venta agregada ");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("error de ingreso, valores no tienen el formato requerido");
			JOptionPane.showMessageDialog(null, "valores no tienen el formato requerido ");
		}
		
	}
	
	public void buscar() {
		
		try {
		
		ArrayList<Producto> tempo= tienda.buscarPersona(Long.parseLong(texto.getTnumDoc()));
		tabla.llenarTabla(tempo);
		tablaresumen.llenarTabla(tempo);
		tablaTotal.llenarTabla(tempo);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("error de busqieda  valor no valido");
			JOptionPane.showMessageDialog(null, "ingrese un valor de documento valido ");
		}
	}
	
	public void generar() {
			/*System.out.println("factura");
			
			
			  int i = 15; 

		        // output 
		        System.out.println("A random string: " +  getRandomString(i)); 
		*/
	}
}
