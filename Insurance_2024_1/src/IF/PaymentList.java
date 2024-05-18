package IF;

import domain.Payment;

/**
 * @author yeil9
 * @version 1.0
 * @created 16-5-2024 오후 6:54:57
 */
public interface PaymentList {

	/**
	 * 
	 * @param Payment
	 */
	public void add(Payment Payment);

	/**
	 * 
	 * @param paymentID
	 */
	public void delete(int paymentID);

	/**
	 * 
	 * @param paymentID
	 */
	public Payment retrieve(int paymentID);

	/**
	 * 
	 * @param payment
	 * @param paymentID
	 */
	public void update(Payment payment, int paymentID);

}