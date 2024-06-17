package domain;
public class CardPayment {
	private String cardNum;
	private String cvcNum;
	private String password;
	public CardPayment(){}
	public String toString() {
		return "-- 카드 정보 --\n" +
	            "카드 번호: " + cardNum + "\n"+
	            "CVC 번호: " + cvcNum + "\n"+
	            "비밀번호: " + password + "\n";
	}
	public void finalize() throws Throwable {}
	public void updateCardPaymentInfo(CardPayment cardPayment){}
	public String getCardNum() {return cardNum;}
	public String getCvcNum() {return cvcNum;}
	public String getPassword() {return password;}
	public void setCvcNum(String cvcNum) {this.cvcNum = cvcNum;}
	public void setCardNum(String cardNum) {this.cardNum = cardNum;}
	public void setPassword(String password) {this.password = password;}
}