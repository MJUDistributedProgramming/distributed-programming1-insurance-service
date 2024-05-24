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
	public String add(Customer Customer){
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == Customer.getCustomerID()) {
				return "[error] ID duplicate. Please sign up again";
			}
		}
		this.customerList.add(Customer);
		return "[success] Successfully Sign Up!";
	}
	public String delete(int id){
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == id) {
				customerList.remove(customer);
			}
		}
		return "[success] Successfully deleted your membership!";
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