package listImpl;
import java.util.ArrayList;
import IF.BusinessStraegyList;
import domain.BusinessStraegy;
import exception.DuplicateIDException;

public class BusinessStraegyListImpl implements BusinessStraegyList {
    private ArrayList<BusinessStraegy> businessStraegyList;
    public BusinessStraegy m_BusinessStraegy;

    public BusinessStraegyListImpl(){
        businessStraegyList = new ArrayList<>();
    }

    public void finalize() throws Throwable {

    }

    public String add(BusinessStraegy businessStraegy) throws DuplicateIDException {
        for (BusinessStraegy bs : businessStraegyList) {
            if (bs.getStrategyID() == businessStraegy.getStrategyID()) {
                throw new DuplicateIDException();
            }
        }
        this.businessStraegyList.add(businessStraegy);
        return "[success] 새로운 경영전략이 등록되었습니다.";
    }

    public String deleteById(int id){
        BusinessStraegy deleteBusinessStraegy = null;
        for (BusinessStraegy bs : businessStraegyList) {
            if (bs.getStrategyID() == id) {
                deleteBusinessStraegy = bs;
            }
        }
        if (deleteBusinessStraegy == null) {
            return "[error] 해당 id의 경영전략이 존재하지 않습니다.";
        }
        businessStraegyList.remove(deleteBusinessStraegy);
        return "[success] 해당 경영전략이 삭제되었습니다.";
    }

    public ArrayList<BusinessStraegy> retrieveAll(){
        return businessStraegyList;
    }

    public BusinessStraegy retrieveById(int id){
        for (BusinessStraegy bs : businessStraegyList) {
            if (bs.getStrategyID() == id) return bs;
        }
        return null;
    }

    public String update(int id, BusinessStraegy businessStraegy){
        int index = 0;
        for (BusinessStraegy bs : businessStraegyList) {
            if (bs.getStrategyID() == businessStraegy.getStrategyID()) {
                businessStraegyList.set(index, businessStraegy);
                return "[success] 경영전략이 수정되었습니다.";
            }
            index++;
        }
        return "[error] 해당 id의 경영전략이 존재하지 않습니다.";
    }
}
