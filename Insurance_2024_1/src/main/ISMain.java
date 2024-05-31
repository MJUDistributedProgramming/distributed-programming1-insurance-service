package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import IF.ContractList;
import IF.CounselList;
import IF.CustomerList;
import IF.EmployeeList;
import IF.PaymentList;
import IF.RuleList;
import constant.Constant;
import IF.InsuranceList;
import IF.AccidentList;
import IF.CompensationList;
import daoList.AccidentListImpl;
import daoList.CompensationListImpl;
import daoList.ContractListImpl;
import daoList.CounselListImpl;
import daoList.CustomerListImpl;
import daoList.EmployeeListImpl;
import daoList.InsuranceListImpl;
import daoList.PaymentListImpl;
import daoList.RuleListImpl;
import domain.Accident;
import domain.AutomaticPayment;
import domain.BankPayment;
import domain.Bill;
import domain.CancerHealth;
import domain.Car;
import domain.CardPayment;
import domain.Compensation;
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
	// main attributes
	private static String token;
	private static AccidentList accidentListImpl;
	private static CompensationList compensationListImpl;
	private static ContractList contractListImpl;
	private static CounselList counselListImpl;
	private static CustomerList customerListImpl;
	private static EmployeeList employeeListImpl;
	private static InsuranceList insuranceListImpl;
	private static PaymentList paymentListImpl;
	private static RuleList ruleListImpl;
	public static void main(String[] args) throws IOException {
		// ListImpl Settings
		accidentListImpl = new AccidentListImpl();
		compensationListImpl = new CompensationListImpl();
		contractListImpl = new ContractListImpl();
		counselListImpl = new CounselListImpl();
		customerListImpl = new CustomerListImpl();
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
		System.out.println("***************** Customer Main Menu *****************");
		System.out.println("1. Login");
		System.out.println("2. SignUp");
		System.out.println("3. List Insurance");
		System.out.println("4. List Accident");
		System.out.println("5. List Compensation");
		System.out.println("6. List Counsel");
		System.out.println("7. List Payment");
		System.out.println("8. Create Accident");
		System.out.println("9. Delete Accident");
		System.out.println("10. Create Compensation");
		System.out.println("11. Delete Compensation");
		System.out.println("12. Create Counsel");
		System.out.println("13. Delete Counsel");
		System.out.println("14. Logout");
		System.out.println("15. Delete Membership");
		//
		System.out.println("16. 상담 신청 카테고리");
		System.out.println("17. 보험 상품 종류 카테고리");
		System.out.println("18. 보유 계약 조회 카테고리");
		System.out.println("19. 보험료 납부 카테고리");
		System.out.println("R. Return HomePage");
	}
	private static void startCustomerService(BufferedReader clientInputReader) throws IOException{
		while(true) {
			printCustomerMainMenu();
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) login(Constant.Customer , clientInputReader);
			else if (clientChoice.equals("2")) signUp(Constant.Customer , clientInputReader);
			else if (clientChoice.equals("3")) showInsuranceList();
			else if (clientChoice.equals("4")) showAccidentList();
			else if (clientChoice.equals("5")) showCompensationList();
			else if (clientChoice.equals("6")) showCounselList();
			else if (clientChoice.equals("7")) showPaymentList();
			else if (clientChoice.equals("8")) createAccident(clientInputReader);
			else if (clientChoice.equals("9")) deleteAccident(clientInputReader);
			else if (clientChoice.equals("10")) createCompensation(Constant.Customer, clientInputReader);
			else if (clientChoice.equals("11")) deleteCompensation(clientInputReader);
			else if (clientChoice.equals("12")) createCounsel(clientInputReader);
			else if (clientChoice.equals("13")) deleteCounsel(clientInputReader);
			else if (clientChoice.equals("14")) logout();
			else if (clientChoice.equals("15")) deleteMembership(Constant.Customer , clientInputReader);
			//
			else if (clientChoice.equals("16")) counselCategory(clientInputReader);
			else if (clientChoice.equals("17")) insuranceTypeCategory(clientInputReader);
			else if (clientChoice.equals("18")) contractRetrieveCategory(clientInputReader);
			else if (clientChoice.equals("19")) paymentCategory(clientInputReader);
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
		int index = 1;
		ArrayList<Accident> accidentList = accidentListImpl.retrieveByCustomerId(Integer.parseInt(TokenManager.getID(token)));
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
		if(paymentList.size() == 0) {
			System.out.println("No payment");
			return;
		}
		int index = 1;
		System.out.println("-- Your Payment List --");
		for(Payment payment : paymentList) {
			System.out.println(index + ". PaymentID: " + payment.getPaymentID() + " ContractID: " + payment.getContractID()+ " CustomerID: " + payment.getCustomerID()+" Status: "+payment.isPaymentProcessed());
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
		
		// Association setting
		Customer customer = customerListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		customer.setAccidentList(accidentListImpl);
		boolean response = customer.createAccident(accident);
		if(!response) System.out.println("[error] Accident ID duplicate. Please try again");
		else System.out.println("[success] Successfully created Accident!");		
	}
	private static void deleteAccident(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("--Delete Accident Infomation--");
		System.out.print("Accident ID: "); String accidentID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		
		// Association setting
		Customer customer = customerListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		customer.setAccidentList(accidentListImpl);
		boolean response = customer.deleteAccident(Integer.parseInt(accidentID));
		if(!response) System.out.println("[error] The Accident id does not exist.");
		else System.out.println("[success] Successfully Delete Accident!");	
	}
	private static void createPayment(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("--Create Payment Infomation--");
		System.out.print("Payment ID: "); String paymentID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("Contract ID: "); String contractID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		Contract contract = contractListImpl.retrieveById(Integer.parseInt(contractID));
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
		
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.createPayment(payment);
		if(response) System.out.println("[success] Successfully Create Payment!");
		else System.out.println("[error] Payment ID duplicate. Please try again");
	}
	private static void deletePayment(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("--Delete Payment Infomation--");
		System.out.print("payment ID: "); String paymentID = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.deletePayment(Integer.parseInt(paymentID));
		if(response) System.out.println("[success] Successfully deleted this Payment!");
		else System.out.println("[error] The payment id does not exist.");
	}
	private static void printEmployeeMainMenu() {
		System.out.println("***************** Employee Main Menu *****************");
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
		System.out.println("17. Update Counsel");
		System.out.println("18. Create Rule");
		System.out.println("19. Delete Rule");
		System.out.println("20, Create Payment");
		System.out.println("21. Delete Payment");
		System.out.println("22. Logout");
		System.out.println("23. Delete Membership");
		//
		System.out.println("24. 인수심사 카테고리");
		System.out.println("25. 계약체결 카테고리");
		System.out.println("26. 고객정보 DB 서비스 카테고리");
		System.out.println("27. 상담신청 일정 관리 카테고리");
		System.out.println("28. 상담 내역 관리 카테고리");
		System.out.println("R. Return HomePage");
	}
	private static void startEmployeeService(BufferedReader clientInputReader) throws IOException{
		while(true) {
			printEmployeeMainMenu();
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) login(Constant.Employee , clientInputReader);
			else if (clientChoice.equals("2")) signUp(Constant.Employee , clientInputReader);
			else if (clientChoice.equals("3")) showCustomerList();
			else if (clientChoice.equals("4")) showEmployeeList();
			else if (clientChoice.equals("5")) showAllContractList();
			else if (clientChoice.equals("6")) showAllPaymentList();
			else if (clientChoice.equals("7")) showInsuranceList();
			else if (clientChoice.equals("8")) showAllCompensationList();
			else if (clientChoice.equals("9")) showAllCounselList();
			else if (clientChoice.equals("10")) showRuleList();
			else if (clientChoice.equals("11")) createContract(clientInputReader);
			else if (clientChoice.equals("12")) deleteContract(clientInputReader);
			else if (clientChoice.equals("13")) createInsurance(clientInputReader);
			else if (clientChoice.equals("14")) deleteInsurance(clientInputReader);
			else if (clientChoice.equals("15")) createCompensation(Constant.Employee, clientInputReader);
			else if (clientChoice.equals("16")) deleteCompensation(clientInputReader);
			else if (clientChoice.equals("17")) updateCounsel(Constant.Employee, clientInputReader);
			else if (clientChoice.equals("18")) createRule(clientInputReader);
			else if (clientChoice.equals("19")) deleteRule(clientInputReader);
			else if (clientChoice.equals("20")) createPayment(clientInputReader);
			else if (clientChoice.equals("21")) deletePayment(clientInputReader);
			else if (clientChoice.equals("22")) logout();
			else if (clientChoice.equals("23")) deleteMembership(Constant.Employee , clientInputReader);
			//
			else if (clientChoice.equals("24")) underWritingCategory(clientInputReader);
			else if (clientChoice.equals("25")) concludeContractCategory(clientInputReader);
			else if (clientChoice.equals("26")) customerDBServiceCategory(clientInputReader);
			else if (clientChoice.equals("27")) councelScheduleCategory(clientInputReader);
			else if (clientChoice.equals("28")) counselDetailCategory(clientInputReader);
			else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to HomePage ***|");
				return;
			}
			else System.out.println("invalid choice");
		}
	}
	//// 고객 DB 서비스 카테고리 - 입수한 고객정보를 DB에 반영한다.
	private static void customerDBServiceCategory(BufferedReader clientInputReader) throws IOException {
		while(true) {
			System.out.println("***************** 고객 DB 서비스 카테고리 메뉴 *****************");
			System.out.println("1. 고객정보 생성");
			System.out.println("2. 고객정보 조회");
			System.out.println("3. 고객정보 수정");
			System.out.println("4. 고객정보 삭제");
			System.out.println("R. 돌아가기");
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) createCustomer(clientInputReader);
			else if (clientChoice.equals("2")) retrieveCustomer(clientInputReader);
			else if (clientChoice.equals("3")) updateCustomer(clientInputReader);
			else if (clientChoice.equals("4")) deleteCustomer(clientInputReader);
			else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Employee Main Menu ***|");
				return;
			}
			else System.out.println("invalid choice");
		}
	}
	// 입수한 고객정보를 DB에 반영한다.
	private static void createCustomer(BufferedReader clientInputReader) throws IOException {
		System.out.println("-- 입수한 고객 정보 입력 --");
		
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
		System.out.print("IsCured: enter [Y/N]"); String isCuredResult = dataValidation(clientInputReader.readLine().trim(), "boolean", clientInputReader);
		boolean isCured;
		if (isCuredResult.equals("Y")) isCured = true;
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
		
		// association setting
		customer.setCounselList(counselListImpl);
		customer.setPaymentList(paymentListImpl);
		customer.setInsuranceList(insuranceListImpl);
		
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		System.out.print("해당 고객의 정보를 DB에 추가하여 반영하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean", clientInputReader);
		boolean response = employee.createCustomer(customer, result);
		if (response == true) System.out.println("[success]  새로운 고객정보가 등록되었습니다.");
		else System.out.println("[info] 고객정보를 DB에 반영하지 않았습니다. 본 페이지로 이동합니다.");
	}
	private static void retrieveCustomer(BufferedReader clientInputReader) {
		showCustomerList();
	}
	private static void updateCustomer(BufferedReader clientInputReader) throws IOException {
		System.out.println("-- 수정할 고객 정보 입력 --");
		System.out.print("수정할 고객 ID: "); String customerID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.println("-- 새로운 고객 정보 입력 --");
		// basic attribute settings
		System.out.print("Name: "); String name = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
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
		System.out.print("IsCured: enter [Y/N]"); String isCuredResult = dataValidation(clientInputReader.readLine().trim(), "boolean", clientInputReader);
		boolean isCured;
		if (isCuredResult.equals("Y")) isCured = true;
		else isCured = false;
		System.out.print("Diseases: "); String diseasesString = dataValidation(clientInputReader.readLine().trim(), "multiValue", clientInputReader);
		String[] diseasesStrings = diseasesString.split(" ");
		for (String disease : diseasesStrings) {
			diseases.add(disease);
		}
		medicalHistory.setCured(isCured);
		medicalHistory.setCurePeriod(curePeriod);
		medicalHistory.setDiseases(diseases);

		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.updateCustomer(customerID, name, account, address, age, birthDate, email, gender, height, job, phone, weight, medicalHistory);
		if (response == true) System.out.println("[success] 수정이 완료되었습니다.");
		else System.out.println("[info] 해당 고객이 존재하지 않아 고객정보 수정에 실패했습니다. 본 페이지로 이동합니다.");
	}
	private static void deleteCustomer(BufferedReader clientInputReader) throws IOException {
		System.out.println("-- 삭제할 고객 정보 입력 --");
		System.out.print("삭제할 고객 ID: "); String customerID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.deleteCustomer(Integer.parseInt(customerID));
		if (response == true) System.out.println("[success] 해당 고객 정보가 삭제되었습니다.");
		else System.out.println("[info] 고객정보 삭제에 실패했습니다. 본 페이지를 다시 출력합니다.");
	}
	// -------------------------------------------------------------
	
	//// 계약체결 카테고리 - 계약을 체결한다.
	private static void concludeContractCategory(BufferedReader clientInputReader) throws IOException {
		while(true) {
			System.out.println("***************** 계약체결 카테고리 메뉴 *****************");
			System.out.println("1. 계약체결 진행");
			System.out.println("2. 재심사 요청");
			System.out.println("R. 돌아가기");
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) concludeContract(clientInputReader);
			else if (clientChoice.equals("2")) requestReUnderwriting(clientInputReader);
			else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Employee Main Menu ***|");
				return;
			}
			else System.out.println("invalid choice");
		}
	}
	private static void concludeContract(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		int index = 1;
		ArrayList<Contract> permitContractList = contractListImpl.retrieveByContractStatus(Constant.contractStatus4);
		if(permitContractList.size() == 0) {
			System.out.println("계약진행이 허용된 계약이 존재하지 않습니다.");
			return;
		}
		System.out.println("-- 계약진행이 허용된 계약 리스트. --");
		for(Contract contract : permitContractList) {
			System.out.println(index + ". " + "계약 id: "+contract.getContractID() + "계약상태: "+contract.getContractStatus() +" 고객id: "+contract.getCustomerID()+" 계약날짜: "+contract.getCreatedDate()+" 보험 상품 id: "+contract.getInsuranceID() +" 인수한 U/W직원 id: " +contract.getUnderwritingEID());
			index++;
		}
		System.out.println("-----------------------------");
		System.out.print("체결할 계약 id: "); String contractID = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("계약을 체결하시겠습니까? [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean", clientInputReader);
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		Contract contract = contractListImpl.retrieveById(Integer.parseInt(contractID));
		boolean response = employee.concludeContract(contract, result);
		if (response == true) System.out.println("[success] 계약체결이 완료되었습니다.");
		else System.out.println("[info] 계약진행에 실패했습니다. 본 페이지를 다시 출력합니다.");
	}
	private static void requestReUnderwriting(BufferedReader clientInputReader) throws IOException {
		boolean status = showRejectedUnderwriteContractList();
		if (!status) return;
		System.out.print("재심사 요청할 계약 id: "); String contractID = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		Contract contract = contractListImpl.retrieveById(Integer.parseInt(contractID));
		System.out.println("-- 재심사를 요청하려는 계약의 정보");
		System.out.println("재심사 하려는 계약정보. " + "계약 id: "+contract.getContractID() + ", 탈락사유: "+contract.getEvaluation());
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.requestReUnderwriting(contract);
		if (response == true) System.out.println("[success] 재심사 요청이 완료되었습니다.");
		else System.out.println("[info] 재심사 요청이 완료되지 않았습니다. 다시 페이지를 출력합니다.");
	}
	// ------------------------------------------------------
	
	//// 인수심사 카테고리 - 계약의 인수심사를 하다, 계약 진행을 허가한다.	
	private static void underWritingCategory(BufferedReader clientInputReader) throws IOException {
		while(true) {
			System.out.println("***************** 인수심사 카테고리 메뉴 *****************");
			System.out.println("1. 인수심사 진행");
			System.out.println("2. 인수심사된 계약 조회");
			System.out.println("3. 인수심사 거절된 계약 조회");
			System.out.println("4. 계약 진행 허가");
			System.out.println("R. 돌아가기");
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) processUnderwriting(clientInputReader);
			else if (clientChoice.equals("2")) showUnderwritedContractList();
			else if (clientChoice.equals("3")) showRejectedUnderwriteContractList();
			else if (clientChoice.equals("4")) permitContract(clientInputReader);
			else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Employee Main Menu ***|");
				return;
			}
			else System.out.println("invalid choice");
		}
	}
	// 계약 진행을 허가한다.	
	private static void permitContract(BufferedReader clientInputReader) throws IOException {
		boolean status = showUnderwritedContractList();
		if (!status) return;
		System.out.print("계약진행 허가할 계약 id: "); String contractID = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		Contract contract = contractListImpl.retrieveById(Integer.parseInt(contractID));
		System.out.println("-- 계약진행을 허가하려는 계약의 정보 --");
		System.out.println("진행 허가 계약정보. " + "계약 id: "+contract.getContractID() + " 고객id: "+contract.getCustomerID()+" 계약날짜: "+contract.getCreatedDate()+" 보험 상품 id: "+contract.getInsuranceID() +" 인수한 U/W직원 id: " +contract.getUnderwritingEID());
		System.out.print("계약 진행 허가 [Y/N]"); String result = dataValidation(clientInputReader.readLine().trim(), "boolean", clientInputReader);
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.permitContract(contract, result);
		if (response == true) System.out.println("[success] 계약 진행을 허가하셨습니다.");
		else System.out.println("[info] 계약 진행이 완료되지 않았습니다. 다시 페이지를 출력합니다.");
	}
	// 계약의 인수심사를 한다.
	private static void showRequestedUnderwriteContractList() throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		int index = 1;
		ArrayList<Contract> requestedUnderwriteContractList = contractListImpl.retrieveByContractStatus(Constant.contractStatus1);
		if(requestedUnderwriteContractList.size() == 0) {
			System.out.println("인수심사 요청된 계약이 존재하지 않습니다.");
			return;
		}
		System.out.println("-- 인수심사 요청된 계약 리스트. --");
		for(Contract contract : requestedUnderwriteContractList) {
			System.out.println(index + ". " + "계약ID: " + contract.getContractID() + " 계약을 생성한 직원: " + contract.getCreateContractEID() + " 계약상태: " + contract.getContractStatus());
			index++;
		}
	}
	private static void processUnderwriting(BufferedReader clientInputReader) throws IOException {
		showRequestedUnderwriteContractList();
		System.out.print("인수심사 진행할 계약 ID: "); String contractID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		Contract contract = contractListImpl.retrieveById(Integer.parseInt(contractID));
		Customer customer = customerListImpl.retrieveById(contract.getCustomerID());
		System.out.println("-- 인수심사 대상 계약 및 고객 정보 --");
		System.out.println("계약id : "+contract.getContractID());
		System.out.println("계약날짜 : "+contract.getCreatedDate());
		System.out.println("계약을 생성한 직원id : "+contract.getCreateContractEID());
		System.out.println("고객이름 : "+customer.getName());
		System.out.println("전화번호 : "+customer.getPhone());
		System.out.println("이메일 : "+customer.getEmail());
		System.out.println("주소 : "+customer.getAddress());
		System.out.println("생년월일 : "+customer.getBirthDate());
		System.out.println("신청보험id : "+contract.getInsuranceID());
		System.out.println("키 : "+customer.getHeight());
		System.out.println("몸무게 : "+customer.getWeight());
		System.out.println("나이 : "+customer.getAge());
		MedicalHistory medicalHistory = customer.getMedicalHistory();
		ArrayList<String> diseaseList = medicalHistory.getDiseases();
		String diseases = "";
		for(String disease : diseaseList) diseases+= ", "+disease;
		System.out.println("고객병력-치료기간 : "+medicalHistory.getCurePeriod());
		System.out.println("고객병력-질환 : "+ diseases);
		System.out.println("고객병력-치료여부 : "+medicalHistory.isCured());
		System.out.println("-------------------------------");
		System.out.print("평가결과: "); String evaluation = clientInputReader.readLine().trim();
		System.out.print("인수여부 [Y/N]: "); String result = dataValidation(clientInputReader.readLine().trim(), "boolean", clientInputReader);
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.processUnderwriting(contract, evaluation, result);
		if (response == true) System.out.println("[success] 인수심사를 완료하였습니다.");
		else System.out.println("[info] 인수심사를 거절하였습니다. 해당 계약건을 인수 제한한 계약건으로 분류합니다");
	}
	private static boolean showUnderwritedContractList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return false;
		}
		int index = 1;
		ArrayList<Contract> underwritedContractList = contractListImpl.retrieveByContractStatus(Constant.contractStatus3);
		if(underwritedContractList.size() == 0) {
			System.out.println("인수심사 완료된 계약이 존재하지 않습니다.");
			return false;
		}
		System.out.println("-- 인수심사 완료된 계약 리스트. --");
		for(Contract contract : underwritedContractList) {
			System.out.println(index + ". " + "계약 id: "+contract.getContractID() + " 고객id: "+contract.getCustomerID()+" 계약날짜: "+contract.getCreatedDate()+" 보험 상품 id: "+contract.getInsuranceID() +" 인수한 U/W직원 id: " +contract.getUnderwritingEID());
			index++;
		}
		System.out.println("---------------------------");
		return true;
	}
	private static boolean showRejectedUnderwriteContractList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return false;
		}
		int index = 1;
		ArrayList<Contract> rejectedUnderwriteContractList = contractListImpl.retrieveByContractStatus(Constant.contractStatus2);
		if(rejectedUnderwriteContractList.size() == 0) {
			System.out.println("인수심사 거절된 계약이 존재하지 않습니다.");
			return false;
		}
		System.out.println("-- 인수심사 거절된 계약 리스트. --");
		for(Contract contract : rejectedUnderwriteContractList) {
			System.out.println(index + ". " + "계약 id: "+contract.getContractID() + " 고객id: "+contract.getCustomerID()+" 계약날짜: "+contract.getCreatedDate()+" 보험 상품 id: "+contract.getInsuranceID() +" 인수한 U/W직원 id: " +contract.getUnderwritingEID());
			index++;
		}
		System.out.println("---------------------------");
		return true;
	}
	//-----------------------------------------------------------------
	
	//// 상담 신청 카테고리 - 보험 상담을 신청한다
	private static void counselCategory(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		while(true) {
			System.out.println("***************** 상담 신청 카테고리 메뉴 *****************");
			System.out.println("1. 상담 신청");
			System.out.println("2. 상담 신청 내역 조회");
			System.out.println("R. 돌아가기");
			
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("1")) createCounsel(clientInputReader);
			else if (clientChoice.equals("2")) showCounselList();
			else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Customer Main Menu ***|");
				return;
			}
			else System.out.println("invalid choice");
		}
	}
	// 보험 상담을 신청한다
	private static void createCounsel(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("-- 상담 신청 정보--");
		// basic attribute settings
		System.out.print("상담 ID: "); String counselID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("보험 종류: 1. 자동차  2. 생활  3. 건강  4. 여행"); String insuranceCategory = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("상담 일자: "); String dateOfCounsel = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("상딤 시간: "); String timeOfCOunsel = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		boolean statusOfCounsel = false;
		
		// ListImpl Add
		Counsel counsel = new Counsel();
		counsel.setCounselID(Integer.parseInt(counselID));
		counsel.setCustomerID(Integer.parseInt(TokenManager.getID(token)));
		counsel.setInsuranceCategory(Integer.parseInt(insuranceCategory));
		counsel.setDateOfCounsel(dateOfCounsel);
		counsel.setTimeOfCounsel(timeOfCOunsel);
		counsel.setStatusOfCounsel(statusOfCounsel);
		
		Customer customer = customerListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = customer.requestCounsel(counsel);
		if (response == true) System.out.println("[success] 상담 신청이 완료되었습니다.");
		else System.out.println("[error] 이미 등록된 상담 ID 입니다.");
	}
	// -------------------------------------------------------------
	
    //// 보험 상품 종류 카테고리 - 보험 상품을 조회하다
	private static void insuranceTypeCategory(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		while(true) {
			System.out.println("***************** 보험 상품 종류 카테고리 메뉴 *****************");
			System.out.println("1. 자동차");
			System.out.println("2. 생활");
			System.out.println("3. 건강");
			System.out.println("4. 여행");
			System.out.println("R. 돌아가기");
			
			String clientChoice = clientInputReader.readLine().trim();
			if(clientChoice.equals("1") || clientChoice.equals("2") || clientChoice.equals("3")|| clientChoice.equals("4")) {
				showInsuranceTypeList(clientChoice, clientInputReader);
			} else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Customer Main Menu ***|");
				return;
			} else System.out.println("invalid choice");
		}
	}
	
	// 보험 상품 종류 조회
	private static void showInsuranceTypeList(String clientChoice, BufferedReader clientInputReader) throws IOException {
		while(true) {
			int index = 1;
			System.out.println();
			ArrayList<Insurance> insuranceList = insuranceListImpl.retrieveTypeAll(clientChoice);
			if(insuranceList.size() == 0) {
				System.out.println("[info] 해당 종류의 보험 상품이 존재하지 않습니다.");
				return;
			}
			System.out.println("-- 보험 상품명 리스트 --");
			for(Insurance insurance: insuranceList) {
				System.out.println(index + ". InsuranceID: " + insurance.getInsuranceID() + " Name: " + insurance.getInsuranceName() + " Category: "+insurance.getCategory());
				index++;
			}
			System.out.println("가입을 원하는 보험의 ID를 입력해주세요.");
			System.out.println("R. 돌아가기");
			
			String clientChoice2 = clientInputReader.readLine().trim();
			if (clientChoice2.equals("R")) {
				System.out.println("|*** Return to Insurance Type List Menu ***|");
				return;
			} 
			// createContract(clientChoice2, clientInputReader); 해당 보험 ID로 가입 신청
		}
	}
	// -------------------------------------------------------------
	
	//// 보유 계약 조회 카테고리 - 계약을 확인하다, 계약을 해지하다
	private static void contractRetrieveCategory(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		while(true) {
			System.out.println("***************** 보유 계약 조회 카테고리 메뉴 *****************");
			System.out.println("1. 보유 계약 조회");
			System.out.println("R. 돌아가기");
			
			String clientChoice = clientInputReader.readLine().trim();
			if(clientChoice.equals("1")) {
				showContractList(clientInputReader);
			} else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Customer Main Menu ***|");
				return;
			} else System.out.println("invalid choice");
		}
	}
	
	// 계약을 확인하다
	private static void showContractList(BufferedReader clientInputReader) throws IOException {
		while(true) {
			int index = 1;
			System.out.println();
			ArrayList<Contract> contractList = contractListImpl.retrieveByCustomerId(Integer.parseInt(TokenManager.getID(token)));
			if(contractList.size() == 0) {
				System.out.println("[info] 보유한 계약이 없습니다.");
				return;
			}
			System.out.println("-- 보유 계약 리스트 --");
			for(Contract contract : contractList) {
				System.out.println(index + ". ContractID: " + contract.getContractID());
			}
			System.out.println("상세 내용 조회를 원하는 계약의 ID를 입력해주세요.");
			System.out.println("R. 돌아가기");
			
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Contract List Menu ***|");
				return;
			}
			Contract contract = contractListImpl.retrieveById(Integer.parseInt(clientChoice));
			if(contract != null) showContractDetail(contract, clientInputReader);
			else System.out.println("[error] 계약 ID가 존재하지 않습니다.");
		}
	}
	// 계약 상세 내용
	private static void showContractDetail(Contract contract, BufferedReader clientInputReader) throws IOException {
		while(true) {
			Insurance insurance = insuranceListImpl.retrieve(contract.getInsuranceID());
			Customer customer = customerListImpl.retrieveById(contract.getCustomerID());
			System.out.println("보험 상품명: "+insurance.getInsuranceName());
			System.out.println("고객 이름: " + customer.getName());
			System.out.println("전화번호: "+ customer.getPhone());
			System.out.println("보장 내용: " + insurance.getGuarantee().getGuaranteeName());
			System.out.println("월 보험료: " + contract.getMonthlyPremium());
			System.out.println("남은 납부기간: "); // expiration Date으로
			System.out.println("계약 시작일: " + contract.getCreatedDate());
			System.out.println("계약 만기일: "+ contract.getExpirationDate());
			System.out.println("계약 상태: "+ contract.getContractStatus());
			System.out.println("D. 계약 해지");
			System.out.println("R. 돌아가기");
			
			String clientChoice = clientInputReader.readLine().trim();
			if(clientChoice.equals("D")) {
				requestDeleteContract(contract, clientInputReader);
			} else if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Contract List Menu ***|");
				return;
			} else System.out.println("invalid choice");
		}
	}
	// 계약을 해지한다
	private static void requestDeleteContract(Contract contract, BufferedReader clientInputReader) throws IOException {
		while(true) {
			System.out.println("보험 계약을 해지하시겠습니까? (y/n)");
			String clientChoice = clientInputReader.readLine().trim();
			if(clientChoice.equals("y")) {
//				contractListImpl.deleteById(contractId);
			} else if (clientChoice.equals("n")) {
				System.out.println("|*** Return to Contract Detail Menu ***|");
				return;
			} else System.out.println("invalid choice");
		}
	}
	// -------------------------------------------------------------
	
	//// 보험료 납부 카테고리 - 보험료를 납부한다
	private static void paymentCategory(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		while(true) {
			ArrayList<Payment> paymentList = paymentListImpl.retrieveByCustomerID(Integer.parseInt(TokenManager.getID(token)));
			if(paymentList.size() == 0) {
				System.out.println("[info] 납부해야 할 보험료가 없습니다.");
				return;
			}
			int index = 1;
			System.out.println("-- 보험료 조회 리스트 --");
			for(Payment payment : paymentList) {
				System.out.println(index + ". PaymentID: " + payment.getPaymentID() + " ContractID: " + payment.getContractID()+ " CustomerID: " + payment.getCustomerID()+" Status: "+payment.isPaymentProcessed());
				index++;
			}
			System.out.println("납부하고자 하는 납부 ID를 입력해 주세요.");
			System.out.println("R. 돌아가기");
			
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Customer Main Menu ***|");
				return;
			}
			Payment payment = paymentListImpl.retrieve(Integer.parseInt(clientChoice));
			if(payment != null) {
				System.out.println("-- 결제 정보 입력 --");
				System.out.println("카드 번호: "); String cardNumber = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
				System.out.println("CVC: "); String cvcNumber = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
				System.out.println("카드 비밀번호 2자리: "); String password = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
				
				boolean response = payment.processPayment(Integer.parseInt(cardNumber), Integer.parseInt(cvcNumber), Integer.parseInt(password));
				if(response) System.out.println("[success] 보험료가 납부되었습니다.");
				else System.out.println("[error] 결제에 실패하였습니다.");
				
				return;
			}
			else System.out.println("[error] 납부 ID가 존재하지 않습니다.");
		}
	}
	// -------------------------------------------------------------
	
	//// 상담신청 일정 관리 카테고리 - 상담신청 일정을 관리한다
	private static void councelScheduleCategory(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		while(true) {
			ArrayList<Counsel> counselList = counselListImpl.retrieveAll();
			if(counselList.size() == 0) {
				System.out.println("[info] 신청된 상담이 없습니다.");
				return;
			}
			int index = 1;
			System.out.println("-- 상담신청 내역 리스트 --");
			for(Counsel counsel : counselList) {
				Customer customer = customerListImpl.retrieveById(counsel.getCustomerID());
				System.out.println(index + ". CounselID: "+ counsel.getCounselID() + " 이름: "+ customer.getName()+" 전화번호: "+ customer.getPhone()+" 성별: "+customer.getGender()+" 생년월일: "+customer.getBirthDate()+" 직업: "+customer.getJob()+" 주소: "+customer.getAddress()+ 
						" 보험 종류: "+counsel.getInsuranceCategory()+" 상담 일자: "+counsel.getDateOfCounsel()+ " 상담 시간: "+counsel.getTimeOfCounsel()+" 처리 상태: "+counsel.isConfirmedCounsel());
				index++;
			}
			System.out.println("확정하고자 하는 상담 ID를 입력해 주세요.");
			System.out.println("R. 돌아가기");
			
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Customer Main Menu ***|");
				return;
			}
			Counsel counsel = counselListImpl.retrieve(Integer.parseInt(clientChoice));
			if(counsel != null) {
				System.out.println("해당 상담 일정을 확정하시겠습니까? (y/n) ");
				boolean response = counsel.confirmCounsel();
				if(response) {
					System.out.println("[success] 상담 일정이 확정되었습니다.");
					return;
				} else {
					System.out.println("[error] 이미 처리완료된 상담입니다.");
				}
			} else {
				System.out.println("[error] 상담 ID가 존재하지 않습니다.");
			}
		}
	}
	// -------------------------------------------------------------
	
	//// 상담 내역 관리 카테고리 - 고객과의 상담 내역을 관리한다
	private static void counselDetailCategory(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		while(true) {
			ArrayList<Counsel> counselList = counselListImpl.retrieveByEmployeeId(Integer.parseInt(TokenManager.getID(token)));
			if(counselList.size() == 0) {
				System.out.println("[info] 상담한 내역이 없습니다.");
				return;
			}
			int index = 1;
			System.out.println("-- 상담 내역 리스트 --");
			for(Counsel counsel : counselList) {
				Customer customer = customerListImpl.retrieveById(counsel.getCustomerID());
				System.out.println(index + ". CounselID: "+ counsel.getCounselID() + " 이름: "+ customer.getName()+" 전화번호: "+ customer.getPhone()+" 생년월일: "+customer.getBirthDate()+" 이메일: "+customer.getEmail()+
						" 보험 종류: "+counsel.getInsuranceCategory()+" 상담 일자: "+counsel.getDateOfCounsel()+ " 상담 시간: "+counsel.getTimeOfCounsel()+" 처리 상태: "+counsel.isConfirmedCounsel());
				index++;
			}
			System.out.println("정보를 추가하고자 하는 상담 ID를 입력해 주세요.");
			System.out.println("R. 돌아가기");
			
			String clientChoice = clientInputReader.readLine().trim();
			if (clientChoice.equals("R")) {
				System.out.println("|*** Return to Employee Main Menu ***|");
				return;
			}
			Counsel counsel = counselListImpl.retrieve(Integer.parseInt(clientChoice));
			System.out.println("-- 상담 정보 저장 --");
			System.out.println("상담 내용: ");  String counselDetail = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.println("비고: ");  String note = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			
			boolean response = counsel.updateCounsel(counselDetail, note);
			if(response) System.out.println("[success] 상담 정보가 추가되었습니다.");
			else System.out.println("[error] 상담 ID가 존재하지 않습니다.");
		}
	}
	// -------------------------------------------------------------
	
	private static void showAllPaymentList() {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		int index = 1;
		ArrayList<Payment> paymentList = paymentListImpl.retrieveAll();
		if(paymentList.size() == 0) {
			System.out.println("No payment");
			return;
		}
		System.out.println("-- Payment List --");
		for(Payment payment : paymentList) {
			System.out.println(index + ". PaymentID: " + payment.getPaymentID() + " ContractID: " + payment.getContractID()+ " CustomerID: " + payment.getCustomerID()+" Status: "+payment.isPaymentProcessed());
			index++;
		}
	}
	private static void updateCounsel(String userType, BufferedReader clientInputReader) {
		
	}
	
	private static void showCustomerList() {
		int index = 1;
		System.out.println("-- Customer List --");
		for(Customer customer : customerListImpl.retrieveAll()) {
			System.out.println(index + ". ID: " + customer.getCustomerID() + " Name: " + customer.getName());
			index++;
		}
	}
	private static void showEmployeeList() {
		int index = 1;
		System.out.println();
		System.out.println("-- Employee List --");
		for(Employee employee : employeeListImpl.retrieveAll()) {
			System.out.println(index + ". ID: " + employee.getEmployeeID() + " Name: " + employee.getName() + " Gender: " + employee.getGender()+ " Email: " + employee.getEmail()+ " Phone: " + employee.getName()+ " type: " + employee.getType());
			index++;
		}
	}
	private static void showAllContractList() {
		int index = 1;
		System.out.println();
		System.out.println("-- Contract List --");
		for(Contract contract : contractListImpl.retrieveAll()) {
			System.out.println(index + ". ContractID: " + contract.getContractID() +  " ContractStatus: " + contract.getContractStatus() +  " ContractCreateDate: " +contract.getCreatedDate()+" InsuranceID: " + contract.getInsuranceID()+ " CustomerID: " + contract.getCustomerID());
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
		if (role.equals(Constant.Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println();
		System.out.println("-- Rule List --");
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
		ArrayList<Counsel> counselList = counselListImpl.retrieveByCustomerID(Integer.parseInt(TokenManager.getID(token)));
		if(counselList.size() == 0) {
			System.out.println("No counsel");
			return;
		}
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
		int index = 1;
		ArrayList<Counsel> counselList = counselListImpl.retrieveAll();
		if(counselList.size() == 0) {
			System.out.println("No counsel");
			return;
		}
		System.out.println("-- Counsel List --");
		for(Counsel counsel : counselList) {
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
		if (role.equals(Constant.Customer)) {
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
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("--Create Contract Infomation--");
		// basic attribute settings
		System.out.print("contractID: "); String contractID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		String contractStatus = Constant.contractStatus1;
		System.out.print("customerID: "); String customerID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		System.out.print("expirationDate: "); String expirationDate = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
		System.out.print("insuranceID: "); String insuranceID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
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
		if(paymentType.equals(Constant.paymentInfoCard)) {
			System.out.println("--Payment Card Information--");
			System.out.print("cardNum: ");String cardNum= dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("cvcNum: ");String cvcNum= dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			System.out.print("password: ");String password= dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			CardPayment cardPayment = new CardPayment();
			cardPayment.setCardNum(cardNum);
			cardPayment.setCvcNum(cvcNum);
			cardPayment.setPassword(password);
		}else if(paymentType.equals(Constant.paymentInfoBank)) {
			System.out.println("--Payment Bank Information--");
			System.out.print("payerName: ");String payerName= dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);;
			System.out.print("payerPhoneNum: ");String payerPhoneNum= dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			BankPayment bankPayment = new BankPayment();
			bankPayment.setPayerName(payerName);
			bankPayment.setPayerPhoneNum(payerPhoneNum);
		}else if(paymentType.equals(Constant.paymentInfoAutomatic)) {
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
		contract.setCreateContractEID(Integer.parseInt(TokenManager.getID(token)));
		contract.setExpirationDate(expirationDate);
		contract.setInsuranceID(Integer.parseInt(insuranceID));
		contract.setCreatedDate(createdDate);
		contract.setConclude(isConclude);
		contract.setPassUW(isPassUW);
		contract.setMonthlyPremium(Integer.parseInt(monthlyPremium));
		contract.setPaymentInfo(paymentInfo);
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.createContract(contract);
		if (response == true) System.out.println("[success] Successfully Create Contract!");
		else System.out.println("[error] Contract ID duplicate. Please try again");
	}
	private static void deleteContract(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("--Delete Contract Infomation--");
		System.out.print("contractID: "); String contractID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.deleteContract(Integer.parseInt(contractID));
		if (response == true) System.out.println("[success] Successfully deleted this Contract!");
		else System.out.println("[error] The contract id does not exist.");
	}
	private static void createRule(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Constant.Customer)) {
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

		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.createRule(rule);
		if (response == true) System.out.println("[success] Successfully Create Rule!");
		else System.out.println("[error] Rule ID duplicate. Please try again");
	}
	private static void deleteRule(BufferedReader clientInputReader) throws IOException {
		System.out.print("ruleID: "); 
		String ruleID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);	

		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Constant.Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.deleteRule(Integer.parseInt(ruleID));
		if (response == true) System.out.println("[success] Successfully Delete Rule!");
		else System.out.println("[error] Rule ID does not exist. Please try again");
	}
	
	
	private static void deleteCounsel(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("--Delete Counsel Infomation--");
		System.out.print("Counsel ID: "); String counselID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		
		Customer customer = customerListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = customer.deleteCounsel(Integer.parseInt(counselID));
		if(response) System.out.println("[success] Successfully deleted Counsel!");
		else System.out.println("[error] The counsel ID does not exist.");
		
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
		
		// Association setting
		Customer customer = customerListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		customer.setCompensationList(compensationListImpl);
		boolean response = customer.createCompensation(compensation);
		if(!response) System.out.println("[error] Compensation ID duplicate. Please try again");
		else System.out.println("[success] Successfully created Compensation!");		
	}
	private static void deleteCompensation(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		if (TokenManager.getRole(token).equals(Constant.Customer)) {
			System.out.println("[error] You do not have access.");
			return;
		}
		System.out.println("--Delete Compensation Infomation--");
		System.out.print("CompensationID: "); String compensationID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		
		// Association setting
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		employee.setCompensationList(compensationListImpl);
		boolean response = employee.deleteCompensation(Integer.parseInt(compensationID));
		if(!response) System.out.println("[error] The Compensation id does not exist.");
		else System.out.println("[success] Successfully Delete Compensation!");	
				
	}
	private static void createInsurance(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("InsuranceCategory: 1. 자동차  2. 주택화재  3. 암건강  4. 해외여행"); 
		String insuranceCategory = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		if(insuranceCategory.equals("1")) insuranceCategory = "자동차";
		else if(insuranceCategory.equals("2")) insuranceCategory = "주택화재";
		else if(insuranceCategory.equals("3")) insuranceCategory = "암건강";
		else if(insuranceCategory.equals("4")) insuranceCategory = "해외여행";
		
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
		
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.createInsurance(insurance);
		if(response) System.out.println("[error] Insurance ID duplicate. Please try again");
		else System.out.println("[success] Successfully created Insurance!");
	}
	private static void deleteInsurance(BufferedReader clientInputReader) throws IOException {
		if (!TokenManager.isValidToken(token)) {
			System.out.println("[error] please login first.");
			return;
		}
		System.out.println("--Delete Insurance Infomation--");
		System.out.print("Insurance ID: "); String insuranceID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
		
		Employee employee = employeeListImpl.retrieveById(Integer.parseInt(TokenManager.getID(token)));
		boolean response = employee.deleteInsurance(Integer.parseInt(insuranceID));
		if(response) System.out.println("[success] Successfully deleted Insurance!");
		else System.out.println("[error] The Insurance ID does not exist.");
	}
	
	private static void login(String userType, BufferedReader clientInputReader) throws IOException {
		System.out.println("--Login Infomation--");
		if (userType.equals(Constant.Customer)) {
			System.out.print("ID: "); String ID = dataValidation(clientInputReader.readLine().trim(), "Integer", clientInputReader);
			System.out.print("PW: "); String PW = dataValidation(clientInputReader.readLine().trim(), "String", clientInputReader);
			for(Customer customer : customerListImpl.retrieveAll()) {
				String customerID = Integer.toString(customer.getCustomerID());
				String customerPW = customer.getCustomerPW();
				if (customerID.equals(ID) && customerPW.equals(PW)) {
					token = TokenManager.createToken(ID, Constant.Customer);
					System.out.println("[success] " + TokenManager.getID(token)+", Welcome - Login successfully");
					return;
				}
			}
			System.out.println("[error] ID or PW is incorrect. \n please retry..");
			return;
		} else if (userType.equals(Constant.Employee)) {
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
		if (userType.equals(Constant.Customer)) {
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
			
			// association setting
			customer.setCounselList(counselListImpl);
			customer.setPaymentList(paymentListImpl);
			customer.setInsuranceList(insuranceListImpl);
			
			boolean response = customerListImpl.add(customer);		
			if (response == true) System.out.println("[success] Successfully Sign Up!");
			else System.out.println("[error] ID duplicate. Please sign up again");
		} else if (userType.equals(Constant.Employee)) {
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
			
			// association setting
			employee.setRuleList(ruleListImpl);
			employee.setContractList(contractListImpl);
			employee.setInsuranceList(insuranceListImpl);
			employee.setPaymentList(paymentListImpl);
			employee.setCounselList(counselListImpl);
			employee.setCustomerList(customerListImpl);
			
			boolean response = employeeListImpl.add(employee);
			if (response == true) System.out.println("[success] Successfully Sign Up!");
			else System.out.println("[error] ID duplicate. Please sign up again");
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
			if (userType.equals(Constant.Customer)) customerListImpl.deleteById(Integer.parseInt(TokenManager.getID(token)));
			else if (userType.equals(Constant.Employee)) employeeListImpl.deleteById(Integer.parseInt(TokenManager.getID(token)));
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
			if (inputData.equals(Constant.Sales) || inputData.equals(Constant.UnderWriting) || inputData.equals(Constant.CutomerInfomationManage) || inputData.equals(Constant.CompensationProcessing)) return true;
            else return false;
		} else if ("gender".equals(type)) {
			if (inputData.equals("M") || inputData.equals("W")) return true;
            else return false;
		}
		if (inputData.trim().isEmpty() || inputData.contains(" ")) return false;
	    return true;
	}
}