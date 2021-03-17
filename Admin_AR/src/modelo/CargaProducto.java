package modelo;


import java.awt.*;

import java.sql.*;

import javax.swing.*;


public class CargaProducto  extends JPanel {
	Statement  miStatement;
	Conexion miConexion;
	Productos miProducto;
	public ResultSet miResultset;
	public CargaProducto(){
		miConexion=new Conexion();

	}
	public void ejecutaConsultaProducto(String tabla) {
		Connection accesoBD=miConexion.dameConexion();

		try {
			String x= "SELECT * FROM " + tabla;
			Statement miStatement=accesoBD.createStatement();
			miResultset=miStatement.executeQuery(x);
			
		}catch(Exception ex){
			System.out.println("Fallo la conexion en CargaProductos " + tabla + " " + ex.getCause());
			ex.printStackTrace();
		}
	}
}

	

