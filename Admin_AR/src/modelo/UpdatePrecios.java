package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdatePrecios {
	Statement  miStatement;
	Conexion miConexion;
	public ResultSet miResultset;
	PreparedStatement sentencia;
	public UpdatePrecios() {
		miConexion=new Conexion();
	}
	public void ejecutarActualizacionPreciosH(int precio,  String producto ){
		
		Connection accesoBD=miConexion.dameConexion();	
		try {

			
			
			PreparedStatement sentencia=accesoBD.prepareStatement("UPDATE hamburgesas SET precio=? WHERE hamburgesa = ?");
			//sentencia.setString(1, tabla);
			sentencia.setInt(1, precio);
			sentencia.setString(2, producto);
			System.out.println(sentencia);
			sentencia.executeUpdate();
			System.out.println("Update finalizada en UpdatePrecios");
		}catch(Exception e) {
			System.out.println("Fallo en UpdatePrecios con: hamburgesas  " + " " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	public void ejecutarActualizacionPreciosE(int precio, String producto ){
		
		Connection accesoBD=miConexion.dameConexion();	
		try {
		
			
			
			PreparedStatement sentencia=accesoBD.prepareStatement("UPDATE extras SET precio=? WHERE extra = ?");
			//sentencia.setString(1, tabla);
			sentencia.setInt(1, precio);
			sentencia.setString(2, producto);
			System.out.println(sentencia);
			sentencia.executeUpdate();
			accesoBD.close();
		}catch(Exception e) {
			System.out.println("Fallo en UpdatePrecios con: extras " + " " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
