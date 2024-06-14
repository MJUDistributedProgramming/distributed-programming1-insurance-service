package listImpl;
import java.util.ArrayList;
import IF.AssetManagementList;
import domain.AssetManagement;
import exception.DuplicateIDException;
public class AssetManagementListImpl implements AssetManagementList {
    private ArrayList<AssetManagement> assetManagementList;
    public AssetManagement m_AssetManagement;
    public AssetManagementListImpl(){
        assetManagementList = new ArrayList<>();
    }
    public void finalize() throws Throwable {}
    public String add(AssetManagement AssetManagement) throws DuplicateIDException {
        for (AssetManagement assetManagement : assetManagementList) {
            if (assetManagement.getAssetManagementID() == AssetManagement.getAssetManagementID()) throw new DuplicateIDException();
        }
        this.assetManagementList.add(AssetManagement);
        return "[success] 새로운 자산운용정보가 등록되었습니다.";
    }
    public String deleteById(int id){
        AssetManagement deleteAssetManagement = null;
        for (AssetManagement assetManagement : assetManagementList) {
            if (assetManagement.getAssetManagementID() == id)deleteAssetManagement = assetManagement;
        }
        if (deleteAssetManagement == null) return "[error] 해당 id의 자산운용정보가 존재하지 않습니다.";
        assetManagementList.remove(deleteAssetManagement);
        return "[success] 해당 자산운용정보가 삭제되었습니다.";
    }
    public ArrayList<AssetManagement> retrieveAll(){return assetManagementList;}
    public AssetManagement retrieveById(int id){
        for (AssetManagement assetManagement : assetManagementList) {
            if (assetManagement.getAssetManagementID() == id) return assetManagement;
        }
        return null;
    }
    public String update(int id, AssetManagement AssetManagement){
        int index = 0;
        for (AssetManagement assetManagement : assetManagementList) {
            if (assetManagement.getAssetManagementID() == AssetManagement.getAssetManagementID()) {
                assetManagementList.set(index, AssetManagement);
                return "[success] 자산운용정보가 수정되었습니다.";
            }
            index++;
        }
        return "[error] 해당 id의 자산운용이 존재하지 않습니다.";
    }
	@Override
	public ArrayList<AssetManagement> retrieveByAssetManagementStatus(String assetManagementStatus) {
		ArrayList<AssetManagement> assetManagementListByStatus = new ArrayList<>();
		for (AssetManagement assetManagement : assetManagementList) {
			if (assetManagement.getAssetManagementStatus().equals(assetManagementStatus)) {
				assetManagementListByStatus.add(assetManagement);
			}
		}
		return assetManagementListByStatus;
	}
}
