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
	public AutomaticPayment m_AutomaticPayment;
	public BankPayment m_BankPayment;
	public CardPayment m_CardPayment;

	public PaymentInfo(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param paymentInfo
	 */
	public void updatePaymentInfo(PaymentInfo paymentInfo){

	}

}