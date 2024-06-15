package domain;
import java.util.ArrayList;
import IF.LoanApplicationList;
import exception.DuplicateIDException;
public class Customer {
	private int customerID;
	private String customerPW;
	private String address;
	private String asset;
	private String credit;
	private String income;
	private String job;
	private String liabilities;
	private String name;
	private String phone;
	private String ssn;
	private ArrayList<LoanApplication> loans;
	private LoanApplicationList loanApplicationListImpl;
	public Customer() {loans = new ArrayList<>();}
	public void finalize() throws Throwable {}
	public String loanApplication(LoanApplication loanApplication) throws DuplicateIDException {return loanApplicationListImpl.add(loanApplication);}
	public void setLoanApplicationList(LoanApplicationList loanApplicationListImpl) {this.loanApplicationListImpl = loanApplicationListImpl;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getAsset() {return asset;}
	public void setAsset(String asset) {this.asset = asset;}
	public String getCredit() {return credit;}
	public void setCredit(String credit) {this.credit = credit;}
	public int getCustomerID() {return customerID;}
	public void setCustomerID(int customerID) {this.customerID = customerID;}
	public String getIncome() {return income;}
	public void setIncome(String income) {this.income = income;}
	public String getJob() {return job;}
	public void setJob(String job) {this.job = job;}
	public String getLiabilities() {return liabilities;}
	public void setLiabilities(String liabilities) {this.liabilities = liabilities;}
	public ArrayList<LoanApplication> getLoans() {return loans;}
	public void setLoans(ArrayList<LoanApplication> loans) {this.loans = loans;}
	public String getName() {return name;}
	public String getCustomerPW() {return customerPW;}
	public void setCustomerPW(String customerPW) {this.customerPW = customerPW;}
	public void setName(String name) {this.name = name;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getSsn() {return ssn;}
	public void setSsn(String ssn) {this.ssn = ssn;}
}