package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import IF.CompensationList;
import IF.ContractList;
import IF.RuleList;
import constant.Constant;
import daoList.CustomerListImpl;
import IF.CounselList;
import IF.CustomerList;
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
	// List
	public RuleList ruleListImpl;
	public InsuranceList insuranceListImpl;
	public ContractList contractListImpl;
	public CustomerList customerList;
	public CompensationList compensationListImpl;
	public CounselList counselListImpl;
	public PaymentList paymentListImpl;
	// 
	public Employee(){}
	public void finalize() throws Throwable {}
	// operate
	public boolean createContract(Contract contract) {return contractListImpl.add(contract);}
	public boolean deleteContract(int contractID) {return contractListImpl.deleteById(contractID);}
	public boolean createRule(Rule rule) {return this.ruleListImpl.add(rule);}
	public boolean deleteRule(int ruleID) {return this.ruleListImpl.deleteById(ruleID);}
	public boolean createInsurance(Insurance insurance) {return this.insuranceListImpl.add(insurance);}
	public boolean deleteInsurance(int insuranceID) {return this.insuranceListImpl.delete(insuranceID);}
	public boolean createPayment(Payment payment) {return this.paymentListImpl.add(payment);}
	public boolean deletePayment(int paymentID) {return this.paymentListImpl.delete(paymentID);}
	public boolean createCompensation(Compensation compensation) {return this.compensationListImpl.add(compensation);}
	public boolean deleteCompensation(int compensationID) {return this.compensationListImpl.deleteById(compensationID);}
	public boolean processUnderwriting(Contract contract, String evaluation, String result) {
		contract.setEvaluation(evaluation);
		if (result.equals("Y")) {
			contract.setContractStatus(Constant.contractStatus3);
			contract.setUnderwritingEID(this.employeeID);
			contract.setPassUW(true);
			return true;
		} else contract.setContractStatus(Constant.contractStatus2);
		return false;
	}
	public boolean permitContract(Contract contract, String result) {
		if (result.equals("Y")) {
			contract.setContractStatus(Constant.contractStatus4);
			return true;
		}
		return false;
	}
	public boolean concludeContract(Contract contract, String result) {
		if (result.equals("Y")) {
			contract.setContractStatus(Constant.contractStatus5);
			contract.setConcludeEID(this.employeeID);
			contract.setConcludedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			contract.setConclude(true);
			return true;
		}
		return false;
	}
	public boolean requestReUnderwriting(Contract contract) {
		contract.setContractStatus(Constant.contractStatus1);
		return true;
	}
	public boolean createCustomer(Customer customer, String result) {
		if (result.equals("Y")) {
			return this.customerList.add(customer);
		}
		return false;
	}
	public boolean deleteCustomer(int customerID) {
		return this.customerList.deleteById(customerID);
	}
	public boolean updateCustomer(String customerID, String name, String account, String address, String age,
			String birthDate, String email, String gender, String height, String job, String phone, String weight,
			MedicalHistory medicalHistory) {
		Customer customer = customerList.retrieveById(Integer.parseInt(customerID));
		if (customer == null) return false;
		customer.setName(name);
		customer.setAccount(account);
		customer.setAddress(address);
		customer.setAge(Integer.parseInt(age));
		customer.setBirthDate(birthDate);
		customer.setEmail(email);
		customer.setGender(gender);
		customer.setHeight(Integer.parseInt(height));
		customer.setJob(job);
		customer.setPhone(phone);
		customer.setWeight(Integer.parseInt(weight));
		customer.setMedicalHistory(medicalHistory);
		return true;
	}
	//seohyun
	public boolean setPaymentInfo(String contractID, PaymentInfo paymentInfo) {
		Contract contract = contractListImpl.retrieveById(Integer.parseInt(contractID));
		contract.setPaymentInfo(paymentInfo);
		return true;
	}
	public boolean manageLatePayment(String contractID) {
		Contract contract = contractListImpl.retrieveById(Integer.parseInt(contractID));
		if(contract.getNonPaymentPeriod()>= Constant.maximumLatePaymentPeriod) {
			return contractListImpl.deleteById(Integer.parseInt(contractID));
		}
		return false;
	}
	public boolean revive(Contract contract) {
		return contractListImpl.add(contract);
	}
	public void manageExpirationContract(String contractID) throws ParseException {
		Contract contract = contractListImpl.retrieveById(Integer.parseInt(contractID));
		if(!contract.isRenewalStatus()) {
				contractListImpl.deleteById(Integer.parseInt(contractID));
		}
	}
	public boolean update(Contract contract) {
		// TODO Auto-generated method stub
		int contractID = contract.getContractID();
		contractListImpl.update(contractID, contract);
		return contractListImpl.contains(contractListImpl.retrieveById(contractID));
	}
	public boolean createLoss(Compensation compensation, int compensationID) {
		return this.compensationListImpl.update(compensation, compensationID);
	}
	public boolean calculateInsuranceAmount(Compensation compensation, int compensationID) {
		return this.compensationListImpl.update(compensation, compensationID);
	}
	// get & set
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public int getEmployeeID() {return employeeID;}
	public void setEmployeeID(int employeeID) {this.employeeID = employeeID;}
	public String getEmployeePW() {return employeePW;}
	public void setEmployeePW(String employeePW) {this.employeePW = employeePW;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public InsuranceList getInsuranceList() {return insuranceListImpl;}
	public CounselList getCounselList() {return counselListImpl;}
	public ContractList getContractList() {return contractListImpl;}
	public CompensationList getCompensationList() {return compensationListImpl;}
	// set List
	public void setPaymentList(PaymentList paymentListImpl) {this.paymentListImpl = paymentListImpl;}
	public void setCompensationList(CompensationList compensationListImpl) {this.compensationListImpl = compensationListImpl;}
	public void setInsuranceList(InsuranceList insuranceListImpl) {this.insuranceListImpl = insuranceListImpl;}
	public void setCounselList(CounselList counselListImpl) {this.counselListImpl = counselListImpl;}
	public void setCustomerList(CustomerList customerList) {this.customerList = customerList;}
	public void setContractList(ContractList contractListImpl) {this.contractListImpl = contractListImpl;}
	public void setRuleList(RuleList ruleListImpl) {this.ruleListImpl = ruleListImpl;}
	public RuleList getRuleList() {return ruleListImpl;}	
}