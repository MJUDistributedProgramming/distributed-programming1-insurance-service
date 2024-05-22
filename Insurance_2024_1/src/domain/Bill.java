package domain;


/**
 * @author junkyulee
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public class Bill {
	
	private int billID;
	private String billReason;
	private int customerID;

	public Bill(){

	}

	public void finalize() throws Throwable {

	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
	}

	public String getBillReason() {
		return billReason;
	}

	public void setBillReason(String billReason) {
		this.billReason = billReason;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
}