package utils;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window {
	
	protected JFrame frame;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public Window(String name,int width,int height) {
		frame = new JFrame("Ventas Coquimbo - "+name);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		
		frame.setVisible(true);
	}

	protected void placeComponents(JPanel panel) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	protected JTextField CreateInput(String labelText, JPanel panel, int x,int y) {
		// texto
		JLabel label = new JLabel(labelText);
		label.setBounds(x, y, 160, 25);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(label);
						
		// entrada de texto
		JTextField textField = new JTextField(20);
		textField.setBounds(x,y+25,160,25);
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(textField);
		
		return textField;
	}
}
