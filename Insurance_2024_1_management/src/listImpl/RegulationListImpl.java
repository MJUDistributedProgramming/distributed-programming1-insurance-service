package listImpl;
import java.util.ArrayList;
import IF.RegulationList;
import domain.Regulation;
import exception.DuplicateIDException;
public class RegulationListImpl implements RegulationList {
    private ArrayList<Regulation> regulationList;
    public Regulation m_Regulation;
    public RegulationListImpl(){
        regulationList = new ArrayList<>();
    }
    public void finalize() throws Throwable {}
    public String add(Regulation regulation) throws DuplicateIDException {
        for (Regulation reg : regulationList) {
            if (reg.getRegulationID() == regulation.getRegulationID()) throw new DuplicateIDException();
        }
        this.regulationList.add(regulation);
        return "[success] 새로운 사규가 등록되었습니다.";
    }
    public String deleteById(int id){
        Regulation deleteRegulation = null;
        for (Regulation reg : regulationList) {
            if (reg.getRegulationID() == id)  deleteRegulation = reg;
        }
        if (deleteRegulation == null) return "[error] 해당 id의 사규가 존재하지 않습니다.";
        regulationList.remove(deleteRegulation);
        return "[success] 해당 사규가 삭제되었습니다.";
    }
    public ArrayList<Regulation> retrieveAll(){return regulationList;}
    public Regulation retrieveById(int id){
        for (Regulation reg : regulationList) {
            if (reg.getRegulationID() == id) return reg;
        }
        return null;
    }
    public String update(int id, Regulation regulation){
        int index = 0;
        if (regulation==null) return "[error] 해당 id의 사규가 존재하지 않습니다.";
        for (Regulation reg : regulationList) {
            if (reg.getRegulationID() == regulation.getRegulationID()) {
                regulationList.set(index, regulation);
                return "[success] 사규가 수정되었습니다.";
            }
            index++;
        }
        return "[error] 해당 id의 사규가 존재하지 않습니다.";
    }
}