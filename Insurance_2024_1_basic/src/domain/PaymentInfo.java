package domain;
public class PaymentInfo {
	private AutomaticPayment automaticPayment;
	private BankPayment bankPayment;
	private CardPayment cardPayment;
	private int fixedMonthlyPayment;
	private String fixedMonthlyPaymentDate;
	private int paymentInfoID;
	private String paymentType;
	public PaymentInfo(){}
	public void finalize() throws Throwable {}
	public String toString() {
		String automaticPayment = "";
		if(this.automaticPayment != null) automaticPayment = this.automaticPayment.toString();
		String bankPayment = "";
		if(this.bankPayment != null) bankPayment = this.bankPayment.toString();
		String cardPayment = "";
		if(this.cardPayment != null) cardPayment = this.cardPayment.toString();
		
		return "PaymentInfo{" +
	            automaticPayment +
	            bankPayment +
	            cardPayment +
	            ", fixedMonthlyPayment=" + fixedMonthlyPayment +
	            ", fixedMonthlyPaymentDate='" + fixedMonthlyPaymentDate + '\'' +
	            ", paymentInfoID=" + paymentInfoID +
	            ", paymentType='" + paymentType + '\'' +
	            '}';
	}
	public String getPaymentType() {return paymentType;}
	public AutomaticPayment getAutomaticPayment() {return automaticPayment;}
	public BankPayment getBankPayment() {return bankPayment;}
	public CardPayment getCardPayment() {return cardPayment;}
	public int getFixedMonthlyPayment() {return fixedMonthlyPayment;}
	public String getFixedMonthlyPaymentDate() {return fixedMonthlyPaymentDate;}
	public int getPaymentInfoID() {return paymentInfoID;}
	public void setPaymentType(String paymentType) {this.paymentType = paymentType;}
	public void setAutomaticPayment(AutomaticPayment automaticPayment) {this.automaticPayment = automaticPayment;}
	public void setBankPayment(BankPayment bankPayment) {this.bankPayment = bankPayment;}
	public void setCardPayment(CardPayment cardPayment) {this.cardPayment = cardPayment;}
	public void setFixedMonthlyPayment(int fixedMonthlyPayment) {this.fixedMonthlyPayment = fixedMonthlyPayment;}
	public void setFixedMonthlyPaymentDate(String fixedMonthlyPaymentDate) {this.fixedMonthlyPaymentDate = fixedMonthlyPaymentDate;}
	public void setPaymentInfoID(int paymentInfoID) {this.paymentInfoID = paymentInfoID;}
	public void updatePaymentInfo(PaymentInfo paymentInfo){}
}