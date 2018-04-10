package neu.edu.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import neu.edu.controller.service.ServiceModel;
import neu.edu.dao.ProjectDao;
import neu.edu.dao.ServiceDao;
import neu.edu.entity.Project;


@Service
public class ServiceService {
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Transactional
	public List<ServiceModel> findAll() {
		return serviceDao.findAll().stream().map(x -> {
			ServiceModel temp = new ServiceModel();
			temp.setProjectId(x.getProject().getProjectid());
			temp.setText(x.getText());
			temp.setMaxAmt(x.getMaxAmt());
			temp.setServiceId(x.getServiceId());
			return temp;
		}).collect(Collectors.toList());
	}
	
	@Transactional
	public ServiceModel createService(ServiceModel serviceModel) {

		Project project = projectDao.findOne(serviceModel.getProjectId());
		ServiceModel serviceProfile = null;

		if (project != null) {
			
			neu.edu.entity.Service service=new neu.edu.entity.Service();
			service.setProject(project);
			service.setText(serviceModel.getText());
			service.setMaxAmt(serviceModel.getMaxAmt());
			service = serviceDao.save(service);
			
			serviceProfile = new ServiceModel();
			serviceProfile.setProjectId(service.getProject().getProjectid());
			serviceProfile.setText(service.getText());
		} else {
			return serviceProfile;
		}

		return serviceProfile;

	}
	
	@Transactional
	public boolean updateService(Integer serviceId,ServiceModel serviceModel) {
		neu.edu.entity.Service service = serviceDao.findOne(serviceId);
		if(service != null){
			
			if(serviceModel.getProjectId()!=null){
				Project project = projectDao.findOne(serviceModel.getProjectId());
				service.setProject(project);
			}
			
			if(serviceModel.getText()!=null){
				service.setText(serviceModel.getText());
			}
			
			if(serviceModel.getMaxAmt()!=null){
				service.setMaxAmt(serviceModel.getMaxAmt());
			}
			serviceDao.save(service);
			return true;
		}else{
			return false;
		}
	}
 
		 @Transactional
		 public boolean deleteService(Integer serviceId) {
			 
			 neu.edu.entity.Service toBeDeleted=serviceDao.findOne(serviceId);
			 	
			 	if(toBeDeleted!=null && toBeDeleted.getServicebids().size()<=0){
			 		
			 		serviceDao.delete(toBeDeleted);
					return true;
			 	}
				return false;
		 }
		 
		 @Transactional
		 public List<ServiceModel> findDeadlineService() {
			
			 List<ServiceModel> deadline=new ArrayList<>(); 
			 List<neu.edu.entity.Service> services=serviceDao.findAll();
			 for(neu.edu.entity.Service service:services){
				 Date endDate =service.getProject().getEndDate();
				 Date todaysDate = new Date(2017,12,16);
				 long diff=endDate.getTime()-todaysDate.getTime();
				 if(TimeUnit.MILLISECONDS.toDays(diff)<11){
					 ServiceModel sx =new ServiceModel();
					 sx.setMaxAmt(service.getMaxAmt());
					 sx.setProjectId(service.getProject().getProjectid());
					 sx.setText(service.getText());
					 deadline.add(sx);
				 }
			 }

			 return deadline;
		}
		 
		 
		 @Transactional
		 public List<ServiceModel> findUserService(Integer userId) {
			
			 List<Project> projects=projectDao.findByUserUserId(userId);
			 List<neu.edu.entity.Service> slist=new ArrayList<>();
			 for(Project p:projects){
				 slist.addAll(serviceDao.findByProjectProjectid(p.getProjectid()));
			 }
			 
			 return slist.stream().map(x -> {
					ServiceModel temp = new ServiceModel();
					temp.setProjectId(x.getProject().getProjectid());
					temp.setText(x.getText());
					temp.setMaxAmt(x.getMaxAmt());
					temp.setServiceId(x.getServiceId());
					return temp;
				}).collect(Collectors.toList());
		}
	
}
