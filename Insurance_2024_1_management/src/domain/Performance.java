package domain;
public class Performance {
	private String projectCompletionRate;
	private String teamLeaderEvaluation;
	private String teamworkScore;
	public Performance(){

	}
	public void finalize() throws Throwable {

	}
	// set & get
	public String getProjectCompletionRate() {
		return projectCompletionRate;
	}
	public void setProjectCompletionRate(String projectCompletionRate) {
		this.projectCompletionRate = projectCompletionRate;
	}
	public String getTeamLeaderEvaluation() {
		return teamLeaderEvaluation;
	}
	public void setTeamLeaderEvaluation(String teamLeaderEvaluation) {
		this.teamLeaderEvaluation = teamLeaderEvaluation;
	}
	public String getTeamworkScore() {
		return teamworkScore;
	}
	public void setTeamworkScore(String teamworkScore) {
		this.teamworkScore = teamworkScore;
	}
}