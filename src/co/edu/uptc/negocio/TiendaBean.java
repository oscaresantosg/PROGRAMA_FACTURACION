package co.edu.uptc.negocio;

import java.nio.charset.Charset;
import java.util.ArrayList;
import static co.edu.uptc.modelo.ImpuestoEnum._19;
import java.util.InputMismatchException;
import java.util.Random;

import javax.swing.JOptionPane;

import co.edu.uptc.modelo.Cliente;
import co.edu.uptc.modelo.Factura;
import co.edu.uptc.modelo.ImpuestoEnum;
import co.edu.uptc.modelo.Producto;
import co.edu.uptc.modelo.Tienda;

public class TiendaBean {

	private Tienda tienda;

	public TiendaBean() {
		tienda = new Tienda();
	}

	public void separarCadenas(String cadena) {
		// Implementar la logica para separar la cadena
		String[] parts = cadena.split("\\n");
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		for (int i = 0; i < parts.length; i++) {
			String temporal[] = parts[i].split("\\|");
			Cliente cliente = new Cliente();
			// desarrollar logica para tipo de documento
			// cliente.setTipoDocumento(temporal[0].trim()); hay que cambiar el tipo de doc
			cliente.setNumDocumento(Long.parseLong(temporal[1].trim()));
			ArrayList<Factura> facturas = new ArrayList<Factura>();
			// desarrollo de logica para multiples productos
			Factura nuevaFactura = new Factura();
			ArrayList<Producto> productos = new ArrayList<Producto>();
			Producto producto = new Producto();
			producto.setCodigo(temporal[2].trim());
			producto.setDescripcion(temporal[3].trim());
			producto.setCantidad(Double.parseDouble(temporal[4].trim()));
			
			producto.setPrecioBase(Double.parseDouble(temporal[5].trim()));
			producto.setPrecioIVAincluido(Double.parseDouble(temporal[6].trim()));
			
			double CalcularBaseGravable = CalcularBaseGravable(producto.getPrecioBase(),producto.getPrecioIVAincluido(),producto.getCantidad());
			double totalImpuesto= totalImpuesto(producto.getPrecioBase(),producto.getCantidad(),producto.getPrecioIVAincluido(),producto.getTotalBase());
			double calcularTotal= calcularTotal(producto.getPrecioBase(),producto.getCantidad(),producto.getPrecioIVAincluido());
			
			double subtotal= subtotal(producto.getPrecioBase(),producto.getCantidad());
			
			
			producto.setTotalBase(CalcularBaseGravable);
			producto.setSubTotal(subtotal);
			producto.setTotalImpuesto(totalImpuesto);
			producto.setTotal(calcularTotal);
			
			productos.add(producto);
			
			nuevaFactura.setProductos(productos);
			facturas.add(nuevaFactura);
			
			cliente.setFacturas(facturas);
			clientes.add(cliente);
			System.out.println("venta agregada");
			//System.out.println("este es el precio de los productos de esa compra: $ "+ precioVenta);
			System.out.println("estas son las facturas" + facturas);
			System.out.println("estos son los clientes: " + cliente);
			//System.out.println("este es el valor del iva de la compra"+ precioVenta * producto.getImpuesto());
		}
		cargarTienda(clientes);

	}
	
	public double IvA(double iba) {
		if (iba == 19) {
			double IvA19 = 19;
		}else if (iba==8) {
			double IvA8= 8;
		}else if (iba == 5) {
			double IvA5=5;
		
			
		}
		return iba;
		
	}
	public double totalImpuesto(double PrecioBase, double Cantidad, double Iva, double TotalBase) {
		double TotalImpuesto;
		TotalImpuesto= ((PrecioBase*Cantidad)*Iva/100);
		return TotalImpuesto;
	}
	
	public double CalcularBaseGravable(double PrecioBase, double Cantidad, double Iva) {
		
		double TotalBase;
		TotalBase= (PrecioBase* Iva/100);
		return TotalBase;
		
	}
	
	
	
	public double calcularTotal(double PrecioBase,double Cantidad, double Iva){
		double Total;
		Total= (PrecioBase*Cantidad)*(1+(Iva/100));
		return Total;
	}
	
	public double subtotal(double PrecioBase, double Cantidad) {
		double Subtotal;
		Subtotal=(PrecioBase*Cantidad);
		return Subtotal;
		
	}
	
	public void calcularFactura() {
		
		
		
	}
	
	
	    public String getRandomString(int i) 
	    { 
	    
	        // bind the length 
	        byte[] bytearray = new byte[256];      
	        String mystring;
	        StringBuffer thebuffer;
	        String theAlphaNumericS;

	        new Random().nextBytes(bytearray); 

	        mystring 
	            = new String(bytearray, Charset.forName("UTF-8")); 
	            
	        thebuffer = new StringBuffer();
	        
	        //remove all spacial char 
	        theAlphaNumericS 
	            = mystring 
	                .replaceAll("[^A-Z0-9]", ""); 

	        //random selection
	        for (int m = 0; m < theAlphaNumericS.length(); m++) { 

	            if (Character.isLetter(theAlphaNumericS.charAt(m)) 
	                    && (i > 0) 
	                || Character.isDigit(theAlphaNumericS.charAt(m)) 
	                    && (i > 0)) { 

	                thebuffer.append(theAlphaNumericS.charAt(m)); 
	                i--; 
	            } 
	        } 

	        // the resulting string 
	        return thebuffer.toString(); 
	        
	      
	    } 

	

	public void cargarTienda(ArrayList<Cliente> clientes) {
		tienda.setNombre("TIENDITA DE BARRIO");
		tienda.setClientes(clientes);
		
		// System.out.println(tienda);
	}

	public ArrayList<Producto> buscarPersona(long numero) {

		try {

			ArrayList<Cliente> temporal = tienda.getClientes();
			for (Cliente cliente : temporal) {
				if (cliente.getNumDocumento() == numero) {

					JOptionPane.showMessageDialog(null, "cliente encontrado! NUmero doc: " + numero);
					System.out.println("persona buscada! NUmero doc: " + numero);
					System.out.println("costo del impuesto: " + cliente.getTipoDocumento());
					return cliente.getFacturas().get(0).getProductos();

				}
			}
		} catch (NullPointerException e) {
			System.out.println("NullPointerException thrown!");
			JOptionPane.showMessageDialog(null, "ingrese un valor valido");
		}
		return null;

		// else {JOptionPane.showMessageDialog(null, "ingrese un valor valido");
		// break;

	}
	
	public double calcularPrecioVenta(double precioBase, double cantidad ) {
		double precioVentatot;
		precioVentatot = precioBase * cantidad;
		return precioVentatot;
}
}
