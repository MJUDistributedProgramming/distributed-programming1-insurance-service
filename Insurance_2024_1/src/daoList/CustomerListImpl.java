package daoList;
import java.util.ArrayList;
import IF.CustomerList;
import domain.Customer;
public class CustomerListImpl implements CustomerList {
	private ArrayList<Customer> customerList;
	private String DBAccesskey;
	public Customer m_Customer;
	public ArrayList<Customer> retrieveAll(){
		return customerList;
	}
	public CustomerListImpl(){
		customerList = new ArrayList<>();
	}
	public void finalize() throws Throwable {

	}
	public boolean add(Customer Customer){
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == Customer.getCustomerID()) {
				return false;
			}
		}
		this.customerList.add(Customer);
		return true;
	}
	public boolean deleteById(int id){
		Customer deleteCustomer = null;
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == id) {
				deleteCustomer = customer;
			}
		}
		customerList.remove(deleteCustomer);
		return true;
	}
	public Customer retrieveById(int id){
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == id) return customer;
		}
		return null;
	}
	public void update(int id, Customer Customer){

	}
}