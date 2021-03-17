package controlador;

import vista.*;

import java.sql.ResultSet;

import modelo.*;

public class ControladorCerrarCaja {
	CerrarCaja caja=new CerrarCaja();
	
	public ControladorCerrarCaja() {
		
	
	}
	
	public String Cerrar_caja() {
		caja.ejecutaCierreCaja();
		int total=0;
		int envio=0;
		String x = "Fallo el calculo";
		try {
			
			while (caja.miResultset.next()){
				total+=Integer.parseInt(caja.miResultset.getString("total"));
				 envio+=Integer.parseInt(caja.miResultset.getString("envio"));
			}
			 x= "El total es: $" + total + " " + "y el total en envios es: $"+ envio;	
			 caja.miResultset.close();
		}catch(Exception ex){
			System.out.println("Error en  cerrar caja");
			ex.printStackTrace();
		}
		return x;
	}
}
