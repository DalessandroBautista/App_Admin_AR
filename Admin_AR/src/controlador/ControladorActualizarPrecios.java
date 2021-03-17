package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class ControladorActualizarPrecios {
	ActualizarPrecios precios=new ActualizarPrecios();
	UpdatePrecios update=new UpdatePrecios();
	public ControladorActualizarPrecios() {
		
	}
	public void ActualizarPrecios(String producto, String tabla, int precio, String columna)  {
			
		try {
			precios.ejecutarActualizacionPrecios(tabla.toUpperCase());
			while (precios.miResultset.next()){
				String nombre=precios.miResultset.getString(columna);
				String nombre2=nombre.toLowerCase();
				if( producto.equals(nombre2)) {
					if(tabla.equals("hamburgesas")) {
					update.ejecutarActualizacionPreciosH( precio, nombre);
					System.out.println("Update hecha");
					
				}else update.ejecutarActualizacionPreciosE( precio, nombre);
				}

			}
			precios.miResultset.close();
			
		}catch(Exception ex){
			System.out.println("Error en  ControladorActualizarPrecios con: " + tabla);
			ex.getMessage();

			ex.printStackTrace();
		}
		
	}
	
	
}
