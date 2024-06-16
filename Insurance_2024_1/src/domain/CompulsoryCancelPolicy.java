package domain;
public class CompulsoryCancelPolicy {
	private String cancelReason;
	private int cancelRefund;
	public CompulsoryCancelPolicy(){
	}
	public void finalize() throws Throwable {
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public int getCancelRefund() {
		return cancelRefund;
	}
	public void setCancelRefund(int cancelRefund) {
		this.cancelRefund = cancelRefund;
	}
}