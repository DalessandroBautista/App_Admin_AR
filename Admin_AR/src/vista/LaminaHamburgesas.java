package vista;

import java.awt.*;
import javax.swing.JPanel;

import controlador.*;

public class LaminaHamburgesas extends JPanel {
	ControladorCargaPrecios ob;
	public LaminaHamburgesas() {
		setLayout(new GridLayout(7,6));
		ob= new ControladorCargaPrecios(this);
		ob.aa("hamburgesas", "hamburgesa");
	}
}