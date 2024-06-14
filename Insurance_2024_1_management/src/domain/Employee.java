package domain;
import IF.AssetManagementList;
import IF.BusinessStraegyList;
import IF.DepositClosureDetailList;
import IF.LoanApplicationList;
import IF.LoanList;
import IF.RegulationList;
import constant.Constant;
import exception.DuplicateIDException;
public class Employee {
	private int employeeID;
	private String employeePW;
	private String name;
	private String phone;
	private String gender;
	private String department;
	private Performance performance;
	private String position;
	private String salary;
	private String type;
	public Performance m_Performance;
	public Assignment m_Assignment;
	private AssetManagementList assetManagementListImpl;
	private BusinessStraegyList businessStraegyListImpl;
	private DepositClosureDetailList depositClosureDetailListImpl;
	private LoanApplicationList loanApplicationListImpl;
	private LoanList loanListImpl;
	private RegulationList regulationListImpl;
	public Employee() {}
	public void finalize() throws Throwable {}
	// 직원의 발령을 관리한다.
	public String assignmentManagement(Employee employee, Assignment assignment, String result) {
		if (result.equals("N")) return "[info] 발령정보를 저장하지 않았습니다.";
		employee.setM_Assignment(assignment);
		return "[success] 발령정보가 저장되었습니다.";
	}
	// 대출 신청 심사를 요청한다.
	public String loanApplicationReview(LoanApplication loanApplication, String result) {
		if (result.equals("N")) return "[info] 심사요청을 진행하지 않습니다.";
		loanApplication.setLoanStatus(Constant.loanStatus3);
		return "[success] 심사요청이 완료되었습니다.";
	}
	// 대출 신청을 심사한다.
	public String loanJudge(LoanApplication loanApplication, String result) {
		if (result.equals("N")) return "[info] 대출심사를 허용하지 않았습니다.";
		loanApplication.setLoanStatus(Constant.loanStatus4);
		return "[success] 대출 심사가 완료되었습니다.";
	}
	// 대출신청을 접수한다.
	public String loanTakeOver(String loanApplicationID) {
		LoanApplication loanApplication = loanApplicationListImpl.retrieveById(Integer.parseInt(loanApplicationID));
		if (loanApplication == null) return "[error] 해당 id의 대출신청이 존재하지 않습니다.";
		loanApplication.setLoanStatus(Constant.loanStatus2);
		return "[success] 대출신청을 접수완료하였습니다.";
	}
	// 신규 대출 상품을 개발한다.
	public String createLoan(Loan loan) throws DuplicateIDException {
		return loanListImpl.add(loan);
	}
	// 자산운용 사업을 개발한다.
	public String createAssetManagement(AssetManagement assetManagement) throws DuplicateIDException {
		return assetManagementListImpl.add(assetManagement);
	}
	// 성과를 평가하여 저장한다.
	public String savePerformanceEvaluation(Employee employee, Performance performance, String result) {
		if (result.equals("N")) return "[info] 성과평가를 진행하지 않았습니다.";
		employee.setPerformance(performance);
		return "[success] 성과평가가 저장되었습니다.";
	}
	// 직원의 승진을 관리한다.
	public String promotionManagement(Employee employee, String position, String result) {
		if (result.equals("N")) return "[info] 승진정보를 저장하지 않았습니다.";
		employee.setPosition(position);
		return "[success] " + employee.getEmployeeID() + "직원의 직급이 " + position + "으로 승진되었습니다.";
	}
	// 자산운용 사업의 심의를 진행한다.
	public String reviewProcessForAssetManagement(AssetManagement assetManagement, String result) {
		if (result.equals("N")) return "[info] 자산운용 심의를 허용하지 않았습니다.";
		assetManagement.setAssetManagementStatus(Constant.asetManagementStatus2);
		return "[success] 자산운용 심의가 완료되었습니다.";
	}
	// 경영전략을 수립한다.
	public String createBusinessStraegy(BusinessStrategy businessStraegy, String result) throws DuplicateIDException {
		if (result.equals("N")) return "[info] 경영전략을 추가하지 않았습니다.";
		return businessStraegyListImpl.add(businessStraegy);
	}
	// 경영전략 삭제.
	public String deleteBusinessStraegy(String strategyID) {
		return businessStraegyListImpl.deleteById(Integer.parseInt(strategyID));
	}
	// 경영전략 수정.
	public String updateBusinessStraegy(String strategyID, BusinessStrategy businessStraegy) {
		return businessStraegyListImpl.update(employeeID, businessStraegy);
	}
	// 사규를 생성한다.
	public String createRegulation(Regulation regulation, String result) throws DuplicateIDException {
		if (result.equals("N")) return "[info] 사규를 추가하지 않았습니다.";
		return regulationListImpl.add(regulation);
	}
	// 사규를 수정한다.
	public String updateRegulation(String regulationID, Regulation regulation) {
		return regulationListImpl.update(Integer.parseInt(regulationID), regulation);
	}
	// 사규를 삭제한다.
	public String deleteRegulation(String regulationID) {
		return regulationListImpl.deleteById(Integer.parseInt(regulationID));
	}
	// 원수예금 및 마감 정보를 입력한다.
	public String createDepositClosureDetail(DepositClosureDetail depositClosureDetail, String result) throws DuplicateIDException {
		if (result.equals("N")) return "[info] 원수예금마감정보를 추가하지 않았습니다.";
		return depositClosureDetailListImpl.add(depositClosureDetail);
	}
	// 직원의 임금을 수정한다.
	public String salaryAdjustment(Employee employee, String salary, String result) {
		if (result.equals("N")) return "[info] 해당 임금을 수정하지 않았습니다.";
		employee.setSalary(salary);
		return "[success] 임금 수정이 완료되었습니다.";
	}
	// set & get
	public void setAssetManagementListImpl(AssetManagementList assetManagementListImpl) {this.assetManagementListImpl = assetManagementListImpl;}
	public void setBusinessStraegyListImpl(BusinessStraegyList businessStraegyListImpl) {this.businessStraegyListImpl = businessStraegyListImpl;}
	public void setDepositClosureDetailListImpl(DepositClosureDetailList depositClosureDetailListImpl) {this.depositClosureDetailListImpl = depositClosureDetailListImpl;}
	public void setLoanApplicationListImpl(LoanApplicationList loanApplicationListImpl) {this.loanApplicationListImpl = loanApplicationListImpl;}
	public void setLoanListImpl(LoanList loanListImpl) {this.loanListImpl = loanListImpl;}
	public void setRegulationListImpl(RegulationList regulationListImpl) {this.regulationListImpl = regulationListImpl;}
	public Performance getM_Performance() {return m_Performance;}
	public void setM_Performance(Performance m_Performance) {this.m_Performance = m_Performance;}
	public Assignment getM_Assignment() {return m_Assignment;}
	public void setM_Assignment(Assignment m_Assignment) {this.m_Assignment = m_Assignment;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	public String getDepartment() {return department;}
	public void setDepartment(String department) {this.department = department;}
	public int getEmployeeID() {return employeeID;}
	public void setEmployeeID(int employeeID) {this.employeeID = employeeID;}
	public Performance getPerformance() {return performance;}
	public void setPerformance(Performance performance) {this.performance = performance;}
	public String getPosition() {return position;}
	public void setPosition(String position) {this.position = position;}
	public String getSalary() {return salary;}
	public String getEmployeePW() {return employeePW;}
	public void setEmployeePW(String employeePW) {this.employeePW = employeePW;}
	public void setSalary(String salary) {this.salary = salary;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
}