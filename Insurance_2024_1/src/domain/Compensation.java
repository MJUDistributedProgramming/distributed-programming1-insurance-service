package domain;


/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public class Compensation {

	private Bill Bill;
	private int compensationID;
	private int contractID;
	private int customerID;
	private int insuranceAmount;
	private Loss Loss;
	public Loss m_Loss;
	public Bill m_Bill;

	public Compensation(){

	}

	public void finalize() throws Throwable {

	}

	public void calculateInsuranceAmount(){

	}

	public void giveInsuranceAmountToCustomer(){

	}

	/**
	 * 
	 * @param bill
	 * @param customerID
	 */
	public void requestInsuranceAmount(Bill bill, int customerID){

	}

}