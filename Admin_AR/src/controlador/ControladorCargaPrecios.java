package controlador;

import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.*;


import javax.swing.JLabel;

import modelo.*;
import vista.*;

public class ControladorCargaPrecios  {

	CargaProducto producto=new CargaProducto();

	
	private LaminaHamburgesas laminaH;
	private LaminaExtras laminaE;
	
	
	
	public ControladorCargaPrecios(LaminaHamburgesas lamina) {
		laminaH=lamina;
	}
	public ControladorCargaPrecios(LaminaExtras lamina) {
		laminaE=lamina;
	}
	public void aa( String tabla, String columna) {
		
		
		
		try {
			producto.ejecutaConsultaProducto(tabla);
			if(tabla.equals("hamburgesas")) {
				while (producto.miResultset.next()){
					String nombreH=producto.miResultset.getString(columna);
					String precio=producto.miResultset.getString("precio");
	
					JLabel texto=new JLabel(nombreH + " $" + precio);
					laminaH.add(texto);

				}
			}else while (producto.miResultset.next()){
				String nombre=producto.miResultset.getString(columna);
				if(!nombre.equals("Sin Cebolla") && (!nombre.equals("Sin Cheddar") ) && (!nombre.equals("Sin Panceta") ) &&(!nombre.equals("Sin Huevo")) && (!nombre.equals("Sin Lechuga") ) && (!nombre.equals("Sin Tomate") )&&(!nombre.equals("Sin CebollaC")) && (!nombre.equals("Sin Azul") ) && (!nombre.equals("Sin Emmenthal") )) { 

					String precio=producto.miResultset.getString("precio");
	
					JLabel texto=new JLabel(nombre + " $" + precio);
					laminaE.add(texto);
				}
			}
	
			producto.miResultset.close();	

		}catch(Exception e2) {
			System.out.println("Error en ControladorCargaPrecios " +  e2.getMessage());
			e2.printStackTrace();
		}
	}
}

