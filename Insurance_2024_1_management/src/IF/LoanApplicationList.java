package IF;

import java.util.ArrayList;

import domain.LoanApplication;
import exception.DuplicateIDException;
public interface LoanApplicationList {
	public String add(LoanApplication LoanApplication) throws DuplicateIDException;
	public String deleteById(int id);
	public ArrayList<LoanApplication> retrieveAll();
	public LoanApplication retrieveById(int id);
	public String update(int id, LoanApplication LoanApplication);
	public ArrayList<LoanApplication> retrieveByLoanStatus(String loanstatus1);
}