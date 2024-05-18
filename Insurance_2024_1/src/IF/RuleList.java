package IF;

import domain.Rule;

/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:57
 */
public interface RuleList {

	/**
	 * 
	 * @param rule
	 */
	public void add(Rule rule);

	/**
	 * 
	 * @param ruleID
	 */
	public void delete(int ruleID);

	/**
	 * 
	 * @param ruleID
	 */
	public Rule retrieve(int ruleID);

	/**
	 * 
	 * @param ruleID
	 * @param rule
	 */
	public void update(int ruleID, Rule rule);

}