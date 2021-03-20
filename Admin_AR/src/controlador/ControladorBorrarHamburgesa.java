package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelo.Conexion;

public class ControladorBorrarHamburgesa {
	Conexion miConexion;
	public ResultSet miResultset;
	Statement  miStatement;
	
	public ControladorBorrarHamburgesa(String nombre) {
		miConexion=new Conexion();
		Connection accesoBD=miConexion.dameConexion();	
	
	
				try {
					PreparedStatement sentencia=accesoBD.prepareStatement("DELETE FROM hamburgesas WHERE hamburgesa=?");;
					sentencia.setString(1,nombre);
					sentencia.executeUpdate();
					accesoBD.close();
				}catch(Exception ex){
					System.out.println("Fallo la conexion en borrar hamburgesas");
					ex.printStackTrace();
				}
	}
}
