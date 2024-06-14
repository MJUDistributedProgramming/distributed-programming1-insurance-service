package domain;
public class Assignment  {
	private String assignmentDate;
	private String assignmentLocation;
	public Assignment (){}
	public void finalize() throws Throwable {}
	// set & get
	public String getAssignmentDate() {return assignmentDate;}
	public void setAssignmentDate(String assignmentDate) {this.assignmentDate = assignmentDate;}
	public String getAssignmentLocation() {return assignmentLocation;}
	public void setAssignmentLocation(String assignmentLocation) {this.assignmentLocation = assignmentLocation;}
}