package daoList;
import java.util.ArrayList;
import IF.EmployeeList;
import domain.Customer;
import domain.Employee;
public class EmployeeListImpl implements EmployeeList {
	private ArrayList<Employee> EmployeeList;
	public Employee m_Employee;
	public EmployeeListImpl(){
		EmployeeList = new ArrayList<>();
	}
	public void finalize() throws Throwable {
	}
	public ArrayList<Employee> retrieveAll(){
		return EmployeeList;
	}
	public String add(Employee Employee){
		for (Employee employee : EmployeeList) {
			if (employee.getEmployeeID() == Employee.getEmployeeID()) {
				return "[error] ID duplicate. Please sign up again";
			}
		}
		this.EmployeeList.add(Employee);
		return "[success] Successfully Sign Up!";
	}
	public String delete(int id){
		for (Employee employee : EmployeeList) {
			if (employee.getEmployeeID() == id) {
				EmployeeList.remove(employee);
			}
		}
		return "[success] Successfully deleted your membership!";
	}
	public Employee retrieveById(int id){
		for (Employee employee : EmployeeList) {
			if (employee.getEmployeeID() == id) {
				return employee;
			}
		}
		return null;
	}
	public void update(int id, Employee Employee){

	}
}