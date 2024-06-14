package domain;
public class Regulation {
	private String postedDate;
	private String regulationContent;
	private int regulationID;
	private String regulationTitle;
	private String updateDate;
	private int updateWriterID;
	private int writerID;
	public Regulation() {}
	public void finalize() throws Throwable {}
	public String getPostedDate() {return postedDate;}
	public void setPostedDate(String postedDate) {this.postedDate = postedDate;}
	public String getRegulationContent() {return regulationContent;}
	public void setRegulationContent(String regulationContent) {this.regulationContent = regulationContent;}
	public int getRegulationID() {return regulationID;}
	public void setRegulationID(int regulationID) {this.regulationID = regulationID;}
	public String getRegulationTitle() {return regulationTitle;}
	public void setRegulationTitle(String regulationTitle) {this.regulationTitle = regulationTitle;}
	public String getUpdateDate() {return updateDate;}
	public void setUpdateDate(String updateDate) {this.updateDate = updateDate;}
	public int getUpdateWriterID() {return updateWriterID;}
	public void setUpdateWriterID(int updateWriterID) {this.updateWriterID = updateWriterID;}
	public int getWriterID() {return writerID;}
	public void setWriterID(int writerID) {this.writerID = writerID;}
}