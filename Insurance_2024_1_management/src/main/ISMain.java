package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import IF.AssetManagementList;
import IF.BusinessStraegyList;
import IF.CustomerList;
import IF.DepositClosureDetailList;
import IF.EmployeeList;
import IF.LoanApplicationList;
import IF.LoanList;
import IF.RegulationList;
import constant.Constant;
import domain.AssetManagement;
import domain.Assignment;
import domain.BusinessPlan;
import domain.BusinessStrategy;
import domain.Customer;
import domain.DepositClosureDetail;
import domain.Employee;
import domain.Loan;
import domain.LoanApplication;
import domain.Performance;
import domain.Regulation;
import exception.AuthenticationException;
import exception.AuthorizationException;
import exception.DuplicateIDException;
import exception.NotFoundProfileException;
import listImpl.AssetManagementListImpl;
import listImpl.BusinessStraegyListImpl;
import listImpl.CustomerListImpl;
import listImpl.DepositClosureDetailListImpl;
import listImpl.EmployeeListImpl;
import listImpl.LoanApplicationListImpl;
import listImpl.LoanListImpl;
import listImpl.RegulationListImpl;
public class ISMain {
	// main attributes
	private static CustomerList customerListImpl;
	private static EmployeeList employeeListImpl;
	private static AssetManagementList assetManagementListImpl;
	private static BusinessStraegyList businessStraegyListImpl;
	private static DepositClosureDetailList depositClosureDetailListImpl;
	private static LoanApplicationList loanApplicationListImpl;
	private static LoanList loanListImpl;
	private static RegulationList regulationListImpl;
	// 멤버변수 수정사항
	private static Employee employee;
	private static Customer customer;
	private static BufferedReader clientInputReader;
	public ISMain() {
		clientInputReader = new BufferedReader(new InputStreamReader(System.in));
		customerListImpl = new CustomerListImpl();
		employeeListImpl = new EmployeeListImpl();
		assetManagementListImpl = new AssetManagementListImpl();
		businessStraegyListImpl = new BusinessStraegyListImpl();
		depositClosureDetailListImpl = new DepositClosureDetailListImpl();
		loanApplicationListImpl = new LoanApplicationListImpl();
		loanListImpl = new LoanListImpl();
		regulationListImpl = new RegulationListImpl();
	}
	public static void main(String[] args) throws IOException, ParseException, AuthenticationException, AuthorizationException, DuplicateIDException {
		ISMain main = new ISMain();
		main.setDemoData();
		main.startInsuranceService();
	}
	private static void printMainMenu() {
		System.out.println("***************** 보험사 시스템 웹페이지 *****************");
		System.out.println("1. 고객서비스");
		System.out.println("2. 직원서비스");
		System.out.println("X. 종료");
	}
	private void startInsuranceService() throws IOException, ParseException, AuthenticationException, AuthorizationException{
		while(true) {
			try {
				printMainMenu();
				String clientChoice = clientInputReader.readLine().trim();
				if (clientChoice.equals("1")) startCustomerService();
				else if (clientChoice.equals("2")) startEmployeeService();
				else if (clientChoice.equals("X")) {
					System.out.println("|*** 보험사 시스템을 이용해주셔서 감사합니다! ***|");
					System.exit(0);
				}
				else System.out.println("--잘못된 입력입니다.--");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	private static void printCustomerMainMenu() {
		System.out.println("***************** 고객 서비스 메뉴 *****************");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 로그아웃");
		System.out.println("4. 회원탈퇴");
		System.out.println("5. 대출신청");
		System.out.println("6. 대출신청조회");
		System.out.println("R. 홈페이지");
	}
	private void startCustomerService() throws IOException, AuthenticationException, AuthorizationException{
		while(true) {
			printCustomerMainMenu();
			String clientChoice = clientInputReader.readLine().trim();
			try {
				if (clientChoice.equals("1")) login(Constant.Customer);
				else if (clientChoice.equals("2")) signUp(Constant.Customer);
				else if (clientChoice.equals("3")) logout();
				else if (clientChoice.equals("4")) deleteMembership(Constant.Customer);
				else if (clientChoice.equals("5")) loanApplication();
				else if (clientChoice.equals("6")) showLoanApplicationList();
				else if (clientChoice.equals("R")) {
					System.out.println("|*** 본 홈페이지로 돌아갑니다. ***|");
					return;
				}
				else System.out.println("invalid choice");
			} catch (DuplicateIDException e) {
				System.out.println(e.getMessage());
			} catch (NotFoundProfileException e) {
				System.out.println(e.getMessage());
			} catch (AuthenticationException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private void showLoanApplicationList() throws AuthenticationException {
		int index = 1;
		System.out.println();
		System.out.println("-- 대출 신청 리스트 --");
		for(LoanApplication loanApplication : loanApplicationListImpl.retrieveAll()) {
			System.out.println(index + ". 대출신청ID: " + loanApplication.getLoanApplicationID() + " | 고객ID: " + loanApplication.getCustomerID()+ " | 대출금액: " + loanApplication.getLoanAmount()
			+ " | 대출ID: " + loanApplication.getLoanID()+ " | 대출목적: " + loanApplication.getLoanPurpose()+ " | 대출상태: " + loanApplication.getLoanStatus()+ " | 결제사이름: " + loanApplication.getPaymentCompanyName());
			index++;
		}
	}
	// 대출을 신청한다.
	private void loanApplication() throws AuthenticationException, IOException, DuplicateIDException {
		if (customer==null) throw new AuthenticationException();
		System.out.println("-- 대출신청 정보 입력란 --");
		// basic attribute settings
		int customerID = customer.getCustomerID();
		System.out.print("대출신청ID: "); String loanApplicationID = dataValidation(clientInputReader.readLine().trim(), "Integer");
		System.out.print("대출ID: "); String loanID = dataValidation(clientInputReader.readLine().trim(), "String");
		System.out.print("대출금액: "); String loanAmount = dataValidation(clientInputReader.readLine().trim(), "String");
		System.out.print("대출목적: "); String loanPurpose = dataValidation(clientInputReader.readLine().trim(), "String");
		System.out.print("결제사이름: "); String paymentCompanyName = dataValidation(clientInputReader.readLine().trim(), "String");		
		LoanApplication loanApplication = new LoanApplication();
		loanApplication.setCustomerID(customerID);
		loanApplication.setLoanApplicationID(Integer.parseInt(loanApplicationID));
		loanApplication.setLoanID(Integer.parseInt(loanID));
		loanApplication.setLoanAmount(loanAmount);
		loanApplication.setLoanPurpose(loanPurpose);
		loanApplication.setPaymentCompanyName(paymentCompanyName);
		loanApplication.setLoanStatus(Constant.loanStatus1);
		System.out.println(customer.loanApplication(loanApplication));
	}
	private static void printEmployeeMainMenu() {
		System.out.println("***************** 직원 서비스 메뉴 *****************");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 로그아웃");
		System.out.println("4. 회원탈퇴");
		System.out.println("5. 신청된 대출 접수");
		System.out.println("6. 심사 카테고리");
		System.out.println("7. 신규 대출 상품 개발");
		System.out.println("8. 자산운용 사업 개발");
		System.out.println("9. 경영전략 카테고리");
		System.out.println("10. 사규 카테고리");
		System.out.println("11. 원수 예금 및 마감 정보 입력");
		System.out.println("12. 인사괸리 카테고리");
		System.out.println("13. 대출금 지급");
		System.out.println("R. 홈페이지");
	}
	private void startEmployeeService() throws IOException, ParseException, AuthenticationException, AuthorizationException{
		while(true) {
			printEmployeeMainMenu();
			String clientChoice = clientInputReader.readLine().trim();
			try {
				if (clientChoice.equals("1")) login(Constant.Employee);
				else if (clientChoice.equals("2")) signUp(Constant.Employee);
				else if (clientChoice.equals("3")) logout();
				else if (clientChoice.equals("4")) deleteMembership(Constant.Employee);
				else if (clientChoice.equals("5")) loanTakeOver();
				else if (clientChoice.equals("6")) judgeCategory();
				else if (clientChoice.equals("7")) createLoan();
				else if (clientChoice.equals("8")) createAssetManagement();
				else if (clientChoice.equals("9")) businessStraegyCategory();
				else if (clientChoice.equals("10")) regulationCategory();
				else if (clientChoice.equals("11")) createDepositClosureDetail();
				else if (clientChoice.equals("12")) humanResourceManagementCategory();
				else if (clientChoice.equals("13")) disburseLoanAmount();
				else if (clientChoice.equals("R")) {
					System.out.println("|*** 본 홈페이지로 돌아갑니다. ***|");
					return;
				}
				else System.out.println("--잘못된 입력입니다.--");
			} catch (DuplicateIDException e) {
				System.out.println(e.getMessage());
			} catch (AuthorizationException e) {
				System.out.println(e.getMessage());
			} catch (NotFoundProfileException e) {
				System.out.println(e.getMessage());
			} catch (AuthenticationException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 대출신청을 접수한다.
	private void loanTakeOver() throws IOException, AuthenticationException {
		if (employee==null) throw new AuthenticationException();
		int index = 1;
		ArrayList<LoanApplication> permitLoanApplicationList = loanApplicationListImpl.retrieveByLoanStatus(Constant.loanStatus1);
		if(permitLoanApplicationList.size() == 0) {
			System.out.println("대출신청된 내역이 존재하지 않습니다.");
			return;
		}
		System.out.println("-- 신청된 대출신청 리스트. --");
		for(LoanApplication loanApplication : permitLoanApplicationList) {
			System.out.println(index + ". 대출신청ID: " + loanApplication.getLoanApplicationID() + " | 고객ID: " + loanApplication.getCustomerID()+ " | 대출금액: " + loanApplication.getLoanAmount()
			+ " | 대출ID: " + loanApplication.getLoanID()+ " | 대출목적: " + loanApplication.getLoanPurpose()+ " | 대출상태: " + loanApplication.getLoanStatus()+ " | 결제사이름: " + loanApplication.getPaymentCompanyName());
			index++;
		}
		System.out.println("-----------------------------");
		System.out.print("접수할 대출신청 id: "); String loanApplicationID = dataValidation(clientInputReader.readLine().trim(), "String");
		System.out.println(employee.loanTakeOver(loanApplicationID));
		loanApplicationReview(loanApplicationID);
	}
	// 대출 신청 심사를 요청한다.
	private void loanApplicationReview(String loanApplicationID) throws IOException, AuthenticationException {
		if (employee==null) throw new AuthenticationException();
		LoanApplication loanApplication = loanApplicationListImpl.retrieveById(Integer.parseInt(loanApplicationID));
		System.out.println("-- 대출신청 상세정보  --");
		System.out.println("심사요청할 대출 정보 . 대출신청ID: " + loanApplication.getLoanApplicationID() + " | 고객ID: " + loanApplication.getCustomerID()+ " | 대출금액: " + loanApplication.getLoanAmount()
		+ " | 대출ID: " + loanApplication.getLoanID()+ " | 대출목적: " + loanApplication.getLoanPurpose()+ " | 대출상태: " + loanApplication.getLoanStatus()+ " | 결제사이름: " + loanApplication.getPaymentCompanyName());
		System.out.println("-----------------------------");
		System.out.println("해당 대출은 심의위원회에 심사요청하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
		System.out.println(employee.loanApplicationReview(loanApplication, result));
	}
	//// 심사 카테고리 - 대출신청을 심사한다. 자산운용 사업의 심의를 진행한다.
	private void judgeCategory() throws IOException, DuplicateIDException, AuthenticationException, AuthorizationException, NotFoundProfileException {
		if (employee==null) throw new AuthenticationException();
		if (!employee.getType().equals(Constant.AssetManagementReviewCommittee)) throw new AuthorizationException("[Exception] 자산운영심의위원회 직원만 접근이 가능합니다.");
		while(true) {
			System.out.println("***************** 심사 카테고리 메뉴 *****************");
			System.out.println("1. 대출 신청 심사");
			System.out.println("2. 자산운용 사업 심의");
			System.out.println("R. 돌아가기");
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) loanJudge();
			else if (clientChoice.equals("2")) reviewProcessForAssetManagement();
			else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Employee Main Menu ***|");
				return;
			}
			else System.out.println("invalid choice");
		}
	}
	// 대출신청을 심사한다.
	private void loanJudge() throws IOException {
		int index = 1;
		ArrayList<LoanApplication> requestedApplicationList = loanApplicationListImpl.retrieveByLoanStatus(Constant.loanStatus3);
		if(requestedApplicationList.size() == 0) {
			System.out.println("심사요청된 대출신청 내역이 존재하지 않습니다.");
			return;
		}
		System.out.println("-- 심사요청된 대출신청 리스트. --");
		for(LoanApplication loanApplication : requestedApplicationList) {
			System.out.println(index + ". 대출신청ID: " + loanApplication.getLoanApplicationID() + " | 고객ID: " + loanApplication.getCustomerID()+ " | 대출금액: " + loanApplication.getLoanAmount()
			+ " | 대출ID: " + loanApplication.getLoanID()+ " | 대출목적: " + loanApplication.getLoanPurpose()+ " | 대출상태: " + loanApplication.getLoanStatus()+ " | 결제사이름: " + loanApplication.getPaymentCompanyName());
			index++;
		}
		System.out.println("-----------------------------");
		System.out.print("심사할 대출신청 id: "); String loanApplicationID = dataValidation(clientInputReader.readLine().trim(), "String");
		LoanApplication loanApplication = loanApplicationListImpl.retrieveById(Integer.parseInt(loanApplicationID));
		System.out.println("해당 대출을 진행허가 하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
		if (loanApplication == null) {
			System.out.println("[error] 해당 id의 대출이 존재하지 않습니다. 본 페이지로 돌아갑니다.");
			return;
		}
		System.out.println(employee.loanJudge(loanApplication, result));
		
	}
	// 자산운용 사업의 심의를 진행한다.
	private void reviewProcessForAssetManagement() throws IOException {
		int index = 1;
		ArrayList<AssetManagement> requestedAssetManagementStatus = assetManagementListImpl.retrieveByAssetManagementStatus(Constant.assetManagementStatus1);
		if(requestedAssetManagementStatus.size() == 0) {
			System.out.println("심의요청된 자산운용 내역이 존재하지 않습니다.");
			return;
		}
		System.out.println("-- 심의요청된 자산운용 리스트. --");
		for(AssetManagement assetManagement : requestedAssetManagementStatus) {
			System.out.println(index + ". " + "자산운용id: "+assetManagement.getAssetManagementID()+ " | 상태: "+assetManagement.getAssetManagementStatus()+ " | 경쟁사동향: "+assetManagement.getCompetitorTrend()+ " | 제약사항: "+assetManagement.getConstraint()+ " | 생성한 직원 id: "+assetManagement.getEmployeeID()
			+ " | 투자목표: "+assetManagement.getInvestmentGoal()+ " | 투자전략: "+assetManagement.getInvestmentStrategy()+ " | 시장정보: "+assetManagement.getMarketInfomation()+ " | 전망: "+assetManagement.getProspect()+ " | 리스크 대처 방안: "+assetManagement.getRickPlan()+ " | 리스크 값: "+assetManagement.getRisk());
			index++;
		}
		System.out.println("-----------------------------");
		System.out.print("심의할 자산운용 id: "); String assetManagementID = dataValidation(clientInputReader.readLine().trim(), "String");
		AssetManagement assetManagement = assetManagementListImpl.retrieveById(Integer.parseInt(assetManagementID));
		// --- 해당 대출 정보 출력하기
		System.out.println("------------------------------");
		System.out.println("해당 자산운용을 진행허가 하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
		if (assetManagement == null) {
			System.out.println("[error] 해당 id의 자산운용이 존재하지 않습니다. 본 페이지로 돌아갑니다.");
			return;
		}
		System.out.println(employee.reviewProcessForAssetManagement(assetManagement, result));
	}
	//------------------------------------------------------------------

	// 신규 대출 상품을 개발한다.
	private void createLoan() throws AuthenticationException, IOException, DuplicateIDException {
		if (employee==null) throw new AuthenticationException();
		System.out.println("-- 신규 대출 상품 정보 입력란 --");
		// basic attribute settings
		System.out.print("대출ID: "); String loanID = dataValidation(clientInputReader.readLine().trim(), "Integer");
		int employeeID = employee.getEmployeeID();
		System.out.print("수수료: "); String charge = dataValidation(clientInputReader.readLine().trim(), "String");
		System.out.print("이자율: "); String interestRate = dataValidation(clientInputReader.readLine().trim(), "String");
		System.out.print("대출이름: "); String loanName = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("대출기간: "); String loanTerm = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("자격요건: "); String Qualification = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("상환방식: "); String repaymentMethod = dataValidation(clientInputReader.readLine().trim(), "String");		
		Loan loan = new Loan();
		loan.setLoanID(Integer.parseInt(loanID));
		loan.setEmployeeID(employeeID);
		loan.setCharge(charge);
		loan.setInterestRate(interestRate);
		loan.setLoanName(loanName);
		loan.setLoanTerm(loanTerm);
		loan.setQualification(Qualification);
		loan.setRepaymentMethod(repaymentMethod);
		System.out.println(employee.createLoan(loan));
	}
	// 자산운용 사업을 개발한다.
	private void createAssetManagement() throws AuthenticationException, IOException, DuplicateIDException {
		if (employee==null) throw new AuthenticationException();
		System.out.println("-- 자산운용 사업 개발 정보 입력란 --");
		// basic attribute settings
		System.out.print("자산운용ID: "); String assetManagementID = dataValidation(clientInputReader.readLine().trim(), "Integer");
		int employeeID = employee.getEmployeeID();
		String assetManagementStatus = Constant.assetManagementStatus1;
		System.out.print("경쟁사동향: "); String CompetitorTrend = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("제약조건: "); String constraint = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("투자목표: "); String investmentGoal = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("투자전략: "); String investmentStrategy = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("시장현황: "); String marketInfomation = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("전망: "); String prospect = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("리스크 대처 방안: "); String rickPlan = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("리스크 값: "); String risk = dataValidation(clientInputReader.readLine().trim(), "String");		
		// composition to whole settings
		BusinessPlan businessPlan = new BusinessPlan();
		System.out.print("사업계획ID: "); String businessPlanID = dataValidation(clientInputReader.readLine().trim(), "Integer");
		System.out.print("자산: "); String asset = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("예산: "); String budget = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("투자기간: "); String InvestmentPeriod = dataValidation(clientInputReader.readLine().trim(), "String");		
		System.out.print("목표 수익: "); String targetProfit = dataValidation(clientInputReader.readLine().trim(), "String");		
		businessPlan.setBusinessPlanID(Integer.parseInt(businessPlanID));
		businessPlan.setEmployeeID(employeeID);
		businessPlan.setAsset(asset);
		businessPlan.setBudget(budget);
		businessPlan.setInvestmentPeriod(InvestmentPeriod);
		businessPlan.setTargetProfit(targetProfit);
		//end settings
		AssetManagement assetManagement = new AssetManagement();
		assetManagement.setAssetManagementID(Integer.parseInt(assetManagementID));
		assetManagement.setEmployeeID(employeeID);
		assetManagement.setAssetManagementStatus(assetManagementStatus);
		assetManagement.setBusinessPlan(businessPlan);
		assetManagement.setCompetitorTrend(CompetitorTrend);
		assetManagement.setConstraint(constraint);
		assetManagement.setInvestmentGoal(investmentGoal);
		assetManagement.setInvestmentStrategy(investmentStrategy);
		assetManagement.setMarketInfomation(marketInfomation);
		assetManagement.setProspect(prospect);
		assetManagement.setRickPlan(rickPlan);
		assetManagement.setRisk(risk);
		System.out.println(employee.createAssetManagement(assetManagement));
	}
	//// 경영전략 카테고리 - 경영전략을 수립한다.
	private void businessStraegyCategory() throws IOException, DuplicateIDException, AuthenticationException, AuthorizationException, NotFoundProfileException {
		if (employee==null) throw new AuthenticationException();
		while(true) {
			System.out.println("***************** 경영전략 카테고리 메뉴 *****************");
			System.out.println("1. 경영전략 조회");
			System.out.println("2. 경영전략 수립");
			System.out.println("3. 경영전략 수정");
			System.out.println("4. 경영전략 삭제");
			System.out.println("R. 돌아가기");
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) showBusinessStraegyList();
			else if (clientChoice.equals("2")) createBusinessStraegy();
			else if (clientChoice.equals("3")) updateBusinessStraegy();
			else if (clientChoice.equals("4")) deleteBusinessStraegy();
			else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Employee Main Menu ***|");
				return;
			}
			else System.out.println("invalid choice");
		}
	}
	private void updateBusinessStraegy() throws IOException {
		System.out.println("-- 수정할 경영 전략 정보 입력란 --");
		System.out.print("수정할 전략ID: "); String strategyID = dataValidation(clientInputReader.readLine().trim(), "Integer");
		System.out.print("전략 이름: "); String strategyName = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("연간 목표: "); String annualGoal = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("예산: "); String budget = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("산업 분석: "); String industryAnalysis = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("중장기 목표: "); String longTermGoal = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("시장 분석: "); String marketAnalysis = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("정책: "); String policy = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("법규: "); String regulation = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("준비금: "); String reserve = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("전략 목표: "); String strategyGoal = dataValidation(clientInputReader.readLine().trim(), "String");
	    BusinessStrategy businessStraegy = new BusinessStrategy();
	    businessStraegy.setStrategyID(Integer.parseInt(strategyID));
	    businessStraegy.setStrategyName(strategyName);
	    businessStraegy.setAnnualGoal(annualGoal);
	    businessStraegy.setBudget(budget);
	    businessStraegy.setIndustryAnalysis(industryAnalysis);
	    businessStraegy.setLongTermGoal(longTermGoal);
	    businessStraegy.setMarketAnalysis(marketAnalysis);
	    businessStraegy.setPolicy(policy);
	    businessStraegy.setRegulation(regulation);
	    businessStraegy.setReserve(reserve);
	    businessStraegy.setStrategyGoal(strategyGoal);
		System.out.println(employee.updateBusinessStraegy(strategyID, businessStraegy));
	}
	private void deleteBusinessStraegy() throws IOException {
		System.out.println("-- 삭제할 경영 전략 정보 입력란 --");
	    // basic attribute settings
	    System.out.print("삭제할 전략ID: "); String strategyID = dataValidation(clientInputReader.readLine().trim(), "Integer");
	    System.out.println(employee.deleteBusinessStraegy(strategyID));
	}
	private void showBusinessStraegyList() {
		int index = 1;
		System.out.println();
		System.out.println("-- 경영전략 리스트 --");
		for(BusinessStrategy businessStraegy : businessStraegyListImpl.retrieveAll()) {
			System.out.println(index + ". 전략 ID: " + businessStraegy.getStrategyID() + " | 연간목표: " + businessStraegy.getAnnualGoal() + " | 예산: " + businessStraegy.getBudget()+ " | 산업분석: " + businessStraegy.getIndustryAnalysis()+ " | 중장기목표: " + businessStraegy.getLongTermGoal()+ " | 시장분석: " + businessStraegy.getMarketAnalysis()+ " | 정책: " + businessStraegy.getPolicy()
			+ " | 법규: " + businessStraegy.getRegulation()+ " | 준비금: " + businessStraegy.getReserve()+ " | 전략목표: " + businessStraegy.getStrategyGoal()+ " | 연간목표: " + businessStraegy.getAnnualGoal()+ " | 전략이름: " + businessStraegy.getStrategyName());
			index++;
		}
	}
	// 경영 전략을 수립한다.
	private void createBusinessStraegy() throws AuthenticationException, IOException, DuplicateIDException {
	    System.out.println("-- 신규 경영 전략 정보 입력란 --");
	    // basic attribute settings
	    System.out.print("전략ID: "); String strategyID = dataValidation(clientInputReader.readLine().trim(), "Integer");
	    System.out.print("전략 이름: "); String strategyName = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("연간 목표: "); String annualGoal = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("예산: "); String budget = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("산업 분석: "); String industryAnalysis = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("중장기 목표: "); String longTermGoal = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("시장 분석: "); String marketAnalysis = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("정책: "); String policy = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("법규: "); String regulation = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("준비금: "); String reserve = dataValidation(clientInputReader.readLine().trim(), "String");
	    System.out.print("전략 목표: "); String strategyGoal = dataValidation(clientInputReader.readLine().trim(), "String");
	    BusinessStrategy businessStraegy = new BusinessStrategy();
	    businessStraegy.setStrategyID(Integer.parseInt(strategyID));
	    businessStraegy.setStrategyName(strategyName);
	    businessStraegy.setAnnualGoal(annualGoal);
	    businessStraegy.setBudget(budget);
	    businessStraegy.setIndustryAnalysis(industryAnalysis);
	    businessStraegy.setLongTermGoal(longTermGoal);
	    businessStraegy.setMarketAnalysis(marketAnalysis);
	    businessStraegy.setPolicy(policy);
	    businessStraegy.setRegulation(regulation);
	    businessStraegy.setReserve(reserve);
	    businessStraegy.setStrategyGoal(strategyGoal);
		System.out.println("해당 경영전략을 추가하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
	    System.out.println(employee.createBusinessStraegy(businessStraegy, result));
	}
	//----------------------------------------------------------------
	//// 사규 카테고리 - 사규를 생성한다.
	private void regulationCategory() throws IOException, DuplicateIDException, AuthenticationException, AuthorizationException, NotFoundProfileException {
		if (employee==null) throw new AuthenticationException();
		while(true) {
			System.out.println("***************** 경영전략 카테고리 메뉴 *****************");
			System.out.println("1. 사규 조회");
			System.out.println("2. 사규 생성");
			System.out.println("3. 사규 수정");
			System.out.println("4. 사규 삭제");
			System.out.println("R. 돌아가기");
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) showRegulationList();
			else if (clientChoice.equals("2")) createRegulation();
			else if (clientChoice.equals("3")) updateRegulation();
			else if (clientChoice.equals("4")) deleteRegulation();
			else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Employee Main Menu ***|");
				return;
			}
			else System.out.println("invalid choice");
		}
	}
	private void updateRegulation() throws IOException {
		System.out.println("-- 수정할 사규 정보 입력란 --");
        // basic attribute settings
        System.out.print("수정할 사규ID: "); String regulationID = dataValidation(clientInputReader.readLine().trim(), "Integer");
        System.out.print("사규제목: "); String regulationTitle = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("사규내용: "); String regulationContent = dataValidation(clientInputReader.readLine().trim(), "String");
        int updateWriterID = employee.getEmployeeID();
        String updatedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Regulation regulation = regulationListImpl.retrieveById(Integer.parseInt(regulationID));
        if (regulation!=null) {
        	regulation.setRegulationID(Integer.parseInt(regulationID));
            regulation.setRegulationTitle(regulationTitle);
            regulation.setRegulationContent(regulationContent);
            regulation.setUpdateWriterID(updateWriterID);
            regulation.setUpdateDate(updatedDate);
		}
        System.out.println(employee.updateRegulation(regulationID, regulation));
	}
	private void deleteRegulation() throws IOException {
		System.out.println("-- 삭제할 사규 정보 입력란 --");
        // basic attribute settings
        System.out.print("삭제할 사규ID: "); String regulationID = dataValidation(clientInputReader.readLine().trim(), "Integer");
        System.out.println(employee.deleteRegulation(regulationID));
	}
	private void showRegulationList() {
		int index = 1;
		System.out.println();
		System.out.println("-- 사규 리스트 --");
		for(Regulation regulation : regulationListImpl.retrieveAll()) {
			System.out.println(index + ". 사규ID: " + regulation.getRegulationID() + " | 사규제목: " + regulation.getRegulationTitle()+ " | 사규내용: " + regulation.getRegulationContent()+ " | 작성자ID: " + regulation.getWriterID()+ " | 게시일: " + regulation.getPostedDate());
			index++;
		}
	}
	// 사규를 생성한다.
    private void createRegulation() throws AuthenticationException, IOException, DuplicateIDException {
        System.out.println("-- 신규 사규 정보 입력란 --");
        // basic attribute settings
        System.out.print("사규ID: "); String regulationID = dataValidation(clientInputReader.readLine().trim(), "Integer");
        System.out.print("사규제목: "); String regulationTitle = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("사규내용: "); String regulationContent = dataValidation(clientInputReader.readLine().trim(), "String");
        int writerID = employee.getEmployeeID();
        String postedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Regulation regulation = new Regulation();
        regulation.setRegulationID(Integer.parseInt(regulationID));
        regulation.setRegulationTitle(regulationTitle);
        regulation.setRegulationContent(regulationContent);
        regulation.setWriterID(writerID);
        regulation.setPostedDate(postedDate);
        System.out.println("해당 사규를 추가하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
        System.out.println(employee.createRegulation(regulation, result));
    }
    // -------------------------------------------------------
    
    // 원수 예금 및 마감 정보를 입력한다.
    private void createDepositClosureDetail() throws AuthenticationException, IOException, DuplicateIDException {
        if (employee == null) throw new AuthenticationException();
        System.out.println("-- 신규 예금 마감 정보 입력란 --");
        // basic attribute settings
        System.out.print("예금 해지 상세 ID: "); String depositClosureDetailId = dataValidation(clientInputReader.readLine().trim(), "Integer");
        System.out.print("은행명: "); String nameOfBank = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("계좌번호: "); String account = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("거래일: "); String tradingDate = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("입금액: "); String depositAmount = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("출금액: "); String withdrawalAmount = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.println("-- 원수 예금 정보가 저장되었습니다. --");
        System.out.print("마감일: "); String closingDate = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("최종 거래 상태: "); String lastTransactionStatus = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("최종 거래 금액: "); String lastTransactionAmount = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("조정 금액: "); String adjustmentAmount = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("조정 이유: "); String adjustmentReason = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.println("-- 마감 정보가 저장되었습니다. --");
        int employeeID = employee.getEmployeeID();
        DepositClosureDetail depositClosureDetail = new DepositClosureDetail();
        depositClosureDetail.setDepositClosureDetailId(Integer.parseInt(depositClosureDetailId));
        depositClosureDetail.setNameOfBank(nameOfBank);
        depositClosureDetail.setAccount(account);
        depositClosureDetail.setTradingDate(tradingDate);
        depositClosureDetail.setDepositAmount(depositAmount);
        depositClosureDetail.setWithdrawalAmount(withdrawalAmount);
        depositClosureDetail.setClosingDate(closingDate);
        depositClosureDetail.setLastTransactionStatus(lastTransactionStatus);
        depositClosureDetail.setLastTransactionAmount(lastTransactionAmount);
        depositClosureDetail.setAdjustmentAmount(adjustmentAmount);
        depositClosureDetail.setAdjustmentReason(adjustmentReason);
        depositClosureDetail.setEmployeeID(employeeID);
        System.out.println("해당 예금 마감 정보를 추가하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
        System.out.println(employee.createDepositClosureDetail(depositClosureDetail, result));
    }
	//// 인사관리 카테고리 - 성과를 평가하여 저장한다. 직원의 발령을 관리한다. 직원의 승진을 관리한다. 직원의 임금을 수정한다.
	private void humanResourceManagementCategory() throws IOException, DuplicateIDException, AuthenticationException, AuthorizationException, NotFoundProfileException {
		if (employee==null) throw new AuthenticationException();
		while(true) {
			System.out.println("***************** 인사관리 카테고리 메뉴 *****************");
			System.out.println("1. 직원정보 조회");
			System.out.println("2. 성과평가 및 저장");
			System.out.println("3. 직원 발령 관리");
			System.out.println("4. 승진 관리");
			System.out.println("R. 돌아가기");
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) retrieveEmployeeInfomaion();
			else if (clientChoice.equals("2")) performanceEvaluation();
			else if (clientChoice.equals("3")) assignmentManagement();
			else if (clientChoice.equals("4")) promotionManagement();
			else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Employee Main Menu ***|");
				return;
			}
			else System.out.println("invalid choice");
		}
	}
	// 직원 정보 조회
	private void retrieveEmployeeInfomaion() throws IOException {
		System.out.println("-- 직원 정보 조회 입력란 --");
	    System.out.print("검색할 직원 ID: "); String employeeID = dataValidation(clientInputReader.readLine().trim(), "Integer");
	    Employee employee = employeeListImpl.retrieveById(Integer.parseInt(employeeID));
	    if (employee == null) {
	    	System.out.println("[error] 해당 id의 직원이 존재하지 않습니다.");
	    	return;
	    }
	    System.out.println("직원ID: "+employee.getEmployeeID()+" | 이름: "+employee.getName()+" | 폰번호: "+employee.getPhone()+" | 성별: "+employee.getGender()+" | 부서: "+employee.getDepartment()+" | 직급: "+employee.getPosition()+" | 봉급: "+employee.getSalary()+" | 타입: "+employee.getType());
	    // todo ~~~~~~~~~ 직원 정보 쭉 나열
	}
	// 성과를 평가하여 저장한다.
    private void performanceEvaluation() throws IOException {
        System.out.println("-- 성과 평가 입력란 --");
        // 성과 점수 입력란
	    System.out.print("평가할 직원 ID: "); String employeeID = dataValidation(clientInputReader.readLine().trim(), "Integer");
        System.out.print("프로젝트 완수도: "); String projectCompletionRate = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("팀워크 점수: "); String teamworkScore = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("팀장 평가: "); String teamLeaderEvaluation = dataValidation(clientInputReader.readLine().trim(), "String");
        Performance performance = new Performance();
        performance.setProjectCompletionRate(projectCompletionRate);
        performance.setTeamworkScore(teamworkScore);
        performance.setTeamLeaderEvaluation(teamLeaderEvaluation);
        if (employee == null) {
	    	System.out.println("[error] 해당 id의 직원이 존재하지 않습니다.");
	    	return;
	    }
        System.out.println("해당 성과 평가를 저장하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
        System.out.println(employee.savePerformanceEvaluation(employee, performance, result));
    }
	// 직원의 발령을 관리한다.
	private void assignmentManagement() throws IOException {
		System.out.println("-- 발령 정보 입력란 --");
        // 발령 정보 입력란
		System.out.print("발령할 직원 ID: "); String employeeID = dataValidation(clientInputReader.readLine().trim(), "Integer");
		System.out.print("발령날짜: "); String assignmentDate = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.print("새로운 부서: "); String assignmentLocation = dataValidation(clientInputReader.readLine().trim(), "String");
        Assignment assignment = new Assignment();
        assignment.setAssignmentDate(assignmentDate);
        assignment.setAssignmentLocation(assignmentLocation);
        if (employee == null) {
	    	System.out.println("[error] 해당 id의 직원이 존재하지 않습니다.");
	    	return;
	    }
        System.out.println("해당 발령 정보를 저장하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
        System.out.println(employee.assignmentManagement(employee, assignment, result));
	}
	// 직원의 승진을 관리한다.
	private void promotionManagement() throws IOException {
		System.out.println("-- 승진 정보 입력란 --");
		System.out.print("승진 처리할 직원 ID: "); String employeeID = dataValidation(clientInputReader.readLine().trim(), "Integer");
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(employeeID));
	    if (employee == null) {
	    	System.out.println("[error] 해당 id의 직원이 존재하지 않습니다.");
	    	return;
	    }
		System.out.print("새로운 직급: "); String position = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.println("해당 직급 정보를 저장하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
		System.out.println(employee.promotionManagement(employee, position, result));
		salaryAdjustment();
	}
	// 직원의 임금을 수정한다.
	private void salaryAdjustment() throws IOException {
		System.out.println("-- 임금 수정 정보 입력란 --");
		System.out.print("임금 수정할 직원 ID: "); String employeeID = dataValidation(clientInputReader.readLine().trim(), "Integer");
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(employeeID));
	    if (employee == null) {
	    	System.out.println("[error] 해당 id의 직원이 존재하지 않습니다.");
	    	return;
	    }
		System.out.print("새로운 임금: "); String salary = dataValidation(clientInputReader.readLine().trim(), "String");
        System.out.println("해당 임금 정보를 저장하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
		System.out.println(employee.salaryAdjustment(employee, salary, result));
	}
	// --------------------------------------------
	
	// 지급 요청에 따라 지급한다.
	private void disburseLoanAmount() throws IOException, AuthenticationException {
		if (employee==null) throw new AuthenticationException();
		int index = 1;
		ArrayList<LoanApplication> passedApplicationList = loanApplicationListImpl.retrieveByLoanStatus(Constant.loanStatus4);
		if(passedApplicationList.size() == 0) {
			System.out.println("심사통과한 대출 내역이 존재하지 않습니다.");
			return;
		}
        System.out.println("지급 요청에 따라 대출급 지급을 진행하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
        if (result.equals("N")) {
        	System.out.println("[info] 지급을 진행하지 않았습니다.");
			return;
		}
		System.out.println("-- 지급내역 --");
		for(LoanApplication loanApplication : passedApplicationList) {
			// todo -> 정보 잘 나오게 수정해야함
			System.out.println(index + ". " + " 대출신청id: "+loanApplication.getLoanApplicationID()+ " | 대출금액: "+loanApplication.getLoanAmount()+" 만큽 지급되었습니다.");
			index++;
		}
	}
	// login & signUp & logout & deleteMembership & validation
	private void login(String userType) throws IOException, NotFoundProfileException {
		System.out.println("-- 로그인 정보 입력란 --");
		if (userType.equals(Constant.Customer)) {
			System.out.print("ID: "); String ID = dataValidation(clientInputReader.readLine().trim(), "Integer");
			System.out.print("PW: "); String PW = dataValidation(clientInputReader.readLine().trim(), "String");
			for(Customer customer : customerListImpl.retrieveAll()) {
				String customerID = Integer.toString(customer.getCustomerID());
				String customerPW = customer.getCustomerPW();
				if (customerID.equals(ID) && customerPW.equals(PW)) {
					ISMain.customer = customer;
					System.out.println("[success] " + customer.getCustomerID()+"님, 환영합니다. 로그인이 완료되었습니다.");
					return;
				}
			}
			throw new NotFoundProfileException();
		} else if (userType.equals(Constant.Employee)) {
			System.out.print("ID: "); String ID = dataValidation(clientInputReader.readLine().trim(), "Integer");
			System.out.print("PW: "); String PW = dataValidation(clientInputReader.readLine().trim(), "String");
			for(Employee employee : employeeListImpl.retrieveAll()) {
				String employeeID = Integer.toString(employee.getEmployeeID());
				String employeePW = employee.getEmployeePW();
				if (employeeID.equals(ID) && employeePW.equals(PW)) {
					ISMain.employee = employee;
					System.out.println("[success] " + employee.getEmployeeID()+"님, 환영합니다. 로그인이 완료되었습니다.");
					return;
				}
			}
			throw new NotFoundProfileException();
		}
	}
	private void signUp(String userType) throws IOException, DuplicateIDException {
		if (userType.equals(Constant.Customer)) {
			System.out.println("-- 회원가입 정보 입력란 --");
			// basic attribute settings
			System.out.print("ID: "); String customerID = dataValidation(clientInputReader.readLine().trim(), "Integer");
			System.out.print("PW: "); String customerPW = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("주소: "); String address = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("자산: "); String asset = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("신용: "); String credit = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("소득: "); String income = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("직업: "); String job = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("부채: "); String liabilities = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("이름: "); String name = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("폰번호: "); String phone = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("주민등록번호: "); String ssn = dataValidation(clientInputReader.readLine().trim(), "String");
			// ListImpl Add
			Customer customer = new Customer();
			customer.setCustomerID(Integer.parseInt(customerID));
			customer.setCustomerPW(customerPW);
			customer.setAddress(address);
			customer.setAsset(asset);
			customer.setCredit(credit);
			customer.setIncome(income);
			customer.setJob(job);
			customer.setLiabilities(liabilities);
			customer.setName(name);
			customer.setPhone(phone);
			customer.setSsn(ssn);
			// association setting
			customer.setLoanApplicationList(loanApplicationListImpl);
			System.out.println(customerListImpl.add(customer));	
		} else if (userType.equals(Constant.Employee)) {
			System.out.println("-- 회원가입 정보 입력란 --");
			// basic attribute settings
			System.out.print("ID: "); String employeeID = dataValidation(clientInputReader.readLine().trim(), "Integer");
			System.out.print("PW: "); String employeePW = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("이름: "); String name = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("폰번호: "); String phone = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("성별: enter [M/W]"); String gender = dataValidation(clientInputReader.readLine().trim(), "gender");
			System.out.print("부서: "); String department = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("직급: "); String position = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("봉급: "); String salary = dataValidation(clientInputReader.readLine().trim(), "String");
			System.out.print("직원 타입: enter [ \"자산운용기획팀\" / \"자산운용심의위원회\" / \"경영기획팀\" / \"지급관리자\" \"회계담당자\" / \"인사관리자\"]");
			String type = dataValidation(clientInputReader.readLine().trim(), "type");
			// ListImpl Add
			Employee employee = new Employee();
			employee.setEmployeeID(Integer.parseInt(employeeID));
			employee.setEmployeePW(employeePW);
			employee.setName(name);
			employee.setPhone(phone);
			employee.setGender(gender);
			employee.setDepartment(department);
			employee.setPosition(position);
			employee.setSalary(salary);
			employee.setType(type);
			// association setting
			employee.setAssetManagementListImpl(assetManagementListImpl);
			employee.setBusinessStraegyListImpl(businessStraegyListImpl);
			employee.setDepositClosureDetailListImpl(depositClosureDetailListImpl);
			employee.setLoanApplicationListImpl(loanApplicationListImpl);
			employee.setLoanListImpl(loanListImpl);
			employee.setRegulationListImpl(regulationListImpl);
			System.out.println(employeeListImpl.add(employee));
		}
	}
	private void logout() {
		employee = null;
		customer = null;
		System.out.println("[success] 로그아웃 되었습니다. 본 페이지로 돌아갑니다.");
	}
	private void deleteMembership(String userType) throws IOException {
		if (employee == null && customer == null) {
			System.out.println("[error] 로그인을 먼저 진행해주세요.");
			return;
		}
		System.out.println("-- 회원탈퇴 정보 --");
		System.out.print("회원탈퇴를 진행하시겠습니까? [Y/N] : "); String result = dataValidation(clientInputReader.readLine().trim(), "boolean");
		if (result.equals("Y")) {
			if (userType.equals(Constant.Customer)) System.out.println(customerListImpl.deleteById(customer.getCustomerID()));
			else if (userType.equals(Constant.Employee)) System.out.println(employeeListImpl.deleteById(employee.getEmployeeID()));
		} else System.out.println("[error] 회원탈퇴를 진행하지 않았습니다. 본 페이지로 돌아갑니다.");
	}
	private String dataValidation(String inputData, String type) throws IOException {
	    while (true) {
	        if (isValidInput(inputData, type)) return inputData;
	        else if ("Integer".equals(type)) System.out.println("[error] you must enter only numbers.\n re-enter: ");
	        else if ("Double".equals(type)) System.out.println("[error] you must enter a decimal number.\n re-enter: ");
	        else if ("multiValue".equals(type)) System.out.println("[error] you must enter null or have only String values However, there cannot be more than two consecutive blank spaces..\n re-enter: ");
	        else if("type".equals(type)) System.out.println("[error] you must enter only \"S\" / \"UW\" / \"CI\" / \"CP\" \n re-enter: ");
	        else if("boolean".equals(type)) System.out.println("[error] you must enter only 'Y' / 'N' \n re-enter: ");
	        else if("gender".equals(type)) System.out.println("[error] you must enter only 'M' / 'W' \n re-enter: ");
	        else System.out.println("[error] You can't enter spaces or empty values. \n re-enter: ");
	        inputData = clientInputReader.readLine().trim();
	    }
	}
	private boolean isValidInput(String inputData, String type) {
			if ("multiValue".equals(type)) {
				if (inputData.replaceAll("\\s+", "").isEmpty()) return true;
				else if(inputData.matches(".*\\s{2,}.*")) return false;
			    return true;
			} else if ("Integer".equals(type)) {
				if (inputData.matches("\\d+")) return true;
	            else return false;
			} else if ("Double".equals(type)) {
			    if (inputData.matches("\\d*\\.\\d+")) return true;
			    else return false;				
		    } else if ("boolean".equals(type)) {
				if (inputData.equals("Y") || inputData.equals("N")) return true;
	            else return false;
		} else if ("type".equals(type)) {
			if (inputData.equals(Constant.AssetManagementPlanningTeam) || inputData.equals(Constant.AssetManagementReviewCommittee) || inputData.equals(Constant.BusinessPlanningTeam) || inputData.equals(Constant.PaymentManager)|| inputData.equals(Constant.AccountingManager) || inputData.equals(Constant.HRManager )) return true;
            else return false;
		} else if ("gender".equals(type)) {
			if (inputData.equals("M") || inputData.equals("W")) return true;
            else return false;
		}
		if (inputData.trim().isEmpty() || inputData.contains(" ")) return false;
	    return true;
	}
	private void setDemoData() throws DuplicateIDException {
		Customer customer = new Customer();
		customer.setCustomerID(1234);
		customer.setCustomerPW("1234");
		customer.setAddress("울산광역시 북구 호계매곡 1로");
		customer.setAsset("700000");
		customer.setCredit("상");
		customer.setIncome("0");
		customer.setJob("학생");
		customer.setLiabilities("123");
		customer.setName("euntaek");
		customer.setPhone("010-1111-1111");
		customer.setSsn("1234567-89101112");
		customer.setLoanApplicationList(loanApplicationListImpl);
		customerListImpl.add(customer);

		Employee employee = new Employee();
		employee.setEmployeeID(1234);
		employee.setEmployeePW("1234");
		employee.setName("이준규");
		employee.setPhone("010-6540-3642");
		employee.setGender("M");
		employee.setDepartment("지급관리");
		employee.setPosition("대리");
		employee.setSalary("3000000");
		employee.setType("인사관리자");
		employee.setAssetManagementListImpl(assetManagementListImpl);
		employee.setBusinessStraegyListImpl(businessStraegyListImpl);
		employee.setDepositClosureDetailListImpl(depositClosureDetailListImpl);
		employee.setLoanApplicationListImpl(loanApplicationListImpl);
		employee.setLoanListImpl(loanListImpl);
		employee.setRegulationListImpl(regulationListImpl);
		employeeListImpl.add(employee);

		Loan loan = new Loan();
		loan.setLoanID(1234);
		loan.setEmployeeID(1234);
		loan.setInterestRate("2.0");
		loan.setLoanName("청년안심대출");
		loan.setLoanTerm("5년");
		loan.setQualification("학생");
		loan.setRepaymentMethod("없음");
		loanListImpl.add(loan);

		LoanApplication loanApplication = new LoanApplication();
		loanApplication.setCustomerID(60221320);
		loanApplication.setLoanAmount("1000000000");
		loanApplication.setLoanApplicationID(1);
		loanApplication.setLoanID(1234);
		loanApplication.setLoanPurpose("학비");
		loanApplication.setLoanStatus(Constant.loanStatus1);
		loanApplication.setPaymentCompanyName("농협은행");
		loanApplicationListImpl.add(loanApplication);
	}
}