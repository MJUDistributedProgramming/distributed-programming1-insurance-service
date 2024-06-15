package domain;
public class AssetManagement {
	private int assetManagementID;
	private String assetManagementStatus;
	private BusinessPlan businessPlan;
	private String CompetitorTrend;
	private String constraint;
	private int employeeID;
	private String investmentGoal;
	private String investmentStrategy;
	private String marketInfomation;
	private String prospect;
	private String rickPlan;
	private String risk;
	public AssetManagement(){}
	public void finalize() throws Throwable {}
	// set & get
	public String getAssetManagementStatus() {return assetManagementStatus;}
	public int getAssetManagementID() {return assetManagementID;}
	public void setAssetManagementID(int assetManagementID) {this.assetManagementID = assetManagementID;}
	public void setAssetManagementStatus(String assetManagementStatus) {this.assetManagementStatus = assetManagementStatus;}
	public BusinessPlan getBusinessPlan() {return businessPlan;}
	public void setBusinessPlan(BusinessPlan businessPlan) {this.businessPlan = businessPlan;}
	public String getCompetitorTrend() {return CompetitorTrend;}
	public void setCompetitorTrend(String competitorTrend) {CompetitorTrend = competitorTrend;}
	public String getConstraint() {return constraint;}
	public void setConstraint(String constraint) {this.constraint = constraint;}
	public int getEmployeeID() {return employeeID;}
	public void setEmployeeID(int employeeID) {this.employeeID = employeeID;}
	public String getInvestmentGoal() {return investmentGoal;}
	public void setInvestmentGoal(String investmentGoal) {this.investmentGoal = investmentGoal;}
	public String getInvestmentStrategy() {return investmentStrategy;}
	public void setInvestmentStrategy(String investmentStrategy) {this.investmentStrategy = investmentStrategy;}
	public String getMarketInfomation() {return marketInfomation;}
	public void setMarketInfomation(String marketInfomation) {this.marketInfomation = marketInfomation;}
	public String getProspect() {return prospect;}
	public void setProspect(String prospect) {this.prospect = prospect;}
	public String getRickPlan() {return rickPlan;}
	public void setRickPlan(String rickPlan) {this.rickPlan = rickPlan;}
	public String getRisk() {return risk;}
	public void setRisk(String risk) {this.risk = risk;}
}