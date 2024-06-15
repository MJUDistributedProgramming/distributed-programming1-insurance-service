package domain;
public class Compensation {
	private int compensationID;
	private int contractID;
	private int customerID;
	private int insuranceAmount;
	private Bill Bill;
	private Loss Loss;
	public Compensation() {}
	public void finalize() throws Throwable {}
	// operate
	public void investigateLoss() {}
	public void calculateInsuranceAmount(){}
	public void giveInsuranceAmountToCustomer(){}
	public void requestInsuranceAmount(Bill bill, int customerID){}
	// get&set
	public int getCompensationID() { return compensationID; }
	public void setCompensationID(int compensationID) { this.compensationID = compensationID; }
	public int getContractID() { return contractID; }
	public void setContractID(int contractID) { this.contractID = contractID; }
	public int getCustomerID() { return customerID; }
	public void setCustomerID(int customerID) { this.customerID = customerID; }
	public Bill getBill() { return Bill; }
	public void setBill(Bill bill) { Bill = bill; }
	public Loss getLoss() { return Loss; }
	public void setLoss(Loss loss) { Loss = loss; }
	public int getInsuranceAmount() { return insuranceAmount; }
	public void setInsuranceAmount(int insuranceAmount) { this.insuranceAmount = insuranceAmount; }	
}