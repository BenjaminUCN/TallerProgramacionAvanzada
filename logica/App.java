package logica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utils.LoginWindow;
import utils.SellWindow;

public class App {
	
	public static Sistema sistema;
	
    public static void main(String[] args) throws FileNotFoundException {
    	Sistema sistema = new SistemaImpl();

		LoginWindow login = new LoginWindow(sistema);
    	//SellWindow sellWindow = new SellWindow(sistema);
	}

}
