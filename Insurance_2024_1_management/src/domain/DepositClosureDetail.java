package domain;


/**
 * @author Owner
 * @version 1.0
 * @created 13-6-2024 오후 1:59:28
 */
public class DepositClosureDetail {
	private int depositClosureDetailId;
	private int employeeID;
	private String account;
	private String adjustmentAmount;
	private String adjustmentReason;
	private String closingDate;
	private String depositAmount;
	private String lastTransactionAmount;
	private String lastTransactionStatus;
	private String nameOfBank;
	private String tradingDate;
	private String withdrawalAmount;

	public DepositClosureDetail(){

	}

	public void finalize() throws Throwable {

	}

	// set & get
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAdjustmentAmount() {
		return adjustmentAmount;
	}

	public void setAdjustmentAmount(String adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}

	public String getAdjustmentReason() {
		return adjustmentReason;
	}

	public void setAdjustmentReason(String adjustmentReason) {
		this.adjustmentReason = adjustmentReason;
	}

	public String getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}

	public String getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}

	public int getDepositClosureDetailId() {
		return depositClosureDetailId;
	}

	public void setDepositClosureDetailId(int depositClosureDetailId) {
		this.depositClosureDetailId = depositClosureDetailId;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getLastTransactionAmount() {
		return lastTransactionAmount;
	}

	public void setLastTransactionAmount(String lastTransactionAmount) {
		this.lastTransactionAmount = lastTransactionAmount;
	}

	public String getLastTransactionStatus() {
		return lastTransactionStatus;
	}

	public void setLastTransactionStatus(String lastTransactionStatus) {
		this.lastTransactionStatus = lastTransactionStatus;
	}

	public String getNameOfBank() {
		return nameOfBank;
	}

	public void setNameOfBank(String nameOfBank) {
		this.nameOfBank = nameOfBank;
	}

	public String getTradingDate() {
		return tradingDate;
	}

	public void setTradingDate(String tradingDate) {
		this.tradingDate = tradingDate;
	}

	public String getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(String withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

}