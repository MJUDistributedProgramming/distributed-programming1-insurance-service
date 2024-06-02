package daoList;

import java.util.ArrayList;

import IF.CounselList;
import domain.Counsel;

public class CounselListImpl implements CounselList {

	private ArrayList<Counsel> counselList;
	public Counsel m_Counsel;

	public CounselListImpl(){
		counselList = new ArrayList<Counsel>();
	}

	public void finalize() throws Throwable {

	}

	public boolean add(Counsel counsel){
		for (Counsel c: counselList) {
			if (c.getCounselID() == counsel.getCounselID()) 
				return false;
		}
		counselList.add(counsel);
		return true;
	}

	public boolean delete(int counselID){
		for (Counsel counsel : counselList) {
			if (counsel.getCounselID() == counselID) {
				counselList.remove(counsel);
				return true;
			}
		}
		return false;
	}
	
	public Counsel retrieve(int counselID) {
		for (Counsel counsel: counselList) {
			if (counsel.getCounselID() == counselID) {
				return counsel;
			}
		}
		return null;
	}

	public ArrayList<Counsel> retrieveByCustomerID(int customerID){
		ArrayList<Counsel> customerCounsel = new ArrayList<>();
		for (Counsel counsel: counselList) {
			if (counsel.getCustomerID() == customerID) {
				customerCounsel.add(counsel);
			}
		}
		return customerCounsel;
	}
	
	public ArrayList<Counsel> retrieveAll(){
		return this.counselList;
	}
	
	public boolean update(Counsel counsel, int counselID){
		return false;
	}

}