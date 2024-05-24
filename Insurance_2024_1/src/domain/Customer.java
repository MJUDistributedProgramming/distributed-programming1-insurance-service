package domain;
import java.util.ArrayList;
public class Customer {
	private String account;
	private String address;
	private int age;
	private String birthDate;
	private ArrayList<Contract> contractedList;
	private int customerID;
	private String customerPW;
	private String email;
	private String gender;
	private int height;
	private String job;
	private MedicalHistory medicalHistory;
	private String name;
	private String phone;
	private int weight;
	
	// associations
	public Payment m_Payment;
	public Compensation m_Compensation;
	public Counsel m_Counsel;
	public Contract m_Contract;
	public MedicalHistory m_MedicalHistory;
	public Accident m_Accident;
	
	public Customer(){
		contractedList = new ArrayList<>();
	}
	public void finalize() throws Throwable {

	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public ArrayList<Contract> getContractedList() {
		return contractedList;
	}
	public void setContractedList(ArrayList<Contract> contractedList) {
		this.contractedList = contractedList;
	}
	public String getCustomerPW() {
		return customerPW;
	}
	public void setCustomerPW(String customerPW) {
		this.customerPW = customerPW;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = medicalHistory;
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Payment getM_Payment() {
		return m_Payment;
	}
	public void setM_Payment(Payment m_Payment) {
		this.m_Payment = m_Payment;
	}
	public Compensation getM_Compensation() {
		return m_Compensation;
	}
	public void setM_Compensation(Compensation m_Compensation) {
		this.m_Compensation = m_Compensation;
	}
	public Counsel getM_Counsel() {
		return m_Counsel;
	}
	public void setM_Counsel(Counsel m_Counsel) {
		this.m_Counsel = m_Counsel;
	}
	public Contract getM_Contract() {
		return m_Contract;
	}
	public void setM_Contract(Contract m_Contract) {
		this.m_Contract = m_Contract;
	}
	public MedicalHistory getM_MedicalHistory() {
		return m_MedicalHistory;
	}
	public void setM_MedicalHistory(MedicalHistory m_MedicalHistory) {
		this.m_MedicalHistory = m_MedicalHistory;
	}
	public Accident getM_Accident() {
		return m_Accident;
	}
	public void setM_Accident(Accident m_Accident) {
		this.m_Accident = m_Accident;
	}
	
}