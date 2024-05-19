package daoList;

import java.util.ArrayList;

import IF.PaymentList;
import domain.Contract;
import domain.Payment;

/**
 * @author yeil9
 * @version 1.0
 * @created 16-5-2024 오후 6:54:57
 */
public class PaymentListImpl implements PaymentList {

	private ArrayList<Payment> paymentList;
	public Payment m_Payment;

	public PaymentListImpl(){
		this.paymentList = new ArrayList<>();

	}

	public void finalize() throws Throwable {

	}

	public void add(Payment Payment){
		for (Payment payment : paymentList) {
			if (payment.getContractID() == Payment.getContractID()) {
				System.out.println("[error] Payment ID duplicate. Please try again");
				return;
			}
		}
		this.paymentList.add(Payment);
		System.out.println("\"[success] Successfully Create Payment!\"");
	}

	public void delete(int paymentID){
		for (Payment payment : paymentList) {
			if (payment.getPaymentID() == paymentID) {
				paymentList.remove(payment);
				System.out.println("\"[success] Successfully deleted this Payment!\"");
				return;
			}
		}
		System.out.println("\"[error] The payment id does not exist.\"");
	}

	public Payment retrieve(int paymentID){
		for (Payment payment: paymentList) {
			if (payment.getPaymentID() == paymentID) {
				return payment;
			}
		}
		return null;
	}
	
	public ArrayList<Payment> retrieveAll(){
		return this.paymentList;
	}
	
	public ArrayList<Payment> retrieveByCustomerID(int customerID){
		ArrayList<Payment> customerPayment = new ArrayList<>();
		for (Payment payment: paymentList) {
			if (payment.getCustomerID() == customerID) {
				customerPayment.add(payment);
			}
		}
		return customerPayment;
	}

	public void update(Payment payment, int paymentID){

	}

}