package utils;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logica.Sistema;

public class MyProductsWindow {
	
	Sistema sistema;
	
	protected JFrame frame;

	public MyProductsWindow(Sistema sistema, String name,int width,int height) {
		frame = new JFrame("Ventas Coquimbo - "+name);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		
		
	}
	
	public void ShowWindow() {
		frame.setVisible(true);
	}
	
	public void CloseWindow() {
		frame.dispose();
		System.out.println("c");
	}
	
	protected void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		// texto: Nombre producto
		JLabel productNameLabel = new JLabel("Nombre");
		productNameLabel.setBounds(10, 10, 160, 25);
		productNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(productNameLabel);
	}

}
