package domain;

public class SpecialProvision {

	private String description;
	private double rateOfDiscount;
	private String specialProvisionName;

	public SpecialProvision(){

	}

	public void finalize() throws Throwable {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRateOfDiscount() {
		return rateOfDiscount;
	}

	public void setRateOfDiscount(double rateOfDiscount) {
		this.rateOfDiscount = rateOfDiscount;
	}

	public String getSpecialProvisionName() {
		return specialProvisionName;
	}

	public void setSpecialProvisionName(String specialProvisionName) {
		this.specialProvisionName = specialProvisionName;
	}

}