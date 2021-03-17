package controlador;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class ControladorBorrarUltimoPedido {
	
	BorrarUltimoPedido borrar=new BorrarUltimoPedido();
	
	
	public ControladorBorrarUltimoPedido() {
			int valor= -1;
			borrar.ejecutaBorrarUltimoPedido();
			try {
				while (borrar.miResultset.next()){
					valor=Integer.parseInt(borrar.miResultset.getString("id"));

				}
				new UpdateBorrarUltimoPedido(valor);
				borrar.miResultset.close();
			}catch(Exception e) {
				System.out.println("Fallo Controlado Borrado " + e.getMessage());
			}
			
			

		}
}
