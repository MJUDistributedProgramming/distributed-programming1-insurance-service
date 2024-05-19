package domain;


/**
 * @author Win10
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
public class HouseFire extends Insurance {

	private String categoryOfHouse;
	private int priceOfHouse;

	public HouseFire(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public String getCategoryOfHouse() {
		return categoryOfHouse;
	}

	public void setCategoryOfHouse(String categoryOfHouse) {
		this.categoryOfHouse = categoryOfHouse;
	}

	public int getPriceOfHouse() {
		return priceOfHouse;
	}

	public void setPriceOfHouse(int priceOfHouse) {
		this.priceOfHouse = priceOfHouse;
	}

}