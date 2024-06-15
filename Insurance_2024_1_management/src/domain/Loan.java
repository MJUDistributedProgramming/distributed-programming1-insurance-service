package domain;
public class Loan {
	private int loanID;
	private int employeeID;
	private String charge;
	private String interestRate;
	private String loanName;
	private String loanTerm;
	private String qualification;
	private String repaymentMethod;
	public Loan() {}
	public void finalize() throws Throwable {}
	// set & get
	public int getLoanID() {return loanID;}
	public void setLoanID(int loanID) {this.loanID = loanID;}
	public int getEmployeeID() {return employeeID;}
	public void setEmployeeID(int employeeID) {this.employeeID = employeeID;}
	public String getCharge() {return charge;}
	public void setCharge(String charge) {this.charge = charge;}
	public String getInterestRate() {return interestRate;}
	public void setInterestRate(String interestRate) {this.interestRate = interestRate;}
	public String getLoanName() {return loanName;}
	public void setLoanName(String loanName) {this.loanName = loanName;}
	public String getLoanTerm() {return loanTerm;}
	public void setLoanTerm(String loanTerm) {this.loanTerm = loanTerm;}
	public String getQualification() {return qualification;}
	public void setQualification(String qualification) {this.qualification = qualification;}
	public String getRepaymentMethod() {return repaymentMethod;}
	public void setRepaymentMethod(String repaymentMethod) {this.repaymentMethod = repaymentMethod;}
}