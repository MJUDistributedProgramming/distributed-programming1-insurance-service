package listImpl;
import java.util.ArrayList;
import IF.LoanList;
import domain.Loan;
import exception.DuplicateIDException;

public class LoanListImpl implements LoanList {
    private ArrayList<Loan> loanList;
    public Loan m_Loan;

    public LoanListImpl(){
        loanList = new ArrayList<>();
    }

    public void finalize() throws Throwable {

    }

    public String add(Loan Loan) throws DuplicateIDException {
        for (Loan loan : loanList) {
            if (loan.getLoanID() == Loan.getLoanID()) {
                throw new DuplicateIDException();
            }
        }
        this.loanList.add(Loan);
        return "[success] 새로운 대출정보가 등록되었습니다.";
    }

    public String deleteById(int id){
        Loan deleteLoan = null;
        for (Loan loan : loanList) {
            if (loan.getLoanID() == id) {
                deleteLoan = loan;
            }
        }
        if (deleteLoan == null) {
            return "[error] 해당 id의 대출정보가 존재하지 않습니다.";
        }
        loanList.remove(deleteLoan);
        return "[success] 해당 대출정보가 삭제되었습니다.";
    }

    public ArrayList<Loan> retrieveAll(){
        return loanList;
    }

    public Loan retrieveById(int id){
        for (Loan loan : loanList) {
            if (loan.getLoanID() == id) return loan;
        }
        return null;
    }

    public String update(int id, Loan Loan){
        int index = 0;
        for (Loan loan : loanList) {
            if (loan.getLoanID() == Loan.getLoanID()) {
                loanList.set(index, Loan);
                return "[success] 대출정보가 수정되었습니다.";
            }
            index++;
        }
        return "[error] 해당 id의 대출이 존재하지 않습니다.";
    }
}