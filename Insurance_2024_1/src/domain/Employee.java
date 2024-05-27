package domain;
import IF.ContractList;
import IF.RuleList;
import IF.CounselList;
import IF.InsuranceList;
import IF.PaymentList;

public class Employee {
	private String email;
	private int employeeID;
	private String employeePW;
	private String gender;
	private String name;
	private String phone;
	private String type;


	public RuleList ruleListImpl;
	public InsuranceList insuranceListImpl;
	public ContractList contractListImpl;
	public Compensation m_Compensation;
	public CounselList counselListImpl;
	public PaymentList paymentListImpl;
	//
	public Employee(){

	}

	public void finalize() throws Throwable {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeePW() {
		return employeePW;
	}

	public void setEmployeePW(String employeePW) {
		this.employeePW = employeePW;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public InsuranceList getInsuranceList() {
		return insuranceListImpl;
	}

	public void setInsuranceList(InsuranceList insuranceListImpl) {
		this.insuranceListImpl = insuranceListImpl;
	}

	public Compensation getM_Compensation() {
		return m_Compensation;
	}

	public void setM_Compensation(Compensation m_Compensation) {
		this.m_Compensation = m_Compensation;
	}

	public CounselList getCounselList() {
		return counselListImpl;
	}

	public void setCounselList(CounselList counselListImpl) {
		this.counselListImpl = counselListImpl;
	}
	
	public ContractList getContractList() {
		return contractListImpl;
	}

	public void setContractList(ContractList contractListImpl) {
		this.contractListImpl = contractListImpl;
	}

	public boolean createContract(Contract contract) {
		return contractListImpl.add(contract);
	}

	public boolean deleteContract(int contractID) {
		return contractListImpl.deleteById(contractID);
	}

	public void setRuleList(RuleList ruleListImpl) {
		this.ruleListImpl = ruleListImpl;
	}
	
	public RuleList getRuleList() {
		return ruleListImpl;
	}
	
	public boolean createRule(Rule rule) {
		return this.ruleListImpl.add(rule);
	}

	public boolean deleteRule(int ruleID) {
		return this.ruleListImpl.deleteById(ruleID);

	public boolean createInsurance(Insurance insurance) {
		return this.insuranceListImpl.add(insurance);
	}

	public boolean deleteInsurance(int insuranceID) {
		return this.insuranceListImpl.delete(insuranceID);
	}

	public boolean createPayment(Payment payment) {
		return this.paymentListImpl.add(payment);
	}

	public boolean deletePayment(int paymentID) {
		return this.paymentListImpl.delete(paymentID);
	}

	public void setPaymentList(PaymentList paymentListImpl) {
		this.paymentListImpl = paymentListImpl;

	}
}