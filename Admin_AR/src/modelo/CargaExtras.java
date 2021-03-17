package modelo;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CargaExtras extends  JPanel {
	Statement  miStatement;
	Conexion miConexion;
	public ResultSet miResultset;
	public CargaExtras() {
			miConexion=new Conexion();
			
		
	}
	public void ejecutaConsultaExtras() {
		
		Connection accesoBD=miConexion.dameConexion();
		
		try {
			Statement miStatement=accesoBD.createStatement();
			miResultset=miStatement.executeQuery("SELECT * FROM EXTRAS");
		}catch(Exception ex){
			System.out.println("Fallo la conexion en CargaExtras");
			ex.printStackTrace();
		}
	}
}

