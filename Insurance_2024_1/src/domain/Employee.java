package domain;


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
	public Contract m_Contract;
	public Compensation m_Compensation;
	public Counsel m_Counsel;

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

	public Insurance getM_Insurance() {
		return m_Insurance;
	}

	public void setM_Insurance(Insurance m_Insurance) {
		this.m_Insurance = m_Insurance;
	}

	public Rule getM_Rule() {
		return m_Rule;
	}

	public void setM_Rule(Rule m_Rule) {
		this.m_Rule = m_Rule;
	}

	public Contract getM_Contract() {
		return m_Contract;
	}

	public void setM_Contract(Contract m_Contract) {
		this.m_Contract = m_Contract;
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
}