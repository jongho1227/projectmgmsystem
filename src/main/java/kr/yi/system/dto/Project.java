package kr.yi.system.dto;

public class Project {
	private int serialNumber;
	private String projectName;
	private String content;
	private String startDate;
	private String endDate;
	private String currentState;
	
	
	public Project() {
	}
	
	public Project(int serialNumber) {
		super();
		this.serialNumber = serialNumber;
	}

	public Project(String projectName, String text, String startDate, String endDate, String currentState) {
		super();
		this.projectName = projectName;
		this.content = text;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currentState = currentState;
	}
	
	public Project(int serialNumber, String projectName, String content, String startDate, String endDate,
			String currentState) {
		super();
		this.serialNumber = serialNumber;
		this.projectName = projectName;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currentState = currentState;
	}

	public int getSerialNumber() {
		return serialNumber;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	@Override
	public String toString() {
		return "Project [serialNumber=" + serialNumber + ", projectName=" + projectName + ", content=" + content
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", currentState=" + currentState + "]";
	}
	
	
	
}
