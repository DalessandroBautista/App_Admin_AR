package vista;

import java.awt.*;
import javax.swing.JPanel;

import controlador.ControladorCargaPrecios;

public class LaminaExtras extends JPanel {
	ControladorCargaPrecios ob;
	public LaminaExtras() {
		setLayout(new GridLayout(7,6));
		this.setBackground(Color.GRAY);
		ob= new ControladorCargaPrecios(this);
		ob.aa("extras", "extra");
	}
}

