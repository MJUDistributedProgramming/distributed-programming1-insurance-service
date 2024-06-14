package IF;
import java.util.ArrayList;
import domain.AssetManagement;
import exception.DuplicateIDException;
public interface AssetManagementList {
	public String add(AssetManagement AssetManagement) throws DuplicateIDException;
	public String deleteById(int id);
	public ArrayList<AssetManagement> retrieveAll();
	public AssetManagement retrieveById(int id);
	public String update(int id, AssetManagement AssetManagement);
	ArrayList<AssetManagement> retrieveByAssetManagementStatus(String assetManagementStatus);
}