package listImpl;
import java.util.ArrayList;
import IF.DepositClosureDetailList;
import domain.DepositClosureDetail;
import exception.DuplicateIDException;
public class DepositClosureDetailListImpl implements DepositClosureDetailList {
    private ArrayList<DepositClosureDetail> depositClosureDetailList;
    public DepositClosureDetail m_DepositClosureDetail;
    public DepositClosureDetailListImpl(){
        depositClosureDetailList = new ArrayList<>();
    }
    public void finalize() throws Throwable {}
    public String add(DepositClosureDetail depositClosureDetail) throws DuplicateIDException {
        for (DepositClosureDetail detail : depositClosureDetailList) {
            if (detail.getDepositClosureDetailId() == depositClosureDetail.getDepositClosureDetailId()) throw new DuplicateIDException();
        }
        this.depositClosureDetailList.add(depositClosureDetail);
        return "[success] 새로운 원수예금마감정보가 등록되었습니다.";
    }
    public String deleteById(int id){
        DepositClosureDetail deleteDetail = null;
        for (DepositClosureDetail detail : depositClosureDetailList) {
            if (detail.getDepositClosureDetailId() == id)  deleteDetail = detail;
        }
        if (deleteDetail == null) return "[error] 해당 id의 원수예금마감정보가 존재하지 않습니다.";
        depositClosureDetailList.remove(deleteDetail);
        return "[success] 해당 원수예금마감정보가 삭제되었습니다.";
    }
    public ArrayList<DepositClosureDetail> retrieveAll(){return depositClosureDetailList;}
    public DepositClosureDetail retrieveById(int id){
        for (DepositClosureDetail detail : depositClosureDetailList) {
            if (detail.getDepositClosureDetailId() == id) return detail;
        }
        return null;
    }
    public String update(int id, DepositClosureDetail depositClosureDetail){
        int index = 0;
        for (DepositClosureDetail detail : depositClosureDetailList) {
            if (detail.getDepositClosureDetailId() == depositClosureDetail.getDepositClosureDetailId()) {
                depositClosureDetailList.set(index, depositClosureDetail);
                return "[success] 원수예금마감정보가 수정되었습니다.";
            }
            index++;
        }
        return "[error] 해당 id의 원수예금마감정보가 존재하지 않습니다.";
    }
}