package neu.edu.entity;
// Generated 10 Dec, 2017 5:27:37 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Funding generated by hbm2java
 */
@Entity
@Table(name = "funding", catalog = "crowdfunding")
public class Funding implements java.io.Serializable {

	private Integer fundingid;
	private Reward reward;
	private User user;
	private Integer quantity;
	private Integer total;

	public Funding() {
	}

	public Funding(Reward reward, User user) {
		this.reward = reward;
		this.user = user;
	}

	public Funding(Reward reward, User user, Integer quantity, Integer total) {
		this.reward = reward;
		this.user = user;
		this.quantity = quantity;
		this.total = total;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "fundingid", unique = true, nullable = false)
	public Integer getFundingid() {
		return this.fundingid;
	}

	public void setFundingid(Integer fundingid) {
		this.fundingid = fundingid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rewardid", nullable = false)
	public Reward getReward() {
		return this.reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "total")
	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}