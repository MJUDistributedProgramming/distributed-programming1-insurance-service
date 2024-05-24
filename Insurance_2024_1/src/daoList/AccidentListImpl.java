package daoList;

import java.util.ArrayList;

import IF.AccidentList;
import domain.Accident;
import domain.Counsel;
import domain.Payment;

/**
 * @author junkyulee
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public class AccidentListImpl implements AccidentList {

	private ArrayList<Accident> accidentList;
	public Accident m_Accident;

	public AccidentListImpl() {
		this.accidentList = new ArrayList<Accident>();

	}

	public void finalize() throws Throwable {

	}

	public void add(Accident accident) {
		for (Accident ac : accidentList) {
			if (ac.getAccidentID() == accident.getAccidentID()) {
				System.out.println("[error] Accident ID duplicate. Please try again");
				return;
			}
		}
		this.accidentList.add(accident);
		System.out.println("\"[success] Successfully Create Accident!\"");

	}

	public void delete(int accidentID){
		for (Accident accident : accidentList) {
			if (accident.getAccidentID() == accidentID) {
				accidentList.remove(accident);
				System.out.println("\"[success] Successfully deleted Accident!\"");
				return;
			}
		}
		System.out.println("\"[error] The Accident ID does not exist.\"");
	}

	public Accident retrieve(int accidentID){
		for (Accident accident : accidentList) {
			if (accident.getAccidentID() == accidentID) {
				return accident;
			}
		}
		return null;
	}

	public ArrayList<Accident> retrieveByCustomerID(int customerID){
		ArrayList<Accident> customerAccident = new ArrayList<Accident>();
		for (Accident accident: accidentList) {
			if (accident.getCustomerID() == customerID) {
				customerAccident.add(accident);
			}
		}
		return customerAccident;
	}
	
	public ArrayList<Accident> retrieveAll(){
		return this.accidentList;
	}
	
	public void update(Accident accident, int accidentID){

	}

}