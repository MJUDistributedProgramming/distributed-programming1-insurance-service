package daoList;

import java.util.ArrayList;

import IF.CompensationList;
import domain.Accident;
import domain.Compensation;
import domain.Contract;

/**
 * @author junkyulee
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public class CompensationListImpl implements CompensationList {

	private ArrayList<Compensation> compensationList;
	public Compensation m_Compensation;

	public CompensationListImpl() {
		this.compensationList = new ArrayList<Compensation>();

	}

	public void finalize() throws Throwable {

	}

	public void add(Compensation compensation){
		for (Compensation cp : compensationList) {
			if (cp.getCompensationID() == compensation.getCompensationID()) {
				System.out.println("[error] Compensation ID duplicate. Please try again");
				return;
			}
		}
		this.compensationList.add(compensation);
		System.out.println("\"[success] Successfully Create Compensation!\"");
	}

	public void delete(int compensationID){
		for (Compensation compensation : compensationList) {
			if (compensation.getCompensationID() == compensationID) {
				compensationList.remove(compensation);
				System.out.println("\"[success] Successfully deleted Compensation!\"");
				return;
			}
		}
		System.out.println("\"[error] The Compensation ID does not exist.\"");
	}

	public Compensation retrieve(int compensationID){
		for (Compensation compensation : compensationList) {
			if (compensation.getCompensationID() == compensationID) {
				return compensation;
			}
		}
		return null;
	}
	
	public ArrayList<Compensation> retrieveByCustomerID(int customerID){
		ArrayList<Compensation> customerCompensation = new ArrayList<Compensation>();
		for (Compensation compensation : compensationList) {
			if (compensation.getCustomerID() == customerID) {
				customerCompensation.add(compensation);
			}
		}
		return customerCompensation;
	}
	
	public ArrayList<Compensation> retrieveAll(){
		return this.compensationList;
	}

	public void update(Compensation compensation, int compensationID){

	}

}