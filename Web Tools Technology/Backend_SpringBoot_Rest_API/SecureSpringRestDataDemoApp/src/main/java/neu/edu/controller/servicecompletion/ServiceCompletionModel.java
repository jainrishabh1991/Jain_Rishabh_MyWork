package neu.edu.controller.servicecompletion;


public class ServiceCompletionModel {
	
	private Integer serviceCompletionId;
	private Integer servicebidId;
	private int progress;
	private String description;
	
	public Integer getServiceCompletionId() {
		return serviceCompletionId;
	}
	public void setServiceCompletionId(Integer serviceCompletionId) {
		this.serviceCompletionId = serviceCompletionId;
	}
	public Integer getServicebidId() {
		return servicebidId;
	}
	public void setServicebidId(Integer servicebidId) {
		this.servicebidId = servicebidId;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
