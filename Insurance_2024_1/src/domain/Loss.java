package domain;


/**
 * @author junkyulee
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
public class Loss {
	
	private int lossID;
	private int accidentID;
	private int employeeID;
	private String employeeOpinion;
	private int lossAmount;

	public Loss(){

	}

	public void finalize() throws Throwable {

	}

	public int getAccidentID() {
		return accidentID;
	}

	public void setAccidentID(int accidentID) {
		this.accidentID = accidentID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeOpinion() {
		return employeeOpinion;
	}

	public void setEmployeeOpinion(String employeeOpinion) {
		this.employeeOpinion = employeeOpinion;
	}

	public int getLossAmount() {
		return lossAmount;
	}

	public void setLossAmount(int lossAmount) {
		this.lossAmount = lossAmount;
	}

	public int getLossID() {
		return lossID;
	}

	public void setLossID(int lossID) {
		this.lossID = lossID;
	}
}