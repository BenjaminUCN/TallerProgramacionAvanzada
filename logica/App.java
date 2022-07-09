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
import utils.MyPurchasesWindow;
import utils.SellWindow;
import utils.WindowManager;

/*Intregantes:
 * Ethan Astorga
 * Mauricio Díaz
 * Benjamín Donoso 
 * */


public class App {
	
	public static Sistema sistema;
	
    public static void main(String[] args) throws FileNotFoundException {
    	Sistema sistema = new SistemaImpl();
    	WindowManager windowManager = new WindowManager(sistema);
    	
		//LoginWindow login = new LoginWindow(sistema);
		
    	

    	//SellWindow sellWindow = new SellWindow(sistema);
	}

}
