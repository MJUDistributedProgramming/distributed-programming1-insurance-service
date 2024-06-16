package domain;
public class LatePaymentPolicy {
	private int lateFeeRate;
	private String maximumOverduePeriod;
	public LatePaymentPolicy(){
	}
	public void finalize() throws Throwable {
	}
	public int getLateFeeRate() {
		return lateFeeRate;
	}
	public void setLateFeeRate(int lateFeeRate) {
		this.lateFeeRate = lateFeeRate;
	}
	public String getMaximumOverduePeriod() {
		return maximumOverduePeriod;
	}
	public void setMaximumOverduePeriod(String maximumOverduePeriod) {
		this.maximumOverduePeriod = maximumOverduePeriod;
	}
}