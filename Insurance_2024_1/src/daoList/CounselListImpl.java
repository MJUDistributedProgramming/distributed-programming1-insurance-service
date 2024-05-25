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

	public void add(Counsel counsel){
		for (Counsel c: counselList) {
			if (c.getCounselID() == counsel.getCounselID()) {
				System.out.println("[error] Counsel ID duplicate. Please try again");
				return;
			}
		}
		this.counselList.add(counsel);
		System.out.println("\"[success] Successfully requested Counsel!\"");
	}

	public void delete(int counselID){
		for (Counsel counsel : counselList) {
			if (counsel.getCounselID() == counselID) {
				counselList.remove(counsel);
				System.out.println("\"[success] Successfully deleted Counsel!\"");
				return;
			}
		}
		System.out.println("\"[error] The counsel ID does not exist.\"");
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
	
	public void update(Counsel counsel, int counselID){

	}

}