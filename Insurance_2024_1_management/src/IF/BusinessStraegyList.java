package IF;
import java.util.ArrayList;
import domain.BusinessStraegy;
import exception.DuplicateIDException;
public interface BusinessStraegyList {
	public String add(BusinessStraegy BusinessStraegy) throws DuplicateIDException;
	public String deleteById(int id);
	public ArrayList<BusinessStraegy> retrieveAll();
	public BusinessStraegy retrieveById(int id);
	public String update(int id, BusinessStraegy BusinessStraegy);
}