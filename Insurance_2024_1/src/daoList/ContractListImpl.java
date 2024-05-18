package daoList;

import java.util.ArrayList;

import IF.ContractList;
import domain.Contract;
import domain.Customer;

/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public class ContractListImpl implements ContractList {
	private ArrayList<Contract> ContractList;
	public Contract m_Contract;
	public ContractListImpl(){
		ContractList = new ArrayList<>();
	}
	public void finalize() throws Throwable {

	}
	public ArrayList<Contract> retrieveAll(){
		return ContractList;
	}
	public void add(Contract Contract){
		for (Contract contract : ContractList) {
			if (contract.getContractID() == Contract.getContractID()) {
				System.out.println("[error] Contract ID duplicate. Please try again");
				return;
			}
		}
		this.ContractList.add(Contract);
		System.out.println("\"[success] Successfully Create Contract!\"");
	}
	public void delete(int id){
		for (Contract Contract : ContractList) {
			if (Contract.getContractID() == id) {
				ContractList.remove(Contract);
				System.out.println("\"[success] Successfully deleted this Contract!\"");
				return;
			}
		}
		System.out.println("\"[error] The contract id does not exist.\"");
	}
	public Contract retrieve(int id){
		for (Contract Contract : ContractList) {
			if (Contract.getContractID() == id) {
				return Contract;
			}
		}
		return null;
	}
	public void update(int id, Contract Contract){

	}
}