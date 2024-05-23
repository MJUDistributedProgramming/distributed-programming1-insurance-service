package daoList;

import java.util.ArrayList;

import IF.RuleList;
import domain.Contract;
import domain.Rule;

/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:57
 */
public class RuleListImpl implements RuleList {

	private ArrayList<Rule> ruleList;
	public Rule m_Rule;

	public RuleListImpl(){
		ruleList = new ArrayList<Rule>();
	}

	public void finalize() throws Throwable {
	}

	
	public void add(Rule rule){
		for(Rule rule1 : ruleList) {
			if(rule1.getRuleID() == rule.getRuleID()) {
				System.out.println("[error] Rule ID duplicate. Please try again");
				return;
			}
		}
		this.ruleList.add(rule);
		System.out.println("\"[success] Successfully Create Rule!\"");

	}

	public void delete(int ruleID){
		for(Rule rule1 : ruleList) {
			if(rule1.getRuleID() == ruleID) {
				this.ruleList.remove(rule1);
				System.out.println("\"[success] Successfully deleted this Rule!\"");
				return;
			}
		}
		System.out.println("\"[error] The rule id does not exist.\"");
	}


	public Rule retrieve(int ruleID){
		for(Rule rule1 : ruleList) {
			if(rule1.getRuleID() == ruleID) {
				return rule1;
			}
		}
		return null;
	}

	
	public void update(int ruleID, Rule rule){

	}

	public ArrayList<Rule> retrieveAll() {
		// TODO Auto-generated method stub
		return ruleList;
	}

}