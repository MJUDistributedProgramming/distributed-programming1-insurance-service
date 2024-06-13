package listImpl;
import java.util.ArrayList;
import IF.LoanApplicationList;
import domain.Customer;
import domain.LoanApplication;
import exception.DuplicateIDException;
public class LoanApplicationListImpl implements LoanApplicationList {
	private ArrayList<LoanApplication> loanApplicationList;
	public LoanApplication m_LoanApplication;
	public LoanApplicationListImpl(){
		loanApplicationList = new ArrayList<>();
	}
	public void finalize() throws Throwable {

	}
	public String add(LoanApplication LoanApplication) throws DuplicateIDException{
		for (LoanApplication loanApplication : loanApplicationList) {
			if (loanApplication.getLoanApplicationID() == LoanApplication.getLoanApplicationID()) {
				throw new DuplicateIDException();
			}
		}
		this.loanApplicationList.add(LoanApplication);
		return "[success] 새로운 대출신청정보가 등록되었습니다.";
	}
	public String deleteById(int id){
		LoanApplication deleteLoanApplication = null;
		for (LoanApplication loanApplication : loanApplicationList) {
			if (loanApplication.getCustomerID() == id) {
				deleteLoanApplication = loanApplication;
			}
		}
		if (deleteLoanApplication==null) {
			return "[error] 해당 id의 대출신청정보가 존재하기 않습니다.";
		}
		loanApplicationList.remove(deleteLoanApplication);
		return "[success] 해당 대출신청정보가 삭제되었습니다.";
	}
	public ArrayList<LoanApplication> retrieveAll(){
		return loanApplicationList;
	}
	public LoanApplication retrieveById(int id){
		for (LoanApplication ㅣoanApplication : loanApplicationList) {
			if (ㅣoanApplication.getCustomerID() == id) return ㅣoanApplication;
		}
		return null;
	}
	public String update(int id, LoanApplication LoanApplication){
		int index = 0;
		for (LoanApplication loanApplication : loanApplicationList) {
			if (loanApplication.getLoanApplicationID() == LoanApplication.getLoanApplicationID()) {
				loanApplicationList.set(index, LoanApplication);
				return "[success] 새로운 대출신청정보가 수정되었습니다.";
			}
			index++;
		}
		return "[error] 해당 id의 대출신청이 존재하지 않습니다.";
	}
	@Override
	public ArrayList<LoanApplication> retrieveByLoanStatus(String loanstatus1) {
		ArrayList<LoanApplication> LoanApplicationListByStatus = new ArrayList<>();
		for (LoanApplication loanApplication : loanApplicationList) {
			if (loanApplication.getLoanStatus().equals(loanstatus1)) {
				LoanApplicationListByStatus.add(loanApplication);
			}
		}
		return LoanApplicationListByStatus;
	}
}