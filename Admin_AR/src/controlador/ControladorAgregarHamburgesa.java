package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelo.Conexion;

public class ControladorAgregarHamburgesa {
	Conexion miConexion;
	public ResultSet miResultset;
	Statement  miStatement;
	
	public ControladorAgregarHamburgesa(String nombre, String precio) {
		miConexion=new Conexion();
		Connection accesoBD=miConexion.dameConexion();	
	
	
				try {
					PreparedStatement sentencia=accesoBD.prepareStatement("INSERT INTO hamburgesas (hamburgesa,precio) VALUES (?, ?)");
					sentencia.setString(1,nombre);
					sentencia.setString(2,precio);
					sentencia.executeUpdate();
					accesoBD.close();
				}catch(Exception ex){
					System.out.println("Fallo la conexion en Agregar hamburgesas");
					ex.printStackTrace();
				}
	}
}
