package neu.edu.controller.testimonial;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TestimonialModel {
	
	private Integer testimonialId;
	private Integer projectId;
	private Integer userId;
	private String testimonial;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date postDate;
	private Integer rating;
	public Integer getTestimonialId() {
		return testimonialId;
	}
	public void setTestimonialId(Integer testimonialId) {
		this.testimonialId = testimonialId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTestimonial() {
		return testimonial;
	}
	public void setTestimonial(String testimonial) {
		this.testimonial = testimonial;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
	
}
