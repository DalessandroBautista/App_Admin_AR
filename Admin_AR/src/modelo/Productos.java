package modelo;

public class Productos {
	private String producto;
	private int precio;
	
	public Productos() {
		producto="";
		precio=0;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
