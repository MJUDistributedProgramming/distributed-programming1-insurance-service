package IF;
import java.util.ArrayList;
import domain.Regulation;
import exception.DuplicateIDException;
public interface RegulationList {
	public String add(Regulation Regulation) throws DuplicateIDException ;
	public String deleteById(int id);
	public ArrayList<Regulation> retrieveAll();
	public Regulation retrieveById(int id);
	public String update(int id, Regulation Regulation);
}