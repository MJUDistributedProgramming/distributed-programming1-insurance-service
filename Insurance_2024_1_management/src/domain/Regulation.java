package domain;


/**
 * @author Owner
 * @version 1.0
 * @created 13-6-2024 오후 1:59:29
 */
public class Regulation {

	private String postedDate;
	private String RegulationContent;
	private int RegulationID;
	private String RegulationTitle;
	private String updateDate;
	private int updateWriterID;
	private int writerID;

	public Regulation(){

	}

	public void finalize() throws Throwable {

	}

	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

	public String getRegulationContent() {
		return RegulationContent;
	}

	public void setRegulationContent(String regulationContent) {
		RegulationContent = regulationContent;
	}

	public int getRegulationID() {
		return RegulationID;
	}

	public void setRegulationID(int regulationID) {
		RegulationID = regulationID;
	}

	public String getRegulationTitle() {
		return RegulationTitle;
	}

	public void setRegulationTitle(String regulationTitle) {
		RegulationTitle = regulationTitle;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getUpdateWriterID() {
		return updateWriterID;
	}

	public void setUpdateWriterID(int updateWriterID) {
		this.updateWriterID = updateWriterID;
	}

	public int getWriterID() {
		return writerID;
	}

	public void setWriterID(int writerID) {
		this.writerID = writerID;
	}
	
	// set & get
	
}