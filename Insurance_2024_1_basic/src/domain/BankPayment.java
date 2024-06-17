package domain;
public class BankPayment {
	private String payerName;
	private String payerPhoneNum;
	public BankPayment(){}
	public String toString() {
		return "-- 계좌 정보 -- \n" +
	            "계좌 주 이름: " + payerName +"\n"+
	            "계좌 주 전화번호: " + payerPhoneNum + "\n";
	}
	public void finalize() throws Throwable {}
	public void updateBankPaymentInfo(BankPayment bankPayment){}
	public String getPayerName() {return payerName;}
	public String getPayerPhoneNum() {return payerPhoneNum;}
	public void setPayerName(String payerName) {this.payerName = payerName;}
	public void setPayerPhoneNum(String payerPhoneNum) {this.payerPhoneNum = payerPhoneNum;}
}