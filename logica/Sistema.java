package logica;

import javax.swing.ImageIcon;

import dominio.Product;
import dominio.User;

public interface Sistema {

	public boolean login(String user, String pasword);
	public boolean sigin(String username, String name, String email, String contact, String password);
	public User getUserByName(String username);
	public Product getProductById(int id);
	public void addProductToShop(String name, String category, int price, String description, String imagePath, User sellerUser);
	public Object[][] getProductData(String filter);
	
	/**
	 * escala la imagen, solo funciona con labels cuadrados por ahora
	 * @param path directorio de la imagen 
	 * @param width ancho del label
	 * @param height alto del label
	 * @return imagen (ImageIcon) escalada para el label
	 */
	public ImageIcon scaleImage(String path, int width, int height);
}
