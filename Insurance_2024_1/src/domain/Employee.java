package domain;
import IF.ContractList;
import IF.EmployeeList;
/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
public class Employee {
	private String email;
	private int employeeID;
	private String employeePW;
	private String gender;
	private String name;
	private String phone;
	private String type;
	public Insurance m_Insurance;
	public Rule m_Rule;
	//
	public ContractList contractListImpl;
	public Compensation m_Compensation;
	public Counsel m_Counsel;
	//
	public Employee(ContractList contractListImpl){
		this.contractListImpl = contractListImpl;
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
	public void createContract(Contract contract) {
		this.contractListImpl.add(contract);
	}
	public void deleteContract(String contractID) {
		this.contractListImpl.delete(Integer.parseInt(contractID));
	}
}