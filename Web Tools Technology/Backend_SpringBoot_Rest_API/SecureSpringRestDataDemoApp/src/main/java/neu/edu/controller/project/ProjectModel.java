package neu.edu.controller.project;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ProjectModel {
	
	private Integer projectId;
	private Integer categoryId;
	private Integer locationId;
	private Integer userId;
	private String title;
	private String description;
	private String website;
	private Integer goalAmt;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	private String imageLink;
	private Integer status;
	private Integer receivedAmt;
	private Integer backersCount;
	private Integer isEnabled;
	private String reason;
	
	public ProjectModel(){
		
	}
	
	public ProjectModel(Integer projectId){
		this.projectId=projectId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getGoalAmt() {
		return goalAmt;
	}

	public void setGoalAmt(Integer goalAmt) {
		this.goalAmt = goalAmt;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getReceivedAmt() {
		return receivedAmt;
	}

	public void setReceivedAmt(Integer receivedAmt) {
		this.receivedAmt = receivedAmt;
	}

	public Integer getBackersCount() {
		return backersCount;
	}

	public void setBackersCount(Integer backersCount) {
		this.backersCount = backersCount;
	}

	public Integer getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
