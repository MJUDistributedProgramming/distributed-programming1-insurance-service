package IF;

import java.util.ArrayList;

import domain.Counsel;

public interface CounselList {

	public boolean add(Counsel counsel);
	public boolean delete(int counselID);
	public Counsel retrieve(int counselID);
	public boolean update(Counsel counsel, int counselID);
	public ArrayList<Counsel> retrieveByCustomerID(int customerId);
	public ArrayList<Counsel> retrieveAll();
	public ArrayList<Counsel> retrieveByEmployeeId(int employeeId);
}