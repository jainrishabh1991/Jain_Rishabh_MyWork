package neu.edu.controller.funding;


public class FundingModel {
	
	private Integer fundingid;
	private Integer rewardId;
	private Integer userId;
	private Integer quantity;
	private Integer total;
	
	public Integer getFundingid() {
		return fundingid;
	}
	public void setFundingid(Integer fundingid) {
		this.fundingid = fundingid;
	}
	public Integer getRewardId() {
		return rewardId;
	}
	public void setRewardId(Integer rewardId) {
		this.rewardId = rewardId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
