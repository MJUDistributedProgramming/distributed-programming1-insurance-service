package domain;

public class BankPayment {
	private String payerName;
	private String payerPhoneNum;

	public BankPayment(){}
	public void finalize() throws Throwable {}
	public void updateBankPaymentInfo(BankPayment bankPayment){}
	public String getPayerName() {return payerName;}
	public String getPayerPhoneNum() {return payerPhoneNum;}
	public void setPayerName(String payerName) {this.payerName = payerName;}
	public void setPayerPhoneNum(String payerPhoneNum) {this.payerPhoneNum = payerPhoneNum;}
}