package daoList;

import java.util.ArrayList;
import java.util.Iterator;

import IF.CustomerDB;
import domain.Customer;
import domain.Employee;

/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
public class CustomerDBImpl implements CustomerDB {
	private ArrayList<Customer> customerList;
	private String DBAccesskey;
	public Customer m_Customer;
	public ArrayList<Customer> retrieveAll(){
		return customerList;
	}
	public CustomerDBImpl(){
		customerList = new ArrayList<>();
	}
	public void finalize() throws Throwable {

	}
	public void add(Customer Customer){
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == Customer.getCustomerID()) {
				System.out.println("[error] ID duplicate. Please sign up again");
				return;
			}
		}
		this.customerList.add(Customer);
		System.out.println("\"[success] Successfully Sign Up!\"");
	}
	public void delete(int id){
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == id) {
				customerList.remove(customer);
				System.out.println("\"[success] Successfully deleted your membership!\"");
				return;
			}
		}
	}
	public Customer retrieve(int id){
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == id) return customer;
		}
		return null;
	}
	public void update(int id, Customer Customer){

	}
}