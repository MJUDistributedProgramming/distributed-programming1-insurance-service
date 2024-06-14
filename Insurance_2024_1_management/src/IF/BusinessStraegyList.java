package IF;
import java.util.ArrayList;
import domain.BusinessStrategy;
import exception.DuplicateIDException;
public interface BusinessStraegyList {
	public String add(BusinessStrategy BusinessStraegy) throws DuplicateIDException;
	public String deleteById(int id);
	public ArrayList<BusinessStrategy> retrieveAll();
	public BusinessStrategy retrieveById(int id);
	public String update(int id, BusinessStrategy BusinessStraegy);
}