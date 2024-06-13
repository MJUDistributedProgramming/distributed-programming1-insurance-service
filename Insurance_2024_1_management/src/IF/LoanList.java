package IF;
import java.util.ArrayList;
import domain.Loan;
import exception.DuplicateIDException;
public interface LoanList {
	public String add(Loan Loan) throws DuplicateIDException ;
	public String deleteById(int id);
	public ArrayList<Loan> retrieveAll();
	public Loan retrieveById(int id);
	public String update(int id, Loan Loan);
}