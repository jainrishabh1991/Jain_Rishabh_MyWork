package neu.edu.service;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import neu.edu.controller.project.ProjectModel;
import neu.edu.dao.CategoryDao;
import neu.edu.dao.FundingDao;
import neu.edu.dao.LocationDao;
import neu.edu.dao.ProjectDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Category;
import neu.edu.entity.Funding;
import neu.edu.entity.Location;
import neu.edu.entity.Project;
import neu.edu.entity.User;


@Service
public class ProjectService {
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private LocationDao locationDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FundingDao fundingDao;
	
	@Transactional
	public List<ProjectModel> findAll() {
		// TODO Auto-generated method stub
		
		return projectDao.findAll().stream().map(x -> {
			ProjectModel temp = new ProjectModel(x.getProjectid());
			temp.setTitle(x.getTitle());
			temp.setDescription(x.getDescription());
			temp.setWebsite(x.getWebsite());
			temp.setGoalAmt(x.getGoalAmt());
			temp.setStartDate(x.getStartDate());
			temp.setEndDate(x.getEndDate());
			temp.setImageLink(x.getImageLink());
			temp.setStatus(x.getStatus());
			temp.setIsEnabled(x.getIsEnabled());
			temp.setReceivedAmt(x.getReceivedAmt());
			temp.setReason(x.getReason());
			temp.setBackersCount(x.getBackersCount());
			temp.setUserId(x.getUser().getUserId());
			temp.setLocationId(x.getLocation().getLocationId());
			temp.setCategoryId(x.getCategory().getCategoryId());
			return temp;
		}).collect(Collectors.toList());
		
	}
	
	@Transactional
	public ProjectModel createProject(ProjectModel projectModel) {
		
		Category c = categoryDao.findOne(projectModel.getCategoryId());
		Location l = locationDao.findOne(projectModel.getLocationId());
		User u = userDao.findOne(projectModel.getUserId());
		
		ProjectModel projectProfile = null;

		if (u != null && l != null && c != null) {
			Project temp = new Project();
			temp.setTitle(projectModel.getTitle());
			temp.setDescription(projectModel.getDescription());
			temp.setWebsite(projectModel.getWebsite());
			temp.setGoalAmt(projectModel.getGoalAmt());
			temp.setStartDate(projectModel.getStartDate());
			temp.setEndDate(projectModel.getEndDate());
			temp.setImageLink(projectModel.getImageLink());
			temp.setStatus(1);
			temp.setIsEnabled(1);
			temp.setReceivedAmt(0);
			temp.setUser(u);
			temp.setLocation(l);
			temp.setCategory(c);
			
			temp = projectDao.save(temp);
			
			projectProfile = new ProjectModel();
			projectProfile.setProjectId(temp.getProjectid());
			projectProfile.setTitle(temp.getTitle());
		} else {
			return projectProfile;
		}

		return projectProfile;

	}
	
	@Transactional
	public boolean updateProject(Integer projectId,ProjectModel projectModel) {
		Project toBeUpdated=projectDao.findOne(projectId);;
		if(toBeUpdated != null){
			
			if(projectModel.getDescription()!=null){
				toBeUpdated.setDescription(projectModel.getDescription());
			}
			if(projectModel.getGoalAmt()!=null){
				toBeUpdated.setGoalAmt(projectModel.getGoalAmt());
			}
			
			projectDao.save(toBeUpdated);
			return true;
		}else{
			return false;
		}
	}
 
		 @Transactional
		 public boolean deleteProject(Integer projectId) {
			 Project toBeDeleted=projectDao.findOne(projectId);
			 	if(toBeDeleted!=null && toBeDeleted.getRewards().size()<=0 && toBeDeleted.getTestimonials().size()<=0 && toBeDeleted.getServices().size()<=0){
			 		
			 		projectDao.delete(toBeDeleted);
					return true;
			 	}
				return false;
		 }
	
		 public List<ProjectModel> findByCategory(Integer categoryId) {
				
				return projectDao.findByCategoryCategoryIdOrderByStartDateAsc(categoryId).stream().map(x -> {
					ProjectModel temp = new ProjectModel(x.getProjectid());
					temp.setTitle(x.getTitle());
					temp.setDescription(x.getDescription());
					temp.setWebsite(x.getWebsite());
					temp.setGoalAmt(x.getGoalAmt());
					temp.setStartDate(x.getStartDate());
					temp.setEndDate(x.getEndDate());
					temp.setImageLink(x.getImageLink());
					temp.setStatus(x.getStatus());
					temp.setIsEnabled(x.getIsEnabled());
					temp.setReceivedAmt(x.getReceivedAmt());
					temp.setReason(x.getReason());
					temp.setBackersCount(x.getBackersCount());
					temp.setUserId(x.getUser().getUserId());
					temp.setLocationId(x.getLocation().getLocationId());
					temp.setCategoryId(x.getCategory().getCategoryId());
					return temp;
				}).collect(Collectors.toList());
		 }
		 
		 public List<ProjectModel> findByUser(Integer userId) {
				// TODO Auto-generated method stub
				
				return projectDao.findByUserUserId(userId).stream().map(x -> {
					ProjectModel temp = new ProjectModel(x.getProjectid());
					temp.setTitle(x.getTitle());
					temp.setDescription(x.getDescription());
					temp.setWebsite(x.getWebsite());
					temp.setGoalAmt(x.getGoalAmt());
					temp.setStartDate(x.getStartDate());
					temp.setEndDate(x.getEndDate());
					temp.setImageLink(x.getImageLink());
					temp.setStatus(x.getStatus());
					temp.setIsEnabled(x.getIsEnabled());
					temp.setReceivedAmt(x.getReceivedAmt());
					temp.setReason(x.getReason());
					temp.setBackersCount(x.getBackersCount());
					temp.setUserId(x.getUser().getUserId());
					temp.setLocationId(x.getLocation().getLocationId());
					temp.setCategoryId(x.getCategory().getCategoryId());
					return temp;
				}).collect(Collectors.toList());
				
			}
		 
		 public Integer findUserId(String username) {
			
				return userDao.findByUsername(username).getUserId();
			}
		 
		 public List<ProjectModel> findProjectByFunder(Integer userId){
			 
			 List<Funding> fun=fundingDao.findByUserUserId(userId);
			 List<Project> fin=new ArrayList<>();
			 HashSet<Integer> h=new HashSet<>();
			 for(Funding f:fun){
					if(!h.contains(f.getReward().getProject().getProjectid())){
						h.add(f.getReward().getProject().getProjectid());
						fin.add(f.getReward().getProject());
					}
				}
			 return fin.stream().map(x -> {
					ProjectModel temp = new ProjectModel(x.getProjectid());
					temp.setTitle(x.getTitle());
					temp.setDescription(x.getDescription());
					temp.setWebsite(x.getWebsite());
					temp.setGoalAmt(x.getGoalAmt());
					temp.setStartDate(x.getStartDate());
					temp.setEndDate(x.getEndDate());
					temp.setImageLink(x.getImageLink());
					temp.setStatus(x.getStatus());
					temp.setIsEnabled(x.getIsEnabled());
					temp.setReceivedAmt(x.getReceivedAmt());
					temp.setReason(x.getReason());
					temp.setBackersCount(x.getBackersCount());
					temp.setUserId(x.getUser().getUserId());
					temp.setLocationId(x.getLocation().getLocationId());
					temp.setCategoryId(x.getCategory().getCategoryId());
					return temp;
				}).collect(Collectors.toList());
		 }
		 
}
