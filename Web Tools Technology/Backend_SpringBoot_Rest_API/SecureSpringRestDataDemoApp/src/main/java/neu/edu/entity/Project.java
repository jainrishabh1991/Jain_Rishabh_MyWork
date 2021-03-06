package neu.edu.entity;
// Generated 10 Dec, 2017 5:27:37 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Project generated by hbm2java
 */
@Entity
@Table(name = "project", catalog = "crowdfunding")
public class Project implements java.io.Serializable {

	private Integer projectid;
	private Category category;
	private Location location;
	private User user;
	private String title;
	private String description;
	private String website;
	private int goalAmt;
	private Date startDate;
	private Date endDate;
	private String imageLink;
	private int status;
	private int receivedAmt;
	private int backersCount;
	private Integer isEnabled;
	private String reason;
	private Set<Testimonial> testimonials = new HashSet<Testimonial>(0);
	private Set<Service> services = new HashSet<Service>(0);
	private Set<Reward> rewards = new HashSet<Reward>(0);

	public Project() {
	}

	public Project(Category category, Location location, User user, String title, String description, int goalAmt,
			Date startDate, Date endDate, int status, int receivedAmt, int backersCount) {
		this.category = category;
		this.location = location;
		this.user = user;
		this.title = title;
		this.description = description;
		this.goalAmt = goalAmt;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.receivedAmt = receivedAmt;
		this.backersCount = backersCount;
	}

	public Project(Category category, Location location, User user, String title, String description, String website,
			int goalAmt, Date startDate, Date endDate, String imageLink, int status, int receivedAmt, int backersCount,
			Integer isEnabled, String reason, Set<Testimonial> testimonials, Set<Service> services,
			Set<Reward> rewards) {
		this.category = category;
		this.location = location;
		this.user = user;
		this.title = title;
		this.description = description;
		this.website = website;
		this.goalAmt = goalAmt;
		this.startDate = startDate;
		this.endDate = endDate;
		this.imageLink = imageLink;
		this.status = status;
		this.receivedAmt = receivedAmt;
		this.backersCount = backersCount;
		this.isEnabled = isEnabled;
		this.reason = reason;
		this.testimonials = testimonials;
		this.services = services;
		this.rewards = rewards;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "projectid", unique = true, nullable = false)
	public Integer getProjectid() {
		return this.projectid;
	}

	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", nullable = false)
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "website", length = 45)
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column(name = "goal_amt", nullable = false)
	public int getGoalAmt() {
		return this.goalAmt;
	}

	public void setGoalAmt(int goalAmt) {
		this.goalAmt = goalAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false, length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false, length = 10)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "image_link")
	public String getImageLink() {
		return this.imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "received_amt", nullable = false)
	public int getReceivedAmt() {
		return this.receivedAmt;
	}

	public void setReceivedAmt(int receivedAmt) {
		this.receivedAmt = receivedAmt;
	}

	@Column(name = "backers_count", nullable = false)
	public int getBackersCount() {
		return this.backersCount;
	}

	public void setBackersCount(int backersCount) {
		this.backersCount = backersCount;
	}

	@Column(name = "is_enabled")
	public Integer getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Column(name = "reason")
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<Testimonial> getTestimonials() {
		return this.testimonials;
	}

	public void setTestimonials(Set<Testimonial> testimonials) {
		this.testimonials = testimonials;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<Service> getServices() {
		return this.services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<Reward> getRewards() {
		return this.rewards;
	}

	public void setRewards(Set<Reward> rewards) {
		this.rewards = rewards;
	}

}
