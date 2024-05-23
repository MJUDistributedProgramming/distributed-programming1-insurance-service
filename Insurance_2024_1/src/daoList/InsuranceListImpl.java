package daoList;

import java.util.ArrayList;

import IF.InsuranceList;
import domain.Insurance;

/**
 * @author yeil9
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
public class InsuranceListImpl implements InsuranceList {

	private ArrayList<Insurance> insuranceList;
	public Insurance m_Insurance;

	public InsuranceListImpl(){
		this.insuranceList = new ArrayList<>();
	}

	public void finalize() throws Throwable {

	}

	public void add(Insurance insurance){
		for (Insurance i: insuranceList) {
			if (i.getInsuranceID() == insurance.getInsuranceID()) {
				System.out.println("[error] Insurance ID duplicate. Please try again");
				return;
			}
		}
		this.insuranceList.add(insurance);
		System.out.println("\"[success] Successfully created Insurance!\"");
	}

	public void delete(int insuranceID) {
		for (Insurance insurance : insuranceList) {
			if (insurance.getInsuranceID() == insuranceID) {
				insuranceList.remove(insurance);
				System.out.println("\"[success] Successfully deleted Insurance!\"");
				return;
			}
		}
		System.out.println("\"[error] The Insurance ID does not exist.\"");
	}

	public Insurance retrieve(int insuranceID) {
		for (Insurance insurance: insuranceList) {
			if (insurance.getInsuranceID() == insuranceID) {
				return insurance;
			}
		}
		return null;
	}
	
	public ArrayList<Insurance> retrieveAll(){
		return this.insuranceList;
	}

	public void update(int insuranceID, Insurance insurance){

	}

}