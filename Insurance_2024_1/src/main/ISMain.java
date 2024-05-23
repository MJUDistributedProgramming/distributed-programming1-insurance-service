package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import daoList.AccidentListImpl;
import daoList.CompensationListImpl;
import daoList.ContractListImpl;
import daoList.CounselListImpl;
import daoList.CustomerDBImpl;
import daoList.EmployeeListImpl;
import daoList.InsuranceListImpl;
import daoList.PaymentListImpl;
import daoList.RuleListImpl;
import domain.Accident;
import domain.Bill;
import domain.Compensation;
import domain.AutomaticPayment;
import domain.BankPayment;
import domain.CancerHealth;
import domain.Car;
import domain.CardPayment;
import domain.Contract;
import domain.Counsel;
import domain.Customer;
import domain.Employee;
import domain.Guarantee;
import domain.HouseFire;
import domain.Insurance;
import domain.InternationalTravel;
import domain.Loss;
import domain.MedicalHistory;
import domain.Payment;
import domain.PaymentInfo;
import domain.Rule;
import domain.SpecialProvision;
import token.TokenManager;
public class ISMain {
	// constants - role
	private static final String Customer = "C";
	private static final String Employee = "E";
	private static final String Sales = "S";
	private static final String UnderWriting = "UW";
	private static final String CutomerInfomationManage = "CI";
	private static final String CompensationProcessing = "CP";
	private static final String contractStatus1 = "ReviewRequest"; //심사요청상태
	private static final String contractStatus2 = "ReviewReject"; //심사거절상태
	private static final String contractStatus3 = "ContractPermission";//계약진행허가상태
	private static final String paymentInfoCard = "card";
	private static final String paymentInfoBank = "bank";
	private static final String paymentInfoAutomatic = "automatic";

	// main attributes
	private static String token;
	private static AccidentListImpl accidentListImpl;
	private static CompensationListImpl compensationListImpl;
	private static ContractListImpl contractListImpl;
	private static CounselListImpl counselListImpl;
	private static CustomerDBImpl customerDBImpl;
	private static EmployeeListImpl employeeListImpl;
	private static InsuranceListImpl insuranceListImpl;
	private static PaymentListImpl paymentListImpl;
	private static RuleListImpl ruleListImpl;
	public static void main(String[] args) throws IOException {
		// ListImpl Settings
		accidentListImpl = new AccidentListImpl();
		compensationListImpl = new CompensationListImpl();
		contractListImpl = new ContractListImpl();
		counselListImpl = new CounselListImpl();
		customerDBImpl = new CustomerDBImpl();
		employeeListImpl = new EmployeeListImpl();
		insuranceListImpl = new InsuranceListImpl();
		paymentListImpl = new PaymentListImpl();
		ruleListImpl = new RuleListImpl();
		// main Settings
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		startInsuranceService(inputReader);
	}
	private static void printMainMenu() {
		System.out.println("***************** Main Menu *****************");
		System.out.println("1. CustomerService");
		System.out.println("2. EmployeeService");
		System.out.println("X. Exit");
	}
	
	private static void startInsuranceService(BufferedReader clientInputReader) throws IOException{
		while(true) {
			printMainMenu();
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) startCustomerService(clientInputReader);
			else if (clientChoice.equals("2")) startEmployeeService(clientInputReader);
			else if (clientChoice.equals("X")) {
				System.out.println("|*** Thank you for using the this Insurance program! ***|");
				System.exit(0);
			}
			else System.out.println("invalid choice");
		}
	}
	private static void printCustomerMainMenu() {
		System.out.println("***************** Main Menu *****************");
		System.out.println("1. Login");
		System.out.println("2. SignUp");
		System.out.println("3. List Accident");
		System.out.println("4. List Compensation");
		System.out.println("5. List Counsel");
		System.out.println("6. List Payment");
		System.out.println("7. Create Accident");
		System.out.println("8. Delete Accident");
		System.out.println("9. Create Compensation");
		System.out.println("10. Delete Compensation");
		System.out.println("11. Create Counsel");
		System.out.println("12. Delete Counsel");
//		System.out.println("13. Create Payment");
//		System.out.println("14. Delete Payment");
		System.out.println("13. Logout");
		System.out.println("14. Delete Membership");
		System.out.println("R. Return HomePage");
	}
	private static void startCustomerService(BufferedReader clientInputReader) throws IOException{
		while(true) {
			printCustomerMainMenu();
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) login(Customer , clientInputReader);
			else if (clientChoice.equals("2")) signUp(Customer , clientInputReader);
			else if (clientChoice.equals("3")) showAccidentList();
			else if (clientChoice.equals("4")) showCompensationList();
			else if (clientChoice.equals("5")) showCounselList();
			else if (clientChoice.equals("6")) showPaymentList();
			else if (clientChoice.equals("7")) createAccident(clientInputReader);
			else if (clientChoice.equals("8")) deleteAccident(clientInputReader);
			else if (clientChoice.equals("9")) createCompensation(Customer, clientInputReader);
			else if (clientChoice.equals("10")) deleteCompensation(clientInputReader);
			else if (clientChoice.equals("11")) createCounsel(Customer, clientInputReader);
			else if (clientChoice.equals("12")) deleteCounsel(clientInputReader);
			else if (clientChoice.equals("13")) createPayment(clientInputReader);
			else if (clientChoice.equals("14")) deletePayment(clientInputReader);
			else if (clientChoice.equals("13")) logout();
			else if (clientChoice.equals("14")) deleteMembership(Customer , clientInputReader);
			else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to HomePage ***|");
				return;
			}
			else System.out.println("invalid choice");
		}
	}
	private static void showAccidentList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		ArrayList<Accident> accidentList = accidentListImpl.retrieveByCustomerID(Integer.parseInt(TokenManager.getID(token)));
		int index = 1;
		
		if(accidentList.size() == 0) {
			System.out.println("No Accident");
			return;
		}
		
		System.out.println("-- Your Accident List --");
		for(Accident accident : accidentList) {
			System.out.println(index + ". AccidentID: " + accident.getAccidentID() + " CustomerID: " + accident.getCustomerID()+ " Accident Date: " + accident.getAccidentDate() + " Accident Location: " + accident.getAccidentLocation() + " Accident Type: " + accident.getAccidentType() + " Car Info: " + accident.getCarInformation() + " Car Num: " + accident.getCarNumber());
			index++;
		}
	}
	private static void showPaymentList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		ArrayList<Payment> paymentList = paymentListImpl.retrieveByCustomerID(Integer.parseInt(TokenManager.getID(token)));
		int index = 1;
		System.out.println("-- Your Payment List --");
		for(Payment payment : paymentList) {
			System.out.println(index + ". CounselID: " + payment.getPaymentID() + " ContractID: " + payment.getContractID()+ " CustomerID: " + payment.getCustomerID()+" Status: "+payment.isPaymentProcessed());
			index++;
		}
	}
	private static void createAccident(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("-- Accident Information--");
		// basic attribute settings
		System.out.print("AccidentID: "); String accidentID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("Accident Date: "); String accidentDate = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("Accident Location: "); String accidentLocation = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("Accident Type: "); String accidentType = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("Car Information: "); String carInfomation = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("Car Number: "); String carNumber = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		
		// AccidentImpl Add
		Accident accident = new Accident();
		accident.setAccidentID(Integer.parseInt(accidentID));
		accident.setCustomerID(Integer.parseInt(TokenManager.getID(token)));
		accident.setAccidentDate((accidentDate));
		accident.setAccidentLocation(accidentLocation);
		accident.setAccidentType(accidentType);
		accident.setCarInformation(carInfomation);
		accident.setCarNumber(Integer.parseInt(carNumber));
		accidentListImpl.add(accident);
		
	}
	private static void deleteAccident(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("--Delete Accident Infomation--");
		System.out.print("Accident ID: "); String accidentID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		accidentListImpl.delete(Integer.parseInt(accidentID));		
	}
	private static void createPayment(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println("--Create Payment Infomation--");
		
		// basic attribute settings
		System.out.print("Payment ID: "); String paymentID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("ContractID: "); String contractID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		Contract contract = contractListImpl.retrieve(Integer.parseInt(contractID));
		if (contract == null) {
			System.out.println("[error] A contract for that ID does not exist.");
			return;
		}
		int customerID = contract.getCustomerID();
		int amount = contract.getMonthlyPremium();
		System.out.println("Due Date of Payment: "); String dueDateOfPayment = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		boolean statusOfPayment = false;

		// ListImpl Add
		Payment payment = new Payment();
		payment.setPaymentID(Integer.parseInt(paymentID));
		payment.setContractID(Integer.parseInt(contractID));
		payment.setCustomerID(customerID);
		payment.setAmount(amount);
		payment.setDueDateOfPayment(dueDateOfPayment);
		payment.setStatusOfPayment(statusOfPayment);
		paymentListImpl.add(payment);
	}
	private static void deletePayment(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println("--Delete Payment Infomation--");
		System.out.print("payment ID: "); String paymentID = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		paymentListImpl.delete(Integer.parseInt(paymentID));
		
	}
	private static void printEmployeeMainMenu() {
		System.out.println("***************** Main Menu *****************");
		System.out.println("1. Login");
		System.out.println("2. SignUp");
		System.out.println("3. List Customers");
		System.out.println("4. List Employee");
		System.out.println("5. List Contract");
		System.out.println("6. List Payment");
		System.out.println("7. List Insurance");
		System.out.println("8. List Compensation");
		System.out.println("9. List Counsel");
		System.out.println("10. List Rule");
		System.out.println("11. Create Contract");
		System.out.println("12. Delete Contract");
		System.out.println("13. Create Insurance");
		System.out.println("14. Delete Insurance");
		System.out.println("15. Create Compensation");
		System.out.println("16. Delete Compensation");
		System.out.println("17. Create Counsel");
		System.out.println("18. Delete Counsel");
		System.out.println("19. Create Rule");
		System.out.println("20. Delete Rule");
		System.out.println("21, Create Payment");
		System.out.println("22. Delete Payment");
		System.out.println("23. Logout");
		System.out.println("24. Delete Membership");
		System.out.println("X. R. Return HomePage");
	}
	private static void startEmployeeService(BufferedReader clientInputReader) throws IOException{
		while(true) {
			printEmployeeMainMenu();
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) login(Employee , clientInputReader);
			else if (clientChoice.equals("2")) signUp(Employee , clientInputReader);
			else if (clientChoice.equals("3")) showCustomerList();
			else if (clientChoice.equals("4")) showEmployeeList();
			else if (clientChoice.equals("5")) showContractList();
			else if (clientChoice.equals("6")) showPaymentList();
			else if (clientChoice.equals("7")) showInsuranceList();
			else if (clientChoice.equals("8")) showAllCompensationList();
			else if (clientChoice.equals("9")) showAllCounselList();
			else if (clientChoice.equals("10")) showRuleList();
			else if (clientChoice.equals("11")) createContract(clientInputReader);
			else if (clientChoice.equals("12")) deleteContract(clientInputReader);
			else if (clientChoice.equals("13")) createInsurance(clientInputReader);
			else if (clientChoice.equals("14")) deleteInsurance(clientInputReader);
			else if (clientChoice.equals("15")) createCompensation(Employee, clientInputReader);
			else if (clientChoice.equals("16")) deleteCompensation(clientInputReader);
			else if (clientChoice.equals("17")) createCounsel(Employee, clientInputReader);
			else if (clientChoice.equals("18")) deleteCounsel(clientInputReader);
			else if (clientChoice.equals("19")) createRule(clientInputReader);
			else if (clientChoice.equals("20")) deleteRule(clientInputReader);
			else if (clientChoice.equals("21")) createPayment(clientInputReader);
			else if (clientChoice.equals("22")) deletePayment(clientInputReader);
			else if (clientChoice.equals("23")) logout();
			else if (clientChoice.equals("24")) deleteMembership(Employee , clientInputReader);
			else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to HomePage ***|");
				return;
			}
			else System.out.println("invalid choice");
		}
	}
	private static void showCustomerList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		String role = TokenManager.getRole(token);
		int index = 1;
		if (role.equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println("-- Customer List --");
		for(Customer customer : customerDBImpl.retrieveAll()) {
			System.out.println(index + ". ID: " + customer.getCustomerID() + " Name: " + customer.getName());
			index++;
		}
	}
	private static void showEmployeeList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		String role = TokenManager.getRole(token);
		int index = 1;
		if (role.equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println("-- Employee List --");
		for(Employee employee : employeeListImpl.retrieveAll()) {
			System.out.println(index + ". ID: " + employee.getEmployeeID() + " Name: " + employee.getName());
			index++;
		}
	}
	private static void showContractList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		String role = TokenManager.getRole(token);
		int index = 1;
		if (role.equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println();
		System.out.println("-- Contract List --");
		for(Contract contract : contractListImpl.retrieveAll()) {
			System.out.println(index + ". ContractID: " + contract.getContractID() + " InsuranceID: " + contract.getInsuranceID()+ " CustomerID: " + contract.getCustomerID());
			index++;
		}
	}
	private static void showRuleList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		String role = TokenManager.getRole(token);
		int index = 1;
		if (role.equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println();
		System.out.println("-- Contract List --");
		for(Rule rule : ruleListImpl.retrieveAll()) {
			System.out.println(index + ". RuleID: " + rule.getRuleID() + " RuleName: " + rule.getRuleName()+ " RuleDetail: " + rule.getRuleDetail());
			index++;
		}
		
	}
	private static void showCounselList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		// int customerID = Integer.parseInt(TokenManager.getID(token));
		// Counsel counsel = counselListImpl.retrieve(customerID);
		ArrayList<Counsel> counselList = counselListImpl.retrieveByCustomerID(Integer.parseInt(TokenManager.getID(token)));
		int index = 1;
		System.out.println("-- Your Counsel List --");
		for(Counsel counsel : counselList) {
			System.out.println(index + ". CounselID: " + counsel.getCounselID() + " CustomerID: " + counsel.getCustomerID()+ " Status: " + counsel.isConfirmedCounsel());
			index++;
		}
	}
	private static void showAllCounselList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		String role = TokenManager.getRole(token);
		int index = 1;
		if (role.equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println();
		ArrayList<Counsel> counselList = counselListImpl.retrieveAll();
		if(counselList.size() == 0) {
			System.out.println("No counsel");
			return;
		}
		System.out.println("-- Counsel List --");
		for(Counsel counsel : counselListImpl.retrieveAll()) {
			System.out.println(index + ". CounselID: " + counsel.getCounselID() + " CustomerID: " + counsel.getCustomerID()+ " Status: " + counsel.isConfirmedCounsel());
			index++;
		}
	}
	private static void showCompensationList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		ArrayList<Compensation> compensationList = compensationListImpl.retrieveByCustomerID(Integer.parseInt(TokenManager.getID(token)));
		int index = 1;
		
		if(compensationList.size() == 0) {
			System.out.println("No Compensation");
			return;
		}
		
		System.out.println("-- Your Compensation List --");
		for(Compensation compensation : compensationList) {
			System.out.println(index + ". CompensationID: " + compensation.getCompensationID() + " CustomerID: " + compensation.getCustomerID()+ " ContractID: " + compensation.getContractID() + " Insurance Amount: " + compensation.getInsuranceAmount() + " LossID: " + compensation.getLoss().getLossID() + " AccidentID: " + compensation.getLoss().getAccidentID() + " EmployeeID : " + compensation.getLoss().getEmployeeID() + " Employee Opinion: " + compensation.getLoss().getEmployeeOpinion() + " Loss Amount: " + compensation.getLoss().getLossAmount() + " BillID: " + compensation.getBill().getBillID() + " Bill Reason: " + compensation.getBill().getBillReason());
			index++;
		}
	}
	private static void showAllCompensationList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		
		String role = TokenManager.getRole(token);
		if (role.equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		
		int index = 1;
		System.out.println();
		ArrayList<Compensation> compensationList = compensationListImpl.retrieveAll();
		if(compensationList.size() == 0) {
			System.out.println("No Compensation");
			return;
		}
		System.out.println("-- Compensation List --");
		for(Compensation compensation : compensationList) {
			System.out.println(index + ". CompensationID: " + compensation.getCompensationID() + " CustomerID: " + compensation.getCustomerID() + " ContractID: " + compensation.getContractID() + " Insurance Amount: " + compensation.getInsuranceAmount() + " LossID: " + compensation.getLoss().getLossID() + " AccidentID: " + compensation.getLoss().getAccidentID() + " EmployeeID : " + compensation.getLoss().getEmployeeID() + " Employee Opinion: " + compensation.getLoss().getEmployeeOpinion() + " Loss Amount: " + compensation.getLoss().getLossAmount() + " BillID: " + compensation.getBill().getBillID() + " Bill Reason: " + compensation.getBill().getBillReason());
			index++;
		}
		
	}
	private static void showInsuranceList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		int index = 1;
		System.out.println();
		ArrayList<Insurance> insuranceList = insuranceListImpl.retrieveAll();
		if(insuranceList.size() == 0) {
			System.out.println("No Insurance");
			return;
		}
		System.out.println("-- Insurance List --");
		for(Insurance insurance: insuranceList) {
			System.out.println(index + ". InsuranceID: " + insurance.getInsuranceID() + " Name: " + insurance.getInsuranceName() + " Category: "+insurance.getCategory());
			index++;
		}
	}
	private static void createContract(BufferedReader clientInputReader) throws IOException {
//		private int concludeEID; 계약한 직원 ID -> 초기널값임
//		private int contractDate; 계역 날짜 -> 초기 널값임 
//		private int contractID; 계약 ID
//		private String contractStatus; 계약상태 [심사요청, 심사거절, 계약허가]
//		private int customerID; 
//		private String evaluation; 평가결과 -> 초기 널값임
//		private String expirationDate; 만료일자
//		private int insuranceID;
//		private boolean isConclude; 계약되었는지.. -> 초기 false
//		private boolean isPassUW; 인수심사 완료 되었는지... -> 초기 false
//		private int monthlyPremium; 월보험료
//		private int nonPaymentPeriod; 미납기간 -> 조기 널값임
		//
//		private PaymentInfo paymentInfo; => 서현누나가 구현 필요
//		private boolean renewalStatus; 재계약여부 -> 초기 널값임
//		private String resurrectionDate; 부활날짜 -> 초기 널값임
//		private String resurrectionReason; 부활사유 -> 초기 널값임
//		private int underwritingEID; 인수심사한 직원 ID -> 초기 널값임
		
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		
		System.out.println("--Create Contract Infomation--");
		
		// basic attribute settings
		System.out.print("contractID: "); String contractID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		String contractStatus = contractStatus1;
		System.out.print("customerID: "); String customerID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("expirationDate: "); String expirationDate = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("insuranceID: "); String insuranceID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		boolean isConclude = false;
		boolean isPassUW = false;
		System.out.print("monthlyPremium: "); String monthlyPremium = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);


		
		// composition to whole settings
		PaymentInfo paymentInfo = new PaymentInfo();
		System.out.println("--Payment Information--");
		System.out.print("PaymentInfo ID: "); String paymentInfoID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("fixedMonthlyPayment : "); String fixedMonthlyPayment = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("fixedMonthlyPaymentDate: "); String fixedMonthlyPaymentDate = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("PaymentType: "); String paymentType = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);

		paymentInfo.setPaymentInfoID(Integer.parseInt(paymentInfoID));
		paymentInfo.setFixedMonthlyPayment(Integer.parseInt(fixedMonthlyPayment));
		paymentInfo.setFixedMonthlyPaymentDate(fixedMonthlyPaymentDate);
		paymentInfo.setPaymentType(paymentType);
		
		if(paymentType.equals(paymentInfoCard)) {
			System.out.println("--Payment Card Information--");
			System.out.print("cardNum: ");String cardNum= dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("cvcNum: ");String cvcNum= dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("password: ");String password= dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			
			CardPayment cardPayment = new CardPayment();
			cardPayment.setCardNum(cardNum);
			cardPayment.setCvcNum(cvcNum);
			cardPayment.setPassword(password);
		}else if(paymentType.equals(paymentInfoBank)) {
			System.out.println("--Payment Bank Information--");
			System.out.print("payerName: ");String payerName= dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);;
			System.out.print("payerPhoneNum: ");String payerPhoneNum= dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			BankPayment bankPayment = new BankPayment();
			bankPayment.setPayerName(payerName);
			bankPayment.setPayerPhoneNum(payerPhoneNum);
			
		}else if(paymentType.equals(paymentInfoAutomatic)) {
			System.out.println("--Payment Automatic Information--");
			System.out.print("accountNum: ");String accountNum = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("applicantName: ");String applicantName = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("applicantRRN: ");String applicantRRN = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("paymentCompanyName: ");String paymentCompanyName = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("relationshipToApplicant: ");String relationshipToApplicant = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			AutomaticPayment automaticPayment = new AutomaticPayment();
			automaticPayment.setAccountNum(accountNum);
			automaticPayment.setApplicantName(applicantName);
			automaticPayment.setApplicantRRN(applicantRRN);
			automaticPayment.setPaymentCompanyName(paymentCompanyName);
			automaticPayment.setRelationshipToApplicant(relationshipToApplicant);
		}
		
		// ListImpl Add
		Contract contract = new Contract();
		contract.setContractID(Integer.parseInt(contractID));
		contract.setContractStatus(contractStatus);
		contract.setCustomerID(Integer.parseInt(customerID));
		contract.setExpirationDate(expirationDate);
		contract.setInsuranceID(Integer.parseInt(insuranceID));
		contract.setConclude(isConclude);
		contract.setPassUW(isPassUW);
		contract.setMonthlyPremium(Integer.parseInt(monthlyPremium));
		contractListImpl.add(contract);
	}
	private static void deleteContract(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println("--Delete Contract Infomation--");
		System.out.print("contractID: "); String contractID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		contractListImpl.delete(Integer.parseInt(contractID));
	}
	private static void createRule(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println("--Create Rule Infomation--");
		System.out.print("ruleID: "); 
		String ruleID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);	
		System.out.print("ruleName: "); 
		String ruleName =dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("ruleDetail: "); 
		String ruleDetail = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		
		Rule rule = new Rule();
		rule.setRuleID(Integer.parseInt(ruleID));
		rule.setRuleName(ruleName);
		rule.setRuleDetail(ruleDetail);
		ruleListImpl.add(rule);
	}
	private static void deleteRule(BufferedReader clientInputReader) throws IOException {
		System.out.print("ruleID: "); 
		String ruleID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);	

		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		
		ruleListImpl.delete(Integer.parseInt(ruleID));
	}
	private static void createCounsel(String usertype, BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("-- Counsel Information--");
		// basic attribute settings
		System.out.print("CounselID: "); String counselID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("InsuranceCategory: 1. 자동차  2. 생활  3. 건강  4. 여행"); String insuranceCategory = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("Date of Counsel: "); String dateOfCounsel = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("Time of Counsel: "); String timeOfCOunsel = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		boolean statusOfCounsel = false;
		
		// ListImpl Add
		Counsel counsel = new Counsel();
		counsel.setCounselID(Integer.parseInt(counselID));
		counsel.setCustomerID(Integer.parseInt(TokenManager.getID(token)));
		counsel.setInsuranceCategory(Integer.parseInt(insuranceCategory));
		counsel.setDateOfCounsel(dateOfCounsel);
		counsel.setTimeOfCounsel(timeOfCOunsel);
		counsel.setStatusOfCounsel(statusOfCounsel);
		counselListImpl.add(counsel);
	}
	private static void deleteCounsel(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("--Delete Counsel Infomation--");
		System.out.print("Counsel ID: "); String counselID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		counselListImpl.delete(Integer.parseInt(counselID));
		
	}
	private static void createCompensation(String usertype, BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		
		System.out.println("--Create Compensation Infomation--");
		// basic attribute settings
		System.out.print("CompensationID: "); String compensationID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("ContractID: "); String contractID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("CustomerID: "); String customerID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("Insurance Amount: "); String insuranceAmount = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);

		// composition to whole settings
		System.out.println("--Bill Information--");
		System.out.print("BillID: "); String billID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("Bill Reason: "); String billReason = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		
		Bill bill = new Bill();
		bill.setBillID(Integer.parseInt(billID));
		bill.setBillReason(billReason);
		
		// Loss setting - 손해조사하기 전
		Loss loss = new Loss();
		loss.setLossID(0);
		loss.setAccidentID(0);
		loss.setEmployeeID(0);
		loss.setEmployeeOpinion(null);
		loss.setLossAmount(0);

		// ListImpl Add
		Compensation compensation = new Compensation();
		compensation.setCompensationID(Integer.parseInt(compensationID));
		compensation.setContractID(Integer.parseInt(contractID));
		compensation.setCustomerID(Integer.parseInt(TokenManager.getID(token)));
		compensation.setInsuranceAmount(Integer.parseInt(insuranceAmount));
		
		// composition to whole settings
		compensation.setBill(bill);
		compensation.setLoss(loss);
		
		compensationListImpl.add(compensation);		
	}
	private static void deleteCompensation(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println("--Delete Compensation Infomation--");
		System.out.print("CompensationID: "); String compensationID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		compensationListImpl.delete(Integer.parseInt(compensationID));
				
	}
	private static void createInsurance(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println("InsuranceCategory: 1. 자동차  2. 주택화재  3. 암건강  4. 해외여행"); 
		String insuranceCategory = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		
		System.out.println("--Create Insurance Infomation--");
		// basic attribute settings
		System.out.print("Insurance ID: "); String insuranceID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("Insurance Name: "); String insuranceName = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("category: "); String category = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("Minimum Period: "); String minimumPeriod = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("Minimum Premium: "); String minimumPremium = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("Process of Compensation: "); String processOfCompensation = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("Process of Subscription: "); String processOfSubscription = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("Insurance Rate: "); String insuranceRate = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("Notice: "); String notice = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		
		// composition to whole settings

		Guarantee guarantee = new Guarantee();
		System.out.println("--Guarantee Information--");
		System.out.print("Guarantee Name: "); String guaranteeName = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("Description: "); String guranteeDescription = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("Max Converage: "); String maxCoverage = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		guarantee.setGuaranteeName(guaranteeName);
		guarantee.setDescription(guranteeDescription);
		guarantee.setMaxCoverage(Integer.parseInt(maxCoverage));
		
		SpecialProvision specialProvision = new SpecialProvision();
		System.out.println("--Special Provision Information--");
		System.out.print("Special Provision Name: "); String specialProvisionName = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("Description: "); String provisionDescription = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("Rate of Discount: "); String rateOfDiscount  = dataValidation(clientInputReader.readLine().trim(), "Double", clientInputReader);
		specialProvision.setSpecialProvisionName(specialProvisionName);
		specialProvision.setDescription(provisionDescription);
		specialProvision.setRateOfDiscount(Double.parseDouble(rateOfDiscount));
		
		Insurance insurance = null;
		if(insuranceCategory.equals("1")) {
			insurance = new Car();
			System.out.println("--Car Insurance Information--");
			System.out.print("Model: "); String model = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Price: "); String carPrice = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			System.out.print("VIN: "); String VIN = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Black box: enter [Y/N]"); String blackbox = dataValidation(clientInputReader.readLine().trim(), "boolean", clientInputReader);
			((Car) insurance).setModel(model);
			((Car) insurance).setPriceOfCar(Integer.parseInt(carPrice));
			((Car) insurance).setVIN(VIN);
			if(blackbox.equals("Y")) ((Car) insurance).setHasBlackbox(true);
			else if(blackbox.equals("N")) ((Car) insurance).setHasBlackbox(false);
			
		}else if(insuranceCategory.equals("2")) {
			insurance = new HouseFire();
			System.out.println("--HouseFire Insurance Information--");
			System.out.print("Category of House: "); String categoryOfHouse = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Price: "); String housePrice = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			((HouseFire) insurance).setCategoryOfHouse(categoryOfHouse);
			((HouseFire) insurance).setPriceOfHouse(Integer.parseInt(housePrice));
			
		}else if(insuranceCategory.equals("3")) {
			insurance = new CancerHealth();
			System.out.println("--CancerHealth Insurance Information--");
			System.out.print("Category of Cancer: "); String categoryOfCancer = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			((CancerHealth) insurance).setCategoryOfCancer(categoryOfCancer);
			
		}else if(insuranceCategory.equals("4")) {
			insurance = new InternationalTravel();
			System.out.println("--InternationalTravel Insurance Information--");
			System.out.print("Country to travel: "); String travelCountry = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Travel Period: "); String travelPeriod = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			((InternationalTravel) insurance).setTravelCountry(travelCountry);
			((InternationalTravel) insurance).setTravelPeriod(Integer.parseInt(travelPeriod));
		}
		
		// ListImpl Add
		insurance.setInsuranceID(Integer.parseInt(insuranceID));
		insurance.setInsuranceName(insuranceName);
		insurance.setCategory(category);
		insurance.setMinimumPeriod(Integer.parseInt(minimumPeriod));
		insurance.setMinimumPremium(Integer.parseInt(minimumPremium));
		insurance.setProcessOfCompoensation(processOfCompensation);
		insurance.setProcessOfSubscription(processOfSubscription);
		insurance.setInsuranceRate(Integer.parseInt(insuranceRate));
		insurance.setNotice(notice);
		
		// composition to whole settings
		insurance.setGuarantee(guarantee);
		insurance.setSpecialProvision(specialProvision);
		
		insuranceListImpl.add(insurance);
	}
	private static void deleteInsurance(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println("--Delete Insurance Infomation--");
		System.out.print("Insurance ID: "); String insuranceID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		insuranceListImpl.delete(Integer.parseInt(insuranceID));
		
	}
	private static void login(String userType, BufferedReader clientInputReader) throws IOException {
		System.out.println("--Login Infomation--");
		if (userType.equals(Customer)) {
			System.out.print("ID: "); String ID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			System.out.print("PW: "); String PW = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			for(Customer customer : customerDBImpl.retrieveAll()) {
				String customerID = Integer.toString(customer.getCustomerID());
				String customerPW = customer.getCustomerPW();
				if (customerID.equals(ID) && customerPW.equals(PW)) {
					token = TokenManager.createToken(ID, Customer);
					System.out.println("[success] " + TokenManager.getID(token)+", Welcome - Login successfully");
					return;
				}
			}
			System.out.println("[error] ID or PW is incorrect. \n please retry..");
			return;
		} else if (userType.equals(Employee)) {
			System.out.print("ID: "); String ID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			System.out.print("PW: "); String PW = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			for(Employee employee : employeeListImpl.retrieveAll()) {
				String employeeID = Integer.toString(employee.getEmployeeID());
				String employeePW = employee.getEmployeePW();
				if (employeeID.equals(ID) && employeePW.equals(PW)) {
					token = TokenManager.createToken(ID, employee.getType());
					System.out.println("[success] " + TokenManager.getID(token)+", Welcome - Login successfully");
					return;
				}
			}
			System.out.println("[error] ID or PW is incorrect. \n please retry..");
			return;
		}
	}
	private static void signUp(String userType, BufferedReader clientInputReader) throws IOException {
		if (userType.equals(Customer)) {
			System.out.println("--SignUp Infomation--");
			
			// basic attribute settings
			System.out.print("Name: "); String name = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("ID: "); String customerID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			System.out.print("PW: "); String customerPW = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Account: "); String account = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Address: "); String address = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Age: "); String age = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			System.out.print("BirthDate: "); String birthDate = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Email: "); String email = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Gender: enter [M/W]"); String gender = dataValidation(clientInputReader.readLine().trim(), "gender", clientInputReader);
			System.out.print("Height: "); String height = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			System.out.print("Job: "); String job = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Phone: "); String phone = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Weight: "); String weight = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			
			// composition to whole settings
			// MedicalHistorys
			MedicalHistory medicalHistory = new MedicalHistory();
			ArrayList<String> diseases = new ArrayList<>();
			System.out.print("CurePeriod: "); String curePeriod = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("IsCured: enter [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean", clientInputReader);
			boolean isCured;
			if (result.equals("Y")) isCured = true;
			else isCured = false;
			System.out.print("Diseases: "); String diseasesString = dataValidation(clientInputReader.readLine().trim(), "multiValue", clientInputReader);
			String[] diseasesStrings = diseasesString.split(" ");
			for (String disease : diseasesStrings) {
				diseases.add(disease);
			}
			medicalHistory.setCured(isCured);
			medicalHistory.setCurePeriod(curePeriod);
			medicalHistory.setDiseases(diseases);
			
			// ListImpl Add
			Customer customer = new Customer();
			customer.setAccount(account);
			customer.setAddress(address);
			customer.setAge(Integer.parseInt(age));
			customer.setBirthDate(birthDate);
			customer.setCustomerID(Integer.parseInt(customerID));
			customer.setCustomerPW(customerPW);
			customer.setEmail(email);
			customer.setGender(gender);
			customer.setHeight(Integer.parseInt(height));
			customer.setJob(job);
			customer.setMedicalHistory(medicalHistory);
			customer.setName(name);
			customer.setPhone(phone);
			customer.setWeight(Integer.parseInt(weight));
			customerDBImpl.add(customer);			
		} else if (userType.equals(Employee)) {
			System.out.println("--SignUp Infomation--");

			// basic attribute settings
			System.out.print("Name: "); String name = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("ID: "); String employeeID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			System.out.print("PW: "); String employeePW = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Phone: "); String phone = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Email: "); String email = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("Gender: enter [M/W]"); String gender = dataValidation(clientInputReader.readLine().trim(), "gender", clientInputReader);
			System.out.print("type: enter [ \"S\" / \"UW\" / \"CI\" / \"CP\" ]");
			System.out.print("S = Sales, UW = UnderWriting, CI = CutomerInfomationManage, CP = CompensationProcessing");
			String type = dataValidation(clientInputReader.readLine().trim(), "type", clientInputReader);
			
			// ListImpl Add
			Employee employee = new Employee();
			employee.setName(name);
			employee.setEmployeeID(Integer.parseInt(employeeID));
			employee.setEmployeePW(employeePW);
			employee.setPhone(phone);
			employee.setEmail(email);
			employee.setGender(gender);
			employee.setType(type);
			employeeListImpl.add(employee);
		}
	}
	private static void logout() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		TokenManager.invalidateToken(token);
		System.out.println("[success] logout successfully!");
		
	}
	private static void deleteMembership(String userType, BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("--deleteMembership Infomation--");
		System.out.print("Do you want to delete your membership? [Y/N] : "); String result = dataValidation(clientInputReader.readLine().trim(), "boolean", clientInputReader);
		if (result.equals("Y")) {
			if (userType.equals(Customer)) customerDBImpl.delete(Integer.parseInt(TokenManager.getID(token)));
			else if (userType.equals(Employee)) employeeListImpl.delete(Integer.parseInt(TokenManager.getID(token)));
			TokenManager.invalidateToken(token);
		} else System.out.println("[error] you enter 'N', return to homePage");
	}
	private static String dataValidation(String inputData, String type, BufferedReader clientInputReader) throws IOException {
	    while (true) {
	        if (isValidInput(inputData, type)) return inputData;
	        else if ("Integer".equals(type)) System.out.println("[error] you must enter only numbers.\n re-enter: ");
	        else if ("Double".equals(type)) System.out.println("[error] you must enter a decimal number.\n re-enter: ");
	        else if ("multiValue".equals(type)) System.out.println("[error] you must enter null or have only String values However, there cannot be more than two consecutive blank spaces..\n re-enter: ");
	        else if("boolean".equals(type)) System.out.println("[error] you must enter only \"S\" / \"UW\" / \"CI\" / \"CP\" \n re-enter: ");
	        else if("type".equals(type)) System.out.println("[error] you must enter only 'Y' / 'N' \n re-enter: ");
	        else if("gender".equals(type)) System.out.println("[error] you must enter only 'M' / 'W' \n re-enter: ");
	        else System.out.println("[error] You can't enter spaces or empty values. \n re-enter: ");
	        inputData = clientInputReader.readLine().trim();
	    }
	}
	private static boolean isValidInput(String inputData, String type) {
			if ("multiValue".equals(type)) {
				if (inputData.replaceAll("\\s+", "").isEmpty()) return true;
				else if(inputData.matches(".*\\s{2,}.*")) return false;
				ArrayList<String> prerequisiteList = new ArrayList<>(Arrays.asList(inputData.split("\\s+")));
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
			if (inputData.equals(Sales) || inputData.equals(UnderWriting) || inputData.equals(CutomerInfomationManage) || inputData.equals(CompensationProcessing)) return true;
            else return false;
		} else if ("gender".equals(type)) {
			if (inputData.equals("M") || inputData.equals("W")) return true;
            else return false;
		}
		if (inputData.trim().isEmpty() || inputData.contains(" ")) return false;
	    return true;
	}
}