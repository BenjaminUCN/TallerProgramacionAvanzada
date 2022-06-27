package dominio;

import java.util.Date;

public class Product {
	private int id;
	private String name;
	private String category;
	private int price;
	private String description;
	private String imagePath;
	private String date;
	
	private String seen;
	
	//Usuario
	private User sellerUser;
	
	public Product(int id, String name, String category, int price, String description, String imagePath, User sellerUser) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
		this.imagePath = imagePath;
		this.sellerUser = sellerUser;
		
		Date currentDate = new Date();
    	String strDate = currentDate.getDate()+"/"+(currentDate.getMonth()+1)+"/"+(currentDate.getYear()+1900);
    	this.date = strDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String[] getData() {
		String[] data = {String.valueOf(id), name, category, date, seen};
		return data;
	}
	
}
