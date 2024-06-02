package domain;


/**
 * @author yeil9
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public class Counsel {

	private int counselID;
	private int customerID;
	private int employeeID;
	private int insuranceCategory;
	private String content;
	private String counselDetail;
	private String dateOfCounsel;
	private String timeOfCounsel;
	private boolean statusOfCounsel;
	private String note;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCounselDetail() {
		return counselDetail;
	}

	public void setCounselDetail(String counselDetail) {
		this.counselDetail = counselDetail;
	}

	public int getCounselID() {
		return counselID;
	}

	public void setCounselID(int counselID) {
		this.counselID = counselID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getDateOfCounsel() {
		return dateOfCounsel;
	}

	public void setDateOfCounsel(String dateOfCounsel) {
		this.dateOfCounsel = dateOfCounsel;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getInsuranceCategory() {
		return insuranceCategory;
	}

	public void setInsuranceCategory(int insuranceCategory) {
		this.insuranceCategory = insuranceCategory;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isConfirmedCounsel(){
		return statusOfCounsel;
	}

	public void setStatusOfCounsel(boolean statusOfCounsel) {
		this.statusOfCounsel = statusOfCounsel;
	}

	public String getTimeOfCounsel() {
		return timeOfCounsel;
	}

	public void setTimeOfCounsel(String timeOfCounsel) {
		this.timeOfCounsel = timeOfCounsel;
	}

	public void finalize() throws Throwable {

	}

	public void confirmCounsel(){
		
	}

}