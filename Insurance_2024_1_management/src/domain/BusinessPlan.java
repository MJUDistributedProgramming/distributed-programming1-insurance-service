package domain;


/**
 * @author Owner
 * @version 1.0
 * @created 13-6-2024 오후 1:59:28
 */
public class BusinessPlan {

	private String asset;
	private String budget;
	private int businessPlanID;
	private int employeeID;
	private String InvestmentPeriod;
	private String targetProfit;

	public BusinessPlan(){

	}

	public void finalize() throws Throwable {

	}
	// set & get

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public int getBusinessPlanID() {
		return businessPlanID;
	}

	public void setBusinessPlanID(int businessPlanID) {
		this.businessPlanID = businessPlanID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getInvestmentPeriod() {
		return InvestmentPeriod;
	}

	public void setInvestmentPeriod(String investmentPeriod) {
		InvestmentPeriod = investmentPeriod;
	}

	public String getTargetProfit() {
		return targetProfit;
	}

	public void setTargetProfit(String targetProfit) {
		this.targetProfit = targetProfit;
	}
	
}