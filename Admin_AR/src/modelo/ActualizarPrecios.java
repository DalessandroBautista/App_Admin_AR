package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ActualizarPrecios {
	Statement  miStatement;
	Conexion miConexion;
	public ResultSet miResultset;
	public ActualizarPrecios() {
			miConexion=new Conexion();
			
		
	}
	public void ejecutarActualizacionPrecios(String tabla) {
		
		Connection accesoBD=miConexion.dameConexion();
		
		try {
			String tabla2=tabla.toLowerCase();
			System.out.println(tabla2);
			String x= "SELECT * FROM " + tabla2;
			PreparedStatement sentencia=accesoBD.prepareStatement(x);
			miResultset=sentencia.executeQuery();
		}catch(Exception ex){
			System.out.println("Fallo la conexion en ActualizarPrecios");
			ex.printStackTrace();
		}
	}
}
