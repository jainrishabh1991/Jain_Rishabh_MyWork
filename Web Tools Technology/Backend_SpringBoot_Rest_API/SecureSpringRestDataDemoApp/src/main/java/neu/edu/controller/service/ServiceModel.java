package neu.edu.controller.service;


public class ServiceModel {
	
	private Integer serviceId;
	private Integer projectId;
	private String text;
	private Integer maxAmt;
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getMaxAmt() {
		return maxAmt;
	}
	public void setMaxAmt(Integer maxAmt) {
		this.maxAmt = maxAmt;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	
}
