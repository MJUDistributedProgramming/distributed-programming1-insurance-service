package IF;
import java.util.ArrayList;
import domain.Contract;
public interface ContractList {
	public String add(Contract Contract);
	public String deleteById(int id);
	public Contract retrieveById(int id);
	public ArrayList<Contract> retrieveAll();
	public void update(int id, Contract Contract);
}