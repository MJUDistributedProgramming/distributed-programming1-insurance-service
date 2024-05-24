package domain;
public class Contract {
	private int concludeEID;
	private int contractDate;
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
	// 
	public Payment m_Payment;
	public PaymentInfo m_PaymentInfo;
	public Contract(){

	}
	public void finalize() throws Throwable {

	}
	public boolean endorsementReview(int 계약ID){
		return false;
	}

	public void permitContract(int ContractID){

	}

	public void processUnderwriting(int contractID){

	}

	public void requestReUnderwriting(int contractID){

	}

	public void revive(Contract contract){

	}

	public void saveRenewalStatus(boolean renewalStatus){

	}
	//
	public int getConcludeEID() {
		return concludeEID;
	}
	public void setConcludeEID(int concludeEID) {
		this.concludeEID = concludeEID;
	}
	public int getContractDate() {
		return contractDate;
	}
	public void setContractDate(int contractDate) {
		this.contractDate = contractDate;
	}
	public int getContractID() {
		return contractID;
	}
	public void setContractID(int contractID) {
		this.contractID = contractID;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public int getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}
	public boolean isConclude() {
		return isConclude;
	}
	public void setConclude(boolean isConclude) {
		this.isConclude = isConclude;
	}
	public boolean isPassUW() {
		return isPassUW;
	}
	public void setPassUW(boolean isPassUW) {
		this.isPassUW = isPassUW;
	}
	public int getMonthlyPremium() {
		return monthlyPremium;
	}
	public void setMonthlyPremium(int monthlyPremium) {
		this.monthlyPremium = monthlyPremium;
	}
	public int getNonPaymentPeriod() {
		return nonPaymentPeriod;
	}
	public void setNonPaymentPeriod(int nonPaymentPeriod) {
		this.nonPaymentPeriod = nonPaymentPeriod;
	}
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	public boolean isRenewalStatus() {
		return renewalStatus;
	}
	public void setRenewalStatus(boolean renewalStatus) {
		this.renewalStatus = renewalStatus;
	}
	public String getResurrectionDate() {
		return resurrectionDate;
	}
	public void setResurrectionDate(String resurrectionDate) {
		this.resurrectionDate = resurrectionDate;
	}
	public String getResurrectionReason() {
		return resurrectionReason;
	}
	public void setResurrectionReason(String resurrectionReason) {
		this.resurrectionReason = resurrectionReason;
	}
	public int getUnderwritingEID() {
		return underwritingEID;
	}
	public void setUnderwritingEID(int underwritingEID) {
		this.underwritingEID = underwritingEID;
	}
	public Payment getM_Payment() {
		return m_Payment;
	}
	public void setM_Payment(Payment m_Payment) {
		this.m_Payment = m_Payment;
	}
	public PaymentInfo getM_PaymentInfo() {
		return m_PaymentInfo;
	}
	public void setM_PaymentInfo(PaymentInfo m_PaymentInfo) {
		this.m_PaymentInfo = m_PaymentInfo;
	}
}