package daoList;

import java.util.ArrayList;

import IF.CompensationList;
import domain.Accident;
import domain.Compensation;
import domain.Contract;

public class CompensationListImpl implements CompensationList {

	private ArrayList<Compensation> compensationList;
	public Compensation m_Compensation;

	public CompensationListImpl() {
		this.compensationList = new ArrayList<Compensation>();
	}

	public void finalize() throws Throwable {

	}

	public boolean add(Compensation compensation){
		for (Compensation cp : compensationList) {
			if (cp.getCompensationID() == compensation.getCompensationID()) {
				return false;
			}
		}
		this.compensationList.add(compensation);
		return true;
	}

	public boolean deleteById(int compensationID){
		Compensation deletedCompensation = new Compensation();
		for (Compensation compensation : compensationList) {
			if (compensation.getCompensationID() == compensationID) {
				deletedCompensation = compensation;
			}
		}
		return compensationList.remove(deletedCompensation);
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