package IF;

import java.util.ArrayList;

import domain.DepositClosureDetail;
import exception.DuplicateIDException;

public interface DepositClosureDetailList {
	public String add(DepositClosureDetail DepositClosureDetail) throws DuplicateIDException;
	public String deleteById(int id);
	public ArrayList<DepositClosureDetail> retrieveAll();
	public DepositClosureDetail retrieveById(int id);
	public String update(int id, DepositClosureDetail DepositClosureDetail);
}