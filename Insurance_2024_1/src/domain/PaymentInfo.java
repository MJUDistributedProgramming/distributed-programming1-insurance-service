package domain;


/**
 * @author User
 * @version 1.0
 * @created 16-5-2024 오후 6:54:57
 */
public class PaymentInfo {

	private AutomaticPayment automaticPayment;
	private BankPayment bankPayment;
	private CardPayment cardPayment;
	private int fixedMonthlyPayment;
	private String fixedMonthlyPaymentDate;
	private int paymentInfoID;
	private String paymentType; // 추가함
	// associations
	public AutomaticPayment m_AutomaticPayment;
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public BankPayment m_BankPayment;
	public CardPayment m_CardPayment;

	public PaymentInfo(){

	}

	public void finalize() throws Throwable {

	}

	public void updatePaymentInfo(PaymentInfo paymentInfo){

	}

	public AutomaticPayment getAutomaticPayment() {
		return automaticPayment;
	}

	public void setAutomaticPayment(AutomaticPayment automaticPayment) {
		this.automaticPayment = automaticPayment;
	}

	public BankPayment getBankPayment() {
		return bankPayment;
	}

	public void setBankPayment(BankPayment bankPayment) {
		this.bankPayment = bankPayment;
	}

	public CardPayment getCardPayment() {
		return cardPayment;
	}

	public void setCardPayment(CardPayment cardPayment) {
		this.cardPayment = cardPayment;
	}

	public int getFixedMonthlyPayment() {
		return fixedMonthlyPayment;
	}

	public void setFixedMonthlyPayment(int fixedMonthlyPayment) {
		this.fixedMonthlyPayment = fixedMonthlyPayment;
	}

	public String getFixedMonthlyPaymentDate() {
		return fixedMonthlyPaymentDate;
	}

	public void setFixedMonthlyPaymentDate(String fixedMonthlyPaymentDate) {
		this.fixedMonthlyPaymentDate = fixedMonthlyPaymentDate;
	}

	public int getPaymentInfoID() {
		return paymentInfoID;
	}

	public void setPaymentInfoID(int paymentInfoID) {
		this.paymentInfoID = paymentInfoID;
	}

	
}