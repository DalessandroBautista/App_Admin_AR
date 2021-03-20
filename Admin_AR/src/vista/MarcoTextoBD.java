package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;

import controlador.*;

	public class MarcoTextoBD extends JFrame{
		String ruta=new File("").getAbsolutePath();	
		public MarcoTextoBD() {
			setTitle("ARBurger's-BD");
			Toolkit miPantalla=Toolkit.getDefaultToolkit();
			Dimension tamanoPantalla=miPantalla.getScreenSize();
			int H=tamanoPantalla.height;
			int W=tamanoPantalla.width;
			setBounds(0,0,W-100,((H/3) + 50));
			Image icono=miPantalla.getImage(ruta + "/logo.JPG");
			setIconImage(icono);
			LaminaTextoBD lamina=new LaminaTextoBD();
			add(lamina);			
			setVisible(true);
		}
}
