package co.edu.uptc.modelo;

import java.util.ArrayList;

public class Producto {

	private String codigo;
	
	private String descripcion;
	
	private double cantidad;
	
	private double precioBase;
	
	private ImpuestoEnum impuesto;
	
	private double precioIVAincluido;
	
	
	
	private double totalBase;
	
	private double total;
	
	
	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalImpuesto() {
		return totalImpuesto;
	}

	public void setTotalImpuesto(double totalImpuesto) {
		this.totalImpuesto = totalImpuesto;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTotal() {
		return total;
	}




	private double totalImpuesto;
	private double subTotal;
	
	public double getTotalBase() {
		return totalBase;
	}

	public void setTotalBase(double totalBase) {
		this.totalBase = totalBase;
	}




	private double totalpre;

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the cantidad
	 */
	public double getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the precioBase
	 */
	public double getPrecioBase() {
		return precioBase;
	}

	/**
	 * @param precioBase the precioBase to set
	 */
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	/**
	 * @return the impuesto
	 */
	public ImpuestoEnum getImpuesto() {
		return impuesto;
	}

	/**
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(ImpuestoEnum impuesto) {
		this.impuesto = impuesto;
	}

	/**
	 * @return the precioIVAincluido
	 */
	public double getPrecioIVAincluido() {
		return precioIVAincluido;
	}

	/**
	 * @param precioIVAincluido the precioIVAincluido to set
	 */
	public void setPrecioIVAincluido(double precioIVAincluido) {
		this.precioIVAincluido = precioIVAincluido;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", cantidad=" + cantidad
				+ ", precioBase=" + precioBase + ", impuesto=" + impuesto + ", precioIVAincluido=" + precioIVAincluido
				+ "]";
	}

	public static Object getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	public double setTotalpre(double baseGrab) {
		// TODO Auto-generated method stub
		return totalpre;
	}


	

	
	
	
	
}
