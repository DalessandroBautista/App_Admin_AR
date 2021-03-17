package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CerrarCaja {
	Statement  miStatement;
	Conexion miConexion;
	public ResultSet miResultset;
	public CerrarCaja() {
			miConexion=new Conexion();
			
		
	}
	public void ejecutaCierreCaja() {
		
		Connection accesoBD=miConexion.dameConexion();
		
		try {
			Statement miStatement=accesoBD.createStatement();
			miResultset=miStatement.executeQuery("SELECT * FROM pedido");
		}catch(Exception ex){
			System.out.println("Fallo la conexion en CerrarCaja");
			ex.printStackTrace();
		}
	}
}
