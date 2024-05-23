package domain;


/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:57
 */
public class Rule {

	private String ruleDetail;
	private int ruleID;
	private String ruleName;

	public Rule(){

	}

	public String getRuleDetail() {
		return ruleDetail;
	}

	public void setRuleDetail(String ruleDetail) {
		this.ruleDetail = ruleDetail;
	}

	public int getRuleID() {
		return ruleID;
	}

	public void setRuleID(int ruleID) {
		this.ruleID = ruleID;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public void finalize() throws Throwable {
	}
	
}