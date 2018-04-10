package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.servicecompletion.ServiceCompletionModel;
import neu.edu.dao.ServiceBidDao;
import neu.edu.dao.ServiceCompletionDao;

import neu.edu.entity.Servicebid;
import neu.edu.entity.Servicecompletion;


@Service
public class ServiceCompletionService {
	
	@Autowired
	private ServiceBidDao serviceBidDao;
	
	@Autowired
	private ServiceCompletionDao serviceCompletionDao;
	
	
	@Transactional
	public List<ServiceCompletionModel> findAll() {
		return serviceCompletionDao.findAll().stream().map(x -> {
			ServiceCompletionModel temp = new ServiceCompletionModel();
			temp.setDescription(x.getDescription());
			temp.setProgress(x.getProgress());
			temp.setServicebidId(x.getServicebid().getServiceBidId());
			temp.setServiceCompletionId(x.getServiceCompletionId());
			return temp;
		}).collect(Collectors.toList());
	}
	
	@Transactional
	public ServiceCompletionModel createService(ServiceCompletionModel serviceModel) {

		Servicebid serviceBid = serviceBidDao.findOne(serviceModel.getServicebidId());
		ServiceCompletionModel serviceProfile = null;

		if (serviceBid != null && serviceBid.getIsAssigned()==1) {
			
			Servicecompletion sc=new Servicecompletion();
			sc.setDate(new Date());
			sc.setDescription(serviceModel.getDescription());
			sc.setProgress(serviceModel.getProgress());
			sc.setServicebid(serviceBid);
			sc = serviceCompletionDao.save(sc);
			
			serviceProfile = new ServiceCompletionModel();
			serviceProfile.setProgress(sc.getProgress());
			serviceProfile.setServiceCompletionId(sc.getServiceCompletionId());;
		} else {
			return serviceProfile;
		}

		return serviceProfile;

	}
	
	@Transactional
	public boolean updateService(Integer serviceId,ServiceCompletionModel serviceModel) {
		Servicecompletion service = serviceCompletionDao.findOne(serviceId);
		if(service != null){
			
			if((Integer)serviceModel.getProgress()!=null){
				service.setProgress(serviceModel.getProgress());
			}
			
			if(serviceModel.getDescription()!=null){
				service.setDescription(serviceModel.getDescription());
			}
			
			serviceCompletionDao.save(service);
			return true;
		}else{
			return false;
		}
	}
 
		 @Transactional
		 public boolean deleteService(Integer serviceId) {
			 
			 Servicecompletion toBeDeleted=serviceCompletionDao.findOne(serviceId);
			 	
			 	if(toBeDeleted!=null){
			 		serviceCompletionDao.delete(toBeDeleted);
					return true;
			 	}
				return false;
		 }
		 
		 @Transactional
			public ServiceCompletionModel findServiceProgress(Integer serviceBid) {
				
			 Servicecompletion x=serviceCompletionDao.findTop1ByServicebidServiceBidIdOrderByProgressDesc(serviceBid);
			 ServiceCompletionModel temp = new ServiceCompletionModel();
			 if(x!=null){
				 
					temp.setDescription(x.getDescription());
					temp.setProgress(x.getProgress());
					temp.setServicebidId(x.getServicebid().getServiceBidId());
					temp.setServiceCompletionId(x.getServiceCompletionId());
					
			 }
			 return temp;
			 
			}
		 
		 
		 @Transactional
			public List<ServiceCompletionModel> findServiceAllProgress(Integer serviceBid) {
				
			 return serviceCompletionDao.findByServicebidServiceBidIdOrderByProgressDesc(serviceBid).stream().map(x -> {
					ServiceCompletionModel temp = new ServiceCompletionModel();
					temp.setDescription(x.getDescription());
					temp.setProgress(x.getProgress());
					temp.setServicebidId(x.getServicebid().getServiceBidId());
					temp.setServiceCompletionId(x.getServiceCompletionId());
					return temp;
				}).collect(Collectors.toList());
			 
			}
}
