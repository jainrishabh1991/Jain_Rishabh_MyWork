package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import neu.edu.controller.testimonial.TestimonialModel;
import neu.edu.dao.ProjectDao;
import neu.edu.dao.TestimonialDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Project;
import neu.edu.entity.Role;
import neu.edu.entity.Testimonial;
import neu.edu.entity.User;

@Service
public class TestimonialService {
	
	@Autowired
	private TestimonialDao testimonialDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Transactional
	public List<TestimonialModel> findAll() {
		
		return testimonialDao.findAll().stream().map(x -> {
			TestimonialModel temp = new TestimonialModel();
			temp.setTestimonialId(x.getTestimonialId());
			temp.setProjectId(x.getProject().getProjectid());
			temp.setUserId(x.getUser().getUserId());
			temp.setTestimonial(x.getTestimonial());
			temp.setPostDate(x.getPostDate());
			temp.setRating(x.getRating());
			return temp;
		}).collect(Collectors.toList());
	}
	
	@Transactional
	public TestimonialModel postTestimonial(TestimonialModel testimonialModel) {

		Project project = projectDao.findOne(testimonialModel.getProjectId());
		User user = userDao.findOne(testimonialModel.getUserId());
		
		TestimonialModel testimonialProfile = null;

		if (project != null && user != null) {
			
			Testimonial testimonial=new Testimonial();
			testimonial.setPostDate(new Date());
			testimonial.setProject(project);
			testimonial.setUser(user);
			testimonial.setTestimonial(testimonialModel.getTestimonial());
			testimonial.setRating(testimonialModel.getRating());
			testimonial = testimonialDao.save(testimonial);
			
			testimonialProfile = new TestimonialModel();
			testimonialProfile.setProjectId(testimonial.getProject().getProjectid());
			testimonialProfile.setTestimonial(testimonial.getTestimonial());
			testimonialProfile.setRating(testimonial.getRating());

		} else {
			return testimonialProfile;
		}

		return testimonialProfile;

	}
	 
	 @Transactional
		public boolean updateTestimonial(Integer userId,TestimonialModel testimonialModel) {
			
		 	
		 	Testimonial test = testimonialDao.findOne(testimonialModel.getTestimonialId());
			if(test != null){
				
				if(testimonialModel.getProjectId()!=null){
					Project project = projectDao.findOne(testimonialModel.getProjectId());
					test.setProject(project);;
				}
				
				if(testimonialModel.getUserId()!=null){
					User user = userDao.findOne(testimonialModel.getUserId());
					test.setUser(user);
				}
				
				if(testimonialModel.getTestimonial()!=null){
					test.setTestimonial(testimonialModel.getTestimonial());
				}
				
				if(testimonialModel.getRating()!=null){
					test.setRating(testimonialModel.getRating());
				}
				
				testimonialDao.save(test);
				return true;
			}else{
				return false;
			}
		}
	 
	 @Transactional
	 public boolean deleteTestimonial(Integer testimonialId) {
		 
		 	Testimonial toBeDeleted=testimonialDao.findOne(testimonialId);
		 	
		 	if(toBeDeleted!=null){
		 		testimonialDao.delete(toBeDeleted);
				return true;
		 	}
			return false;
	 }
	
	
}
