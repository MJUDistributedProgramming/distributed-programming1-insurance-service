package daoList;

import java.util.ArrayList;

import IF.RuleList;
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

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param rule
	 */
	public void add(Rule rule){

	}

	/**
	 * 
	 * @param ruleID
	 */
	public void delete(int ruleID){

	}

	/**
	 * 
	 * @param ruleID
	 */
	public Rule retrieve(int ruleID){
		return null;
	}

	/**
	 * 
	 * @param ruleID
	 * @param rule
	 */
	public void update(int ruleID, Rule rule){

	}

}