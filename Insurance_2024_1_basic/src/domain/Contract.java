package domain;
public class Contract {
	private int concludeEID;
	// private int createContractEID;
	private String createdDate;
	private String concludedDate;
	private int contractID;
	private String contractStatus;
	private int customerID;
	private String evaluation;
	private String expirationDate;
	private int insuranceID;
	private boolean isConclude;
	private boolean isPassUW;
	private int monthlyPremium;
	private int nonPaymentPeriod;
	private PaymentInfo paymentInfo;
	private boolean renewalStatus;
	private String resurrectionDate;
	private String resurrectionReason;
	private int underwritingEID;
	public Contract(){}
	public void finalize() throws Throwable {}
	public String toString() {
		  return "-- 계약 정보 --\n" +
	                "계약체결한 직원 id: " + concludeEID +"\n"+
	                "계약 시작일: " + createdDate + "\n"+
	                "계약 체결일: " + concludedDate +"\n"+
	                "계약 ID: " + contractID +"\n"+
	                "계약 상태: " + contractStatus + "\n"+
	                "고객 ID: " + customerID +"\n"+
	                "평가 결과: " + evaluation + "\n"+
	                "계약 만료일: '" + expirationDate+ "\n"+
	                "보험 ID: " + insuranceID +"\n"+
	                "체결 야부: " + isConclude +"\n"+
	                "인수심사 여부: " + isPassUW +"\n"+
	                "월 보험료: " + monthlyPremium +"\n"+
	                "미납 기간: " + nonPaymentPeriod +"\n"+
	                (paymentInfo != null ? paymentInfo.toString() : "없음") +"\n"+
	                "재계약 상태: " + renewalStatus +"\n"+
	                "계약 부활일: " + resurrectionDate + "\n"+
	                "부활 사유: " + resurrectionReason + "\n"+
	                "인수심사한 직원 id: " + underwritingEID +"\n";
	}
	//
	public int getConcludeEID() {return concludeEID;}
	public void setConcludeEID(int concludeEID) {this.concludeEID = concludeEID;}
	public String getCreatedDate() {return createdDate;}
	public void setCreatedDate(String createdDate) {this.createdDate = createdDate;}
	public String getConcludedDate() {return concludedDate;}
	public void setConcludedDate(String concludedDate) {this.concludedDate = concludedDate;}
	public int getContractID() {return contractID;}
	public void setContractID(int contractID) {this.contractID = contractID;}
	public String getContractStatus() {return contractStatus;}
	public void setContractStatus(String contractStatus) {this.contractStatus = contractStatus;}
	public int getCustomerID() {return customerID;}
	public void setCustomerID(int customerID) {this.customerID = customerID;}
	public String getEvaluation() {return evaluation;}
	public void setEvaluation(String evaluation) {this.evaluation = evaluation;}
	public String getExpirationDate() {return expirationDate;}
	public void setExpirationDate(String expirationDate) {this.expirationDate = expirationDate;}
	public int getInsuranceID() {return insuranceID;}
	public void setInsuranceID(int insuranceID) {this.insuranceID = insuranceID;}
	public boolean isConclude() {return isConclude;}
	public void setConclude(boolean isConclude) {this.isConclude = isConclude;}
	public boolean isPassUW() {return isPassUW;}
	public void setPassUW(boolean isPassUW) {this.isPassUW = isPassUW;}
	public int getMonthlyPremium() {return monthlyPremium;}
	public void setMonthlyPremium(int monthlyPremium) {this.monthlyPremium = monthlyPremium;}
	public int getNonPaymentPeriod() {return nonPaymentPeriod;}
	public void setNonPaymentPeriod(int nonPaymentPeriod) {this.nonPaymentPeriod = nonPaymentPeriod;}
	public PaymentInfo getPaymentInfo() {return paymentInfo;}
	public void setPaymentInfo(PaymentInfo paymentInfo) {this.paymentInfo = paymentInfo;}
	public boolean isRenewalStatus() {return renewalStatus;}
	public void setRenewalStatus(boolean renewalStatus) {this.renewalStatus = renewalStatus;}
	public String getResurrectionDate() {return resurrectionDate;}
	public void setResurrectionDate(String resurrectionDate) {this.resurrectionDate = resurrectionDate;}
	public String getResurrectionReason() {return resurrectionReason;}
	public void setResurrectionReason(String resurrectionReason) {this.resurrectionReason = resurrectionReason;}
	public int getUnderwritingEID() {return underwritingEID;}
	public void setUnderwritingEID(int underwritingEID) {this.underwritingEID = underwritingEID;}
}