package daoList;

import java.util.ArrayList;

import IF.EmployeeList;
import domain.Customer;
import domain.Employee;

/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
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
	public void add(Employee Employee){
		for (Employee employee : EmployeeList) {
			if (employee.getEmployeeID() == Employee.getEmployeeID()) {
				System.out.println("[error] ID duplicate. Please sign up again");
				return;
			}
		}
		this.EmployeeList.add(Employee);
		System.out.println("\"[success] Successfully Sign Up!\"");
	}
	public void delete(int id){
		for (Employee employee : EmployeeList) {
			if (employee.getEmployeeID() == id) {
				EmployeeList.remove(employee);
				System.out.println("\"[success] Successfully deleted your membership!\"");
				return;
			}
		}
	}
	public Employee retrieve(int id){
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