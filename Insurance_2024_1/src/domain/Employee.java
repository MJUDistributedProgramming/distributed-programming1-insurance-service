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
import exception.DuplicateIDException;
import listImpl.CustomerListImpl;
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
	public String createRule(Rule rule) {
		boolean response = this.ruleListImpl.add(rule);
		if (response == true) return "[success] 성공적으로 제관리지침이 생성되었습니다!";
		else return "[error] 제관리지침 ID가 겹칩니다. 다시 시도해주세요";
		}
	public String deleteRule(int ruleID) {
		boolean response = this.ruleListImpl.deleteById(ruleID);
		if (response == true) return "[success] 성공적으로 제관리지침이 삭제되었습니다!";
		else return "[error] 제관리지침 ID가 겹칩니다. 다시 시도해주세요";
		}
	public String createInsurance(Insurance insurance) {
		boolean response = this.insuranceListImpl.add(insurance);
		if (response == true) return "[success] 성공적으로 보험 상품이 생성되었습니다!";
		else return "[error] 보험상품 ID가 겹칩니다. 다시 시도해주세요";
	}
	public String deleteInsurance(int insuranceID) {
		boolean response = this.insuranceListImpl.delete(insuranceID);
		if (response == true) return "[success] 성공적으로 보험 상품이 삭제되었습니다!";
		else return "[error] 보험상품 ID가 겹칩니다. 다시 시도해주세요";
		}
	public boolean createPayment(Payment payment) {return this.paymentListImpl.add(payment);}
	public boolean deletePayment(int paymentID) {return this.paymentListImpl.delete(paymentID);}
	public boolean createCompensation(Compensation compensation) {return this.compensationListImpl.add(compensation);}
	public boolean deleteCompensation(int compensationID) {return this.compensationListImpl.deleteById(compensationID);}
	public String processUnderwriting(Contract contract, String evaluation, String result) {
		contract.setEvaluation(evaluation);
		if (result.equals("Y")) {
			contract.setContractStatus(Constant.contractStatus3);
			contract.setUnderwritingEID(this.employeeID);
			contract.setPassUW(true);
			return "[success] 인수심사를 완료하였습니다.";
		} else contract.setContractStatus(Constant.contractStatus2);
		return "[info] 인수심사를 거절하였습니다. 해당 계약건을 인수 제한한 계약건으로 분류합니다";
	}
	public String permitContract(Contract contract, String result) {
		if (result.equals("Y")) {
			contract.setContractStatus(Constant.contractStatus4);
			return "[success] 계약 진행을 허가하셨습니다.";
		}
		return "[info] 계약 허가가 완료되지 않았습니다. 다시 페이지를 출력합니다.";
	}
	public String concludeContract(Contract contract, String result) {
		if (result.equals("Y")) {
			contract.setContractStatus(Constant.contractStatus5);
			contract.setConcludeEID(this.employeeID);
			contract.setConcludedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			contract.setConclude(true);
			return "[success] 계약체결이 완료되었습니다.";
		}
		return "[info] 계약진행에 실패했습니다. 본 페이지를 다시 출력합니다.";
	}
	public String requestReUnderwriting(Contract contract) {
		contract.setContractStatus(Constant.contractStatus1);
		return "[success] 재심사 요청이 완료되었습니다.";
	}
	public String createCustomer(Customer customer, String result) throws DuplicateIDException {
		if (result.equals("Y")) {
			return this.customerList.add(customer);
		}
		return "[info] 고객정보를 DB에 반영하지 않았습니다. 본 페이지로 이동합니다.";
	}
	public String deleteCustomer(int customerID) {
		return this.customerList.deleteById(customerID);
	}
	public String updateCustomer(String customerID, String name, String account, String address, String age,
		String birthDate, String email, String gender, String height, String job, String phone, String weight,
		MedicalHistory medicalHistory) {
		Customer customer = customerList.retrieveById(Integer.parseInt(customerID));
		if (customer == null) return "[error] 고객 정보 수정에 실패했습니다. 다시 시도해주세요.";
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
		return "[success] 성공적으로 고객 정보가 수정되었습니다!";
	}
	//seohyun
	public boolean confirmCounsel(Counsel counsel) {
		if(counsel.isConfirmedCounsel()) return false;
		else {
			counsel.setStatusOfCounsel(true);
			return true;
		}
	}
	public boolean updateCounsel(Counsel counsel, String counselDetail, String note) {
		if(counsel == null) return false;
		else return counsel.updateCounsel(counselDetail, note);
	}

	public String setPaymentInfo(String contractID, PaymentInfo paymentInfo) {
		Contract contract = contractListImpl.retrieveById(Integer.parseInt(contractID));
		contract.setPaymentInfo(paymentInfo);
		return "[success] 성공적으로 결제 정보가 등록되었습니다!";
	}
	public String manageLatePayment(String contractID) {
		boolean response = false;
		Contract contract = contractListImpl.retrieveById(Integer.parseInt(contractID));
		if(contract.getNonPaymentPeriod()>= Constant.maximumLatePaymentPeriod) {
			response= contractListImpl.deleteById(Integer.parseInt(contractID));
		}
		if(response) return "[success] 성공적으로 미납 관리가 되었습니다!";
		else return "[error] 미납 관리에 실패했습니다. 다시시도해주세요!";
	}
	public String revive(Contract contract) {
		boolean response= contractListImpl.add(contract);
		if(response) return "[success] 성공적으로 부활관리가 되었습니다!";
		else return "[error] 부활 관리에 실패했습니다. 다시시도해주세요!";
	}
	public String manageExpirationContract(String contractID, String expirationDate) throws ParseException {
		boolean response=false;
		SimpleDateFormat dateFormat =new SimpleDateFormat(Constant.dateFormat);
		Date date = dateFormat.parse(expirationDate);
		Date today = new Date();
		if(date.before(today)) {
			return "만기된 계약이 아닙니다";
		}
		Contract contract = contractListImpl.retrieveById(Integer.parseInt(contractID));
		if(!contract.isRenewalStatus()) {
				response=contractListImpl.deleteById(Integer.parseInt(contractID));
		}
		if(response) return "[success] 성공적으로 만기계약 관리가 되었습니다!";
		else return "[error] 만기계약 관리에 실패했습니다. 다시시도해주세요!";
	}
	public String manageRenewal(Contract contract) {
		if(contract.isRenewalStatus()) {
			createContract(contract);
			return "[success] 성공적으로 재계약이 되었습니다!";
		}else {
			return "[error] 재계약에 동의하지 않아 재계약에 실패했습니다!";
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