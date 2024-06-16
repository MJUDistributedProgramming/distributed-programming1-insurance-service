package domain;
public class Car extends Insurance {
	private boolean hasBlackbox;
	private String model;
	private int priceOfCar;
	private String VIN;
	public Car(){
	}
	public void finalize() throws Throwable {
		super.finalize();
	}

	public String hasBlackbox() {
		if(getHasBlackbokx()) return "보유";
		else return "미보유";
	}
	public boolean getHasBlackbokx() {return hasBlackbox;}

	public void setHasBlackbox(boolean hasBlackbox) {
		this.hasBlackbox = hasBlackbox;
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
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
}