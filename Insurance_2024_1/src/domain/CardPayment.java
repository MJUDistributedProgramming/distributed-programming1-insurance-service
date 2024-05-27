package domain;


/**
 * @author yeil9
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public class CardPayment {

	private String cardNum;
	private String cvcNum;
	private String password;

	public CardPayment(){

	}

	public void finalize() throws Throwable {

	}

	public void updateCardPaymentInfo(CardPayment cardPayment){

	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCvcNum() {
		return cvcNum;
	}

	public void setCvcNum(String cvcNum) {
		this.cvcNum = cvcNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}