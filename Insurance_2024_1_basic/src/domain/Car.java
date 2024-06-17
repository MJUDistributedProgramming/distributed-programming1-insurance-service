package domain;
public class Car extends Insurance {
	private String model;
	private int priceOfCar;
	
	public Car(){
	}
	public void finalize() throws Throwable {
		super.finalize();
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPriceOfCar() {
		return priceOfCar;
	}
	public void setPriceOfCar(int priceOfCar) {
		this.priceOfCar = priceOfCar;
	}
}