package neu.edu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.service.ServiceModel;
import neu.edu.controller.servicebid.ServicebidModel;
import neu.edu.dao.ProjectDao;
import neu.edu.dao.ServiceBidDao;
import neu.edu.dao.ServiceDao;
import neu.edu.dao.StartupDao;
import neu.edu.entity.Project;
import neu.edu.entity.Servicebid;
import neu.edu.entity.Startup;

@Service
public class ServiceBidService {
	
	@Autowired
	private ServiceBidDao serviceBidDao;
	
	@Autowired
	private ServiceDao serviceDao;
	
	
	@Autowired
	private StartupDao startupDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Transactional
	public List<ServicebidModel> findAll() {
		return serviceBidDao.findAll().stream().map(x -> {
			ServicebidModel temp = new ServicebidModel();
			temp.setStartupId(x.getStartup().getStartupId());
			temp.setBidAmt(x.getBidAmt());
			temp.setIsAssigned(x.getIsAssigned());
			temp.setServiceBidId(x.getServiceBidId());
			temp.setServiceId(x.getService().getServiceId());
			return temp;
		}).collect(Collectors.toList());
	}
	
	@Transactional
	public ServicebidModel createBid(ServicebidModel bidModel) {

		Startup startup = startupDao.findOne(bidModel.getStartupId());
		neu.edu.entity.Service service= serviceDao.findOne(bidModel.getServiceId());
		ServicebidModel serviceBidProfile = null;

		if (startup != null && service != null && bidModel.getBidAmt()<=service.getMaxAmt()) {
			
			Servicebid bid=new Servicebid();
			bid.setBidAmt(bidModel.getBidAmt());
			bid.setIsAssigned(bidModel.getIsAssigned());
			bid.setStartup(startup);
			bid.setService(service);
			bid = serviceBidDao.save(bid);
			
			serviceBidProfile = new ServicebidModel();
			serviceBidProfile.setBidAmt(bid.getBidAmt());
			serviceBidProfile.setServiceBidId(bid.getServiceBidId());
		} else {
			return serviceBidProfile;
		}

		return serviceBidProfile;

	}
	
	@Transactional
	public boolean updateBid(Integer bidId,ServicebidModel bidModel) {
		Servicebid bid = serviceBidDao.findOne(bidId);
		if(bid != null){
			
			if((Integer)bidModel.getBidAmt()!=null){
				bid.setBidAmt(bidModel.getBidAmt());
			}
			
			if(bidModel.getIsAssigned()!=null){
				bid.setIsAssigned(bidModel.getIsAssigned());
			}
			
			serviceBidDao.save(bid);
			return true;
		}else{
			return false;
		}
	}
 
		 @Transactional
		 public boolean deleteService(Integer serviceId) {
			 
			 Servicebid toBeDeleted=serviceBidDao.findOne(serviceId);
			 	
			 	if(toBeDeleted!=null && toBeDeleted.getServicecompletions().size()<=0){
			 		
			 		serviceBidDao.delete(toBeDeleted);
					return true;
			 	}
				return false;
		 }
	
		 @Transactional
		 public List<ServicebidModel> findByStartup(Integer StartupId) {
			 
			 
				return serviceBidDao.findByStartupStartupIdAndIsAssigned(StartupId,1).stream().map(x -> {
					ServicebidModel temp = new ServicebidModel();
					temp.setStartupId(x.getStartup().getStartupId());
					temp.setBidAmt(x.getBidAmt());
					temp.setIsAssigned(x.getIsAssigned());
					temp.setServiceBidId(x.getServiceBidId());
					temp.setServiceId(x.getService().getServiceId());
					return temp;
				}).collect(Collectors.toList());
			}
		 
		 @Transactional
			public boolean assignBid(Integer bidId) {
				Servicebid bid = serviceBidDao.findOne(bidId);
				if(bid != null){
					
					bid.setIsAssigned(1);
					serviceBidDao.save(bid);
					return true;
				}else{
					return false;
				}
			}
		 
		 @Transactional
		 public List<ServicebidModel> findUserBid(Integer userId) {
			
			 List<Project> projects=projectDao.findByUserUserId(userId);
			 List<neu.edu.entity.Service> slist=new ArrayList<>();
			 for(Project p:projects){
				 slist.addAll(serviceDao.findByProjectProjectid(p.getProjectid()));
			 }
			 List<Servicebid> bid=new ArrayList<>();
			 for(neu.edu.entity.Service s:slist){
				 
				 bid.addAll(serviceBidDao.findByServiceServiceId(s.getServiceId()));
				 
			 }
			 
			 for(Servicebid sb:bid){
				 
				 System.out.println(sb.getServiceBidId());
				 
			 }
			 
			 return bid.stream().map(x->{
				 
				 ServicebidModel temp = new ServicebidModel();
					temp.setStartupId(x.getStartup().getStartupId());
					temp.setBidAmt(x.getBidAmt());
					temp.setIsAssigned(x.getIsAssigned());
					temp.setServiceBidId(x.getServiceBidId());
					temp.setServiceId(x.getService().getServiceId());
					return temp;
				 
			 }).collect(Collectors.toList());
		}
		 
}
