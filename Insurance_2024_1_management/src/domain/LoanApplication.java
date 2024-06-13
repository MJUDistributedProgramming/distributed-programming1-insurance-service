package domain;


/**
 * @author Owner
 * @version 1.0
 * @created 13-6-2024 오후 1:59:29
 */
public class LoanApplication {

	private int customerID;
	private String loanAmount;
	private int loanApplicationID;
	private int loanID;
	private String loanPurpose;
	private String loanStatus;
	private String paymentCompanyName;

	public LoanApplication(){

	}

	public void finalize() throws Throwable {

	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getLoanApplicationID() {
		return loanApplicationID;
	}

	public void setLoanApplicationID(int loanApplicationID) {
		this.loanApplicationID = loanApplicationID;
	}

	public int getLoanID() {
		return loanID;
	}

	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getPaymentCompanyName() {
		return paymentCompanyName;
	}

	public void setPaymentCompanyName(String paymentCompanyName) {
		this.paymentCompanyName = paymentCompanyName;
	}

}