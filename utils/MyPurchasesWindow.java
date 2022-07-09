package utils;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import logica.Sistema;

public class MyPurchasesWindow {
	
	Sistema sistema;
	WindowManager windowManager;
	
	Object[][] data;
	
	protected JFrame frame;

	public MyPurchasesWindow(Sistema sistema, WindowManager windowManager) {
		this.sistema = sistema;
		this.windowManager = windowManager;
		
		frame = new JFrame("Ventas Coquimbo - Mis compras");
		frame.setSize(600, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);
		frame.setVisible(true);
		
		
	}
	
	protected void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		// texto: Lista de compras
		JLabel	titleLabel = new JLabel("Lista de compras");
		titleLabel.setBounds(30, 30, 160, 25);
		titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(titleLabel);
		
		// texto: cantidad de compras
		JLabel	purchaseCountLabel = new JLabel("cantidad de compras: " +windowManager.getUser().getPurchaseCount());
		purchaseCountLabel.setBounds(300, 30, 160, 25);
		purchaseCountLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.add(purchaseCountLabel);
		
		String[] columnNames = new String[] {"ID", "Usuario", "Nombre producto", "precio"};											
		data = windowManager.getUser().getUserPurchases();		
		
		JTable table = new JTable(data, columnNames);
		table.getTableHeader().setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setPreferredScrollableViewportSize(new Dimension(200,30));
		table.setFillsViewportHeight(true);
								
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		scrollPane.setBounds(25, 80, 493, 200);
		panel.add(scrollPane);
		
		// Botón: Volver
		JButton backBtn = new JButton("Volver");
		backBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		backBtn.setBounds(200, 327, 160, 25);
						
		backBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
								
					windowManager.changeWindow("perfil");
			}
		});
		panel.add(backBtn);
	}

}
