package IF;
import java.util.ArrayList;
import domain.Employee;
public interface EmployeeList {
	public boolean add(Employee Employee);
	public boolean deleteById(int id);
	public Employee retrieveById(int id);
	public ArrayList<Employee> retrieveAll();
	public void update(int id, Employee Employee);
}