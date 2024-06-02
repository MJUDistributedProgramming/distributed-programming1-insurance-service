package domain;


/**
 * @author Win10
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
public class Guarantee {

	private String description;
	private String guaranteeName;
	private int maxCoverage;

	public Guarantee(){

	}

	public void finalize() throws Throwable {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGuaranteeName() {
		return guaranteeName;
	}

	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}

	public int getMaxCoverage() {
		return maxCoverage;
	}

	public void setMaxCoverage(int maxCoverage) {
		this.maxCoverage = maxCoverage;
	}

}