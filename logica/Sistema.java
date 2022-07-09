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
	/**
	 * 
	 * @param user nombre de usuario
	 * @param pasword contraseña
	 * @return true si inicia sesión sin problemas
	 */
	public boolean login(String user, String pasword);
	/**
	 * 
	 * @param username
	 * @param name
	 * @param email
	 * @param contact
	 * @param password
	 * @return true si se registra sin problemas
	 * @throws IOException
	 */
	public boolean sigin(String username, String name, String email, String contact, String password) throws IOException;
	/**
	 * 
	 * @param username
	 * @return objeto del usuario
	 */
	public User getUserByName(String username);
	/**
	 * 
	 * @param id del producto
	 * @return objeto del producto
	 */
	public Product getProductById(int id);
	/**
	 * 
	 * @param name del producto
	 * @return objeto del producto
	 */
	public Product getProductByName(String name);
	/**
	 * añade producto a la tienda
	 * @param name
	 * @param category
	 * @param price
	 * @param description
	 * @param imagePath
	 * @param sellerUser
	 */
	public void addProductToShop(String name, String category, int price, String description, String imagePath, User sellerUser);
	public void editProduct(Product product);
	/**
	 * elimina el producto de la tienda
	 * @param product
	 */
	public void deleteProduct(Product product);
	public Object[][] getProductData(String filter);
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
