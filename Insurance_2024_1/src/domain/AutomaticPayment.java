package domain;

public class AutomaticPayment {

	private String accountNum;
	private String applicantName;
	private String applicantRRN;
	private String paymentCompanyName;
	private String relationshipToApplicant;

	public AutomaticPayment(){

	}

	public void finalize() throws Throwable {

	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantRRN() {
		return applicantRRN;
	}

	public void setApplicantRRN(String applicantRRN) {
		this.applicantRRN = applicantRRN;
	}

	public String getPaymentCompanyName() {
		return paymentCompanyName;
	}

	public void setPaymentCompanyName(String paymentCompanyName) {
		this.paymentCompanyName = paymentCompanyName;
	}

	public String getRelationshipToApplicant() {
		return relationshipToApplicant;
	}

	public void setRelationshipToApplicant(String relationshipToApplicant) {
		this.relationshipToApplicant = relationshipToApplicant;
	}

	public void updateAutomaticPaymentInfo(AutomaticPayment automaticPayment){

	}

}