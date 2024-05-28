package domain;

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