package utils;

import dominio.Product;
import dominio.User;
import logica.Sistema;

public class WindowManager {
	
    //private Window currentWindow;
	@SuppressWarnings("unused")
	private Object currentWindow;
	private String currentWindowName;
	private String prevWindowName;
	private User user;
	private Product product;
	
	
	Sistema sistema;
	
	public WindowManager(Sistema sistema) {
		this.sistema = sistema;
		
		currentWindowName = "login";
		currentWindow = new LoginWindow(sistema, this);
	}
	
	public void changeWindow(String windowName) {
		
		if(windowName.equals("back")) {
			windowName = prevWindowName;
		}
		//update window tracking
		prevWindowName = currentWindowName;
		currentWindowName = windowName;
		
		//System.out.println(prevWindowName);
		
		switch(windowName) {
			case "login":
				currentWindow = new LoginWindow(sistema, this);
				break;
			case "signin":
				currentWindow = new SigninWindow(sistema, this);
				break;
			case "perfil":
				currentWindow = new PerfilWindow(sistema, this,  user);
				break;
			case "sell":
				currentWindow = new SellWindow(sistema, this, user);
				break;
			case "info":
				currentWindow = new ProductInfoWindow(sistema, this, product);
				break;
			case "myPosts":
				currentWindow = new MyPostsWindow(sistema, this, user);
				break;
			case "myPurchases":
				currentWindow = new MyPurchasesWindow(sistema, this);
				break;
			default:
				break;
		}
		
	}
	
	public void setUser(User user) {
		this.user = user;
		System.out.println("nombre:"+user.getName());
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public Product getProduct() {
		return this.product;
	}
}
