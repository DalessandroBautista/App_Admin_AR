package modelo;

import java.sql.*;

public class UpdateBorrarUltimoPedido {
	Statement  miStatement;
	Conexion miConexion;
	public ResultSet miResultset;
	PreparedStatement sentencia;
	public UpdateBorrarUltimoPedido(int valor){
		miConexion=new Conexion();
		Connection accesoBD=miConexion.dameConexion();	
		try {
			PreparedStatement sentencia=accesoBD.prepareStatement("DELETE FROM pedido WHERE id=?");
			sentencia.setInt(1, valor);
			sentencia.executeUpdate();	
			accesoBD.close();
		}catch(Exception e) {
			System.out.println("Fallo update borrado" + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
