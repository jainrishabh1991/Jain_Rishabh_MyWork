package neu.edu.controller.servicebid;



public class ServicebidModel {
	
	private Integer serviceBidId;
	private Integer startupId;
	private int bidAmt;
	private Integer isAssigned;
	private Integer serviceId;
	
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getServiceBidId() {
		return serviceBidId;
	}
	public void setServiceBidId(Integer serviceBidId) {
		this.serviceBidId = serviceBidId;
	}
	
	public Integer getStartupId() {
		return startupId;
	}
	public void setStartupId(Integer startupId) {
		this.startupId = startupId;
	}
	public int getBidAmt() {
		return bidAmt;
	}
	public void setBidAmt(int bidAmt) {
		this.bidAmt = bidAmt;
	}
	public Integer getIsAssigned() {
		return isAssigned;
	}
	public void setIsAssigned(Integer isAssigned) {
		this.isAssigned = isAssigned;
	}
	
	
}
