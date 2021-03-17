package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controlador.*;
import modelo.*;

public class LaminaTextoBD  extends JPanel{
	Statement  miStatement;
	
	JButton hamburgesas=new JButton("Actualizar valor hamburgesas");
	JButton totalCaja=new JButton("Caja");
	JButton extras=new JButton("Actualizar valor extras");
	JButton borrar=new JButton("Borrar todos los pedidos");
	JButton borrarPedido=new JButton("Borrar ultimo pedido");
	
	 

	public LaminaTextoBD() {
		setLayout(new FlowLayout());
		
		this.setBackground(Color.WHITE);		
		ActionListener oyente=new actualizarHamburgesas();
		ActionListener oyente2=new cerrarCaja();
		ActionListener oyente3=new actualizarExtras();
		ActionListener oyente4=new borrarPedidos();
		ActionListener oyente5=new borrarUltimoPedido();
		
		hamburgesas.addActionListener(oyente);
		totalCaja.addActionListener(oyente2);
		extras.addActionListener(oyente3);
		borrar.addActionListener(oyente4);
		borrarPedido.addActionListener(oyente5);
		
		add(hamburgesas, BorderLayout.NORTH);
		add(extras, BorderLayout.NORTH);
		add(totalCaja, BorderLayout.NORTH);
		add(borrar, BorderLayout.NORTH);
		add(borrarPedido, BorderLayout.NORTH);
		LaminaHamburgesas laminaHamburgesas=new LaminaHamburgesas();
		LaminaExtras laminaExtras=new LaminaExtras();
		add(laminaHamburgesas, BorderLayout.CENTER);
		add(laminaExtras, BorderLayout.SOUTH);

	
}
	private class actualizarHamburgesas implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			try {
				String n_hamburgesa=JOptionPane.showInputDialog(LaminaTextoBD.this, "Hamburgesa a actualizar", "Elegir hamburgesa", 1);
				n_hamburgesa=n_hamburgesa.toLowerCase();
				String Sprecio=JOptionPane.showInputDialog(LaminaTextoBD.this, n_hamburgesa, "Precio de", 1);
				int precio= Integer.parseInt(Sprecio);
				ControladorActualizarPrecios AP=new ControladorActualizarPrecios();
				AP.ActualizarPrecios(n_hamburgesa, "hamburgesas", precio, "hamburgesa");

			}catch(Exception ex){
				System.out.println("Error en  actualizar Hamburgesas");

				ex.printStackTrace();
			}
			new MarcoBD();
			Window w = SwingUtilities.getWindowAncestor(LaminaTextoBD.this);
		     w.setVisible(false);
		
			}
		}
	
	private class actualizarExtras implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			try {
				String n_extra=JOptionPane.showInputDialog(LaminaTextoBD.this, "Extra a actualizar", "Elegir Extra", 1);
				n_extra=n_extra.toLowerCase();
				String Sprecio=JOptionPane.showInputDialog(LaminaTextoBD.this, n_extra, "Precio de", 1);
				int precio= Integer.parseInt(Sprecio);
				ControladorActualizarPrecios AP=new ControladorActualizarPrecios();
				AP.ActualizarPrecios(n_extra, "extras", precio, "extra");

			}catch(Exception ex){
				System.out.println("Error en  actualizar extras");

				ex.printStackTrace();
			}
			new MarcoBD();
			Window w = SwingUtilities.getWindowAncestor(LaminaTextoBD.this);
		     w.setVisible(false);
		
			}
		}
	private class cerrarCaja implements ActionListener{
		int total=0;
		int envio=0;
		public void actionPerformed(ActionEvent e) {
			ControladorCerrarCaja x=new ControladorCerrarCaja();
			String a=x.Cerrar_caja();
			JOptionPane.showMessageDialog(LaminaTextoBD.this,a);
		}
	}
	private class borrarPedidos implements ActionListener{

		public void actionPerformed(ActionEvent e) {
				new ControladorBorrarPedidos();
				JOptionPane.showMessageDialog(LaminaTextoBD.this,"Todos los pedidos fueron borrados exitosamente");

		}

	}
	private class borrarUltimoPedido implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			new ControladorBorrarUltimoPedido();
			JOptionPane.showMessageDialog(LaminaTextoBD.this,"El ultimo pedido fue borrado exitosamente");
		}	
	}
}
