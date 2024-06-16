package domain;
public class CancerHealth extends Insurance {
	private String categoryOfCancer;
	public CancerHealth(){
	}
	public String getCategoryOfCancer() {
		return categoryOfCancer;
	}
	public void setCategoryOfCancer(String categoryOfCancer) {
		this.categoryOfCancer = categoryOfCancer;
	}
	public void finalize() throws Throwable {
		super.finalize();
	}
}