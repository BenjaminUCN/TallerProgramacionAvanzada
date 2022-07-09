package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import dominio.Product;
import dominio.User;

public interface Sistema {
	
	public void readUserRegistry(ArrayList<User> users) throws FileNotFoundException;
	//lectura de archivo
	public boolean login(String user, String pasword);
	public boolean sigin(String username, String name, String email, String contact, String password) throws IOException;
	public User getUserByName(String username);
	public Product getProductById(int id);
	public Product getProductByName(String name);
	public void addProductToShop(String name, String category, int price, String description, String imagePath, User sellerUser);
	public void editProduct(Product product);
	public void deleteProduct(Product product);
	public Object[][] getProductData(String filter);
	public Object[][] getUserPosts(User user);
	/**
	 * escala la imagen, solo funciona con labels cuadrados por ahora
	 * @param path directorio de la imagen 
	 * @param width ancho del label
	 * @param height alto del label
	 * @return imagen (ImageIcon) escalada para el label
	 */
	public ImageIcon scaleImage(String path, int width, int height);
	
	public void saveChanges(ArrayList<User> users) throws IOException;
	//guarda los cambios al txt
	
}
