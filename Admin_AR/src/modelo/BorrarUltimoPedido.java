package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BorrarUltimoPedido {
	Statement  miStatement;
	Conexion miConexion;
	public ResultSet miResultset;
	PreparedStatement sentencia;
	public BorrarUltimoPedido() {
			miConexion=new Conexion();
			
		
	}
	public void ejecutaBorrarUltimoPedido() {
		
		Connection accesoBD=miConexion.dameConexion();

		try {
			Statement miStatement=accesoBD.createStatement();
			miResultset=miStatement.executeQuery("SELECT * FROM pedido");
			
		}catch(Exception ex){
			System.out.println("Fallo la conexion en Actualizar Extras");
			ex.printStackTrace();
		}
	}
}

