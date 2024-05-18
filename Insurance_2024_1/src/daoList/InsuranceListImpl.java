package daoList;

import java.util.ArrayList;

import IF.InsuranceList;
import domain.Insurance;

/**
 * @author yeil9
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
public class InsuranceListImpl implements InsuranceList {

	private ArrayList<Insurance> insuranceList;
	public Insurance m_Insurance;

	public InsuranceListImpl(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param insurance
	 */
	public void add(Insurance insurance){

	}

	/**
	 * 
	 * @param insuranceID
	 */
	public void delete(int insuranceID){

	}

	/**
	 * 
	 * @param insuranceID
	 */
	public Insurance retrieve(int insuranceID){
		return null;
	}

	/**
	 * 
	 * @param insuranceID
	 * @param insurance
	 */
	public void update(int insuranceID, Insurance insurance){

	}

}