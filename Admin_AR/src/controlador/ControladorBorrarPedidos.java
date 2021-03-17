package controlador;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class ControladorBorrarPedidos {
	BorrarPedidos borrar=new BorrarPedidos();
	public ControladorBorrarPedidos() {
		try {
				borrar.ejecutaBorrarPedidos();
		}catch(Exception ex){
			System.out.println("Error en  borrar todos los pedidos");
			ex.printStackTrace();
		}	
	}
}
