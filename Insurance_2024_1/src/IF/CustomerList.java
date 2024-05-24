package IF;
import java.util.ArrayList;
import domain.Customer;
public interface CustomerList {
	public String add(Customer Customer);
	public String delete(int id);
	public Customer retrieveById(int id);
	public ArrayList<Customer> retrieveAll();
	public void update(int id, Customer Customer);
}