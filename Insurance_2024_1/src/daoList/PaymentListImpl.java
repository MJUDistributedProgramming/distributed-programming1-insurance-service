package daoList;

import java.util.ArrayList;

import IF.PaymentList;
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

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param Payment
	 */
	public void add(Payment Payment){

	}

	/**
	 * 
	 * @param paymentID
	 */
	public void delete(int paymentID){

	}

	/**
	 * 
	 * @param paymentID
	 */
	public Payment retrieve(int paymentID){
		return null;
	}

	/**
	 * 
	 * @param payment
	 * @param paymentID
	 */
	public void update(Payment payment, int paymentID){

	}

}