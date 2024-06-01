package domain;
import java.util.ArrayList;

import IF.AccidentList;
import IF.CompensationList;
import IF.CounselList;
import IF.InsuranceList;
import IF.PaymentList;

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
	public CounselList counselListImpl;
	public Contract m_Contract;
	public MedicalHistory m_MedicalHistory;
	public PaymentList paymentListImpl;
	public InsuranceList insuranceListImpl;
	public AccidentList accidentListImpl;
	public CompensationList compensationListImpl;
	
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
	public Contract getM_Contract() {
		return m_Contract;
	}
	public void setM_Contract(Contract m_Contract) {
		this.m_Contract = m_Contract;
	}
	public void setAccidentList(AccidentList accidentListImpl) {
		this.accidentListImpl = accidentListImpl;
	}
	public AccidentList getAccidentList() {
		return accidentListImpl;
	}
	public boolean createAccident(Accident accident) {
		return this.accidentListImpl.add(accident);
	}
	public boolean updateAccident(int accidentID, Accident accident) {
		return this.accidentListImpl.update(accidentID, accident);
	}
	public boolean deleteAccident(int accidentId) {
		return this.accidentListImpl.deleteById(accidentId);
	}
	public CompensationList getCompensationList() {
		return compensationListImpl;
	}
	public void setCompensationList(CompensationList compensationListImpl) {
		this.compensationListImpl = compensationListImpl;
	}
	public boolean createCompensation(Compensation compensation) {
		return this.compensationListImpl.add(compensation);
	}
	public boolean updateCompensation(Compensation compensation, int compensationID) {
		return this.compensationListImpl.update(compensation, compensationID);
	}
	public boolean createBill(Compensation compensation, int compensationID) {
		return this.compensationListImpl.update(compensation, compensationID);
	}
	public void setCounselList(CounselList counselListImpl) {
		this.counselListImpl = counselListImpl;
	}
	public boolean requestCounsel(Counsel counsel) {
		return counselListImpl.add(counsel);
	}
	public boolean deleteCounsel(int counselID) {
		return counselListImpl.delete(counselID);
	}
	public void setPaymentList(PaymentList paymentListImpl) {
		this.paymentListImpl = paymentListImpl;
	}
	public void setInsuranceList(InsuranceList insuranceListImpl) {
		this.insuranceListImpl = insuranceListImpl;
	}
}