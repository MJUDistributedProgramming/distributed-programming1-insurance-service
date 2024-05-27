package IF;
import java.util.ArrayList;
import domain.Customer;
public interface CustomerList {
	public boolean add(Customer Customer);
	public boolean deleteById(int id);
	public Customer retrieveById(int id);
	public ArrayList<Customer> retrieveAll();
	public void update(int id, Customer Customer);
}