package domain;
public class AutomaticPayment {
	private String accountNum;
	private String applicantName;
	private String applicantRRN;
	private String paymentCompanyName;
	private String relationshipToApplicant;
	public AutomaticPayment(){}
	public String toString() {
		return "-- 자동 이체 정보 --\n" +
	            "계좌 번호: " + accountNum + "\n"+
	            "신청자 명: " + applicantName + "\n"+
	            "신청자 RRN: " + applicantRRN + "\n"+
	            "은행 이름: " + paymentCompanyName + "\n"+
	            "신청인과의 관계: =" + relationshipToApplicant +"\n";
	}
	public void finalize() throws Throwable {}
	public String getAccountNum() {return accountNum;}
	public String getApplicantName() {return applicantName;}
	public String getApplicantRRN() {return applicantRRN;}
	public String getPaymentCompanyName() {return paymentCompanyName;}
	public String getRelationshipToApplicant() {return relationshipToApplicant;}
	public void setRelationshipToApplicant(String relationshipToApplicant) {this.relationshipToApplicant = relationshipToApplicant;}
	public void setApplicantName(String applicantName) {this.applicantName = applicantName;}
	public void setApplicantRRN(String applicantRRN) {this.applicantRRN = applicantRRN;}
	public void setPaymentCompanyName(String paymentCompanyName) {this.paymentCompanyName = paymentCompanyName;}
	public void setAccountNum(String accountNum) {this.accountNum = accountNum;}
	public void updateAutomaticPaymentInfo(AutomaticPayment automaticPayment){}
}