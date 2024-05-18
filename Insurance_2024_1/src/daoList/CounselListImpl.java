package daoList;

import java.util.ArrayList;

import IF.CounselList;
import domain.Counsel;

/**
 * @author yeil9
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public class CounselListImpl implements CounselList {

	private ArrayList<Counsel> counselList;
	public Counsel m_Counsel;

	public CounselListImpl(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param counsel
	 */
	public void add(Counsel counsel){

	}

	/**
	 * 
	 * @param counselID
	 */
	public void delete(int counselID){

	}

	/**
	 * 
	 * @param counselID
	 */
	public Counsel retrieve(int counselID){
		return null;
	}

	/**
	 * 
	 * @param counsel
	 * @param counselID
	 */
	public void update(Counsel counsel, int counselID){

	}

}