package utils;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dominio.Product;
import dominio.User;
import logica.Sistema;

public class MyPostsWindow {

	Sistema sistema;
	User user;
	
	JFrame frame;
	Object[][] data;
	
	public MyPostsWindow(Sistema sistema, User user) {
		this.sistema = sistema;
		this.user = user;
		
		frame = new JFrame("Ventas Coquimbo - ");
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);
		frame.setVisible(true);
	
	}
	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JLabel userLabel = new JLabel(user.getName());
		userLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		userLabel.setBounds(400, 15, 130, 25);
		panel.add(userLabel);
		
		JLabel postLabel = new JLabel("Publicaciones:");
		postLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		postLabel.setBounds(200, 55, 130, 25);
		panel.add(postLabel);
		
		String[] columnNames = new String[] {"ID", "Nombre", "Categoria", "Fecha", "Vendidas S_N"};											
		data = sistema.getUserPosts(user);		
		
		JTable table = new JTable(data, columnNames);
		table.getTableHeader().setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setPreferredScrollableViewportSize(new Dimension(200,30));
		table.setFillsViewportHeight(true);
								
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		scrollPane.setBounds(25, 80, 493, 200);
		panel.add(scrollPane);
		
		JButton editBtn = new JButton("Editar producto");
		editBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		JButton eraseBtn = new JButton("Borrar producto");
		eraseBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		editBtn.setBounds(26, 327, 160, 25);
		eraseBtn.setBounds(400, 327, 130, 25);
		
		panel.add(editBtn);
		panel.add(eraseBtn);
	}
}
