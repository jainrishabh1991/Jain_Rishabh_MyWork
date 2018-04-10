package neu.edu.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.startup.StartupModel;
import neu.edu.dao.CategoryDao;
import neu.edu.dao.LocationDao;
import neu.edu.dao.ProjectDao;
import neu.edu.dao.ServiceDao;
import neu.edu.dao.StartupDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Category;
import neu.edu.entity.Location;
import neu.edu.entity.Project;
import neu.edu.entity.Startup;
import neu.edu.entity.User;

@Service
public class StartupService {
	
	@Autowired
	private StartupDao startupDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private LocationDao locationDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Transactional
	public List<StartupModel> findAll() {
		
		return startupDao.findAll().stream().map(x -> {
			StartupModel temp = new StartupModel();
			temp.setStartupId(x.getStartupId());
			temp.setCategoryId(x.getCategory().getCategoryId());
			temp.setLocationId(x.getLocation().getLocationId());
			temp.setUserId(x.getUser().getUserId());
			temp.setCompanyName(x.getCompanyName());
			temp.setAbout(x.getAbout());
			temp.setContactPerson(x.getContactPerson());
			temp.setPhoneNumber(x.getPhoneNumber());
			return temp;
		}).collect(Collectors.toList());
	}
	
	@Transactional
	public StartupModel createStartup(StartupModel startupModel) {

		User user = userDao.findOne(startupModel.getUserId());
		Location location=locationDao.findOne(startupModel.getLocationId());
		Category category=categoryDao.findOne(startupModel.getCategoryId());
		
		StartupModel startupProfile = null;

		if (user != null && location != null && category != null) {
			
			Startup startup = new Startup();
			startup.setCategory(category);
			startup.setLocation(location);
			startup.setUser(user);
			startup.setAbout(startupModel.getAbout());
			startup.setCompanyName(startupModel.getCompanyName());
			startup.setContactPerson(startupModel.getContactPerson());
			startup.setPhoneNumber(startupModel.getPhoneNumber());
			startup = startupDao.save(startup);
			
			startupProfile = new StartupModel();
			startupProfile.setStartupId(startup.getStartupId());
			startupProfile.setCompanyName(startup.getCompanyName());
			startupProfile.setAbout(startup.getAbout());
			startupProfile.setUserId(startup.getUser().getUserId());
			startupProfile.setCategoryId(startup.getCategory().getCategoryId());
			
		} else {
			return startupProfile;
		}

		return startupProfile;

	}
	
	@Transactional
	public boolean updateStartup(Integer startupId, StartupModel startupModel) {
		Startup startup = startupDao.findOne(startupId);
		if(startup != null){
			
			if(startupModel.getCategoryId()!=null){
				Category category = categoryDao.findOne(startupModel.getCategoryId());
				startup.setCategory(category);;
			}
			
			if(startupModel.getLocationId() != null){
				Location loc = locationDao.findOne(startupModel.getLocationId());
				startup.setLocation(loc);
			}
			
			if(startupModel.getUserId() != null){
				User user = userDao.findOne(startupModel.getUserId());
				startup.setUser(user);
			}
			
			if(startupModel.getCompanyName() != null){
				startup.setCompanyName(startupModel.getCompanyName());
			}
			
			if(startupModel.getAbout() != null){
				startup.setAbout(startupModel.getAbout());
			}
			
			if(startupModel.getContactPerson() != null){
				startup.setContactPerson(startupModel.getContactPerson());
			}
			
			if(startupModel.getPhoneNumber() != null){
				startup.setPhoneNumber(startupModel.getPhoneNumber());
			}
			startupDao.save(startup);
			return true;
		}else{
			return false;
		}
	}
 
 @Transactional
 public boolean deleteStartup(Integer startupId) {
	 
	 	Startup toBeDeleted=startupDao.findOne(startupId);
	 	
	 	if(toBeDeleted!=null && toBeDeleted.getServicebids().size()<=0){
	 		startupDao.delete(toBeDeleted);
			return true;
	 	}
		return false;
 }
	

 public List<StartupModel> findStartupByUsername(Integer userId){
	 
	 List<Project> projects=projectDao.findByUserUserId(userId);
	 List<Startup> slist=new ArrayList<>();
	 List<Startup> f=new ArrayList<>();
	 for(Project p:projects){
		 slist.addAll(startupDao.findByCategoryCategoryId(p.getCategory().getCategoryId()));
	 }
	 HashSet<Integer> h=new HashSet<>();
	 for(Startup s:slist){
		 if(!h.contains(s.getStartupId())){
			 f.add(s);
			 h.add(s.getStartupId());
		 }
	 }
	 
	 return f.stream().map(x -> {
			StartupModel temp = new StartupModel();
			temp.setStartupId(x.getStartupId());
			temp.setCategoryId(x.getCategory().getCategoryId());
			temp.setLocationId(x.getLocation().getLocationId());
			temp.setUserId(x.getUser().getUserId());
			temp.setCompanyName(x.getCompanyName());
			temp.setAbout(x.getAbout());
			temp.setContactPerson(x.getContactPerson());
			temp.setPhoneNumber(x.getPhoneNumber());
			return temp;
		}).collect(Collectors.toList());
 	}
}
