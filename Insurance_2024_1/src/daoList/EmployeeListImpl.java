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
	public boolean add(Employee Employee){
		for (Employee employee : EmployeeList) {
			if (employee.getEmployeeID() == Employee.getEmployeeID()) {
				return false;
			}
		}
		this.EmployeeList.add(Employee);
		return true;
	}
	public boolean deleteById(int id){
		Employee deleteEmployee = null;
		for (Employee employee : EmployeeList) {
			if (employee.getEmployeeID() == id) {
				deleteEmployee = employee;
			}
		}
		EmployeeList.remove(deleteEmployee);
		return true;
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