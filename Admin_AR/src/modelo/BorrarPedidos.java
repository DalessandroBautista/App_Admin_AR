package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BorrarPedidos {
	Statement  miStatement;
	Conexion miConexion;
	public ResultSet miResultset;
	PreparedStatement sentencia;
	public 	BorrarPedidos(){
			miConexion=new Conexion();
			
		
	}
	public void ejecutaBorrarPedidos() {
		
		Connection accesoBD=miConexion.dameConexion();
		
		try {
			miStatement=accesoBD.createStatement();
			miStatement.execute("TRUNCATE TABLE pedido");
			accesoBD.close();
		}catch(Exception ex){
			System.out.println("Fallo la conexion en Actualizar Extras");
			ex.printStackTrace();
		}
	}
}
