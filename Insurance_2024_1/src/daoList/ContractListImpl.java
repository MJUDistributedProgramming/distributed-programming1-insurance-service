package daoList;
import java.util.ArrayList;
import IF.ContractList;
import domain.Contract;
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
	public boolean add(Contract Contract){
		for (Contract contract : ContractList) {
			if (contract.getContractID() == Contract.getContractID()) {
				return false;
			}
		}
		this.ContractList.add(Contract);
		return true;
	}
	public boolean deleteById(int id){
		for (Contract Contract : ContractList) {
			if (Contract.getContractID() == id) {
				ContractList.remove(Contract);
				return true;
			}
		}
		return false;
	}
	public Contract retrieveById(int id){
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