package neu.edu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.funding.FundingModel;
import neu.edu.dao.FundingDao;
import neu.edu.dao.ProjectDao;
import neu.edu.dao.RewardDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Funding;
import neu.edu.entity.Project;
import neu.edu.entity.Reward;
import neu.edu.entity.User;


@Service
public class FundingService {

	@Autowired
	private FundingDao fundingDao;
	
	@Autowired
	private RewardDao rewardDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Transactional
	public List<FundingModel> findAll() {
		return fundingDao.findAll().stream().map(x -> {
			FundingModel temp = new FundingModel();
			temp.setQuantity(x.getQuantity());
			temp.setFundingid(x.getFundingid());
			temp.setRewardId(x.getReward().getRewardId());
			temp.setTotal(x.getTotal());
			temp.setUserId(x.getUser().getUserId());
			return temp;
		}).collect(Collectors.toList());
	}
	
	@Transactional
	public FundingModel createFunding(FundingModel fundingModel) {

		Reward r=rewardDao.findOne(fundingModel.getRewardId());
		User u=userDao.findOne(fundingModel.getUserId());
		Project project=projectDao.findOne(r.getProject().getProjectid());
		
		FundingModel fundingProfile = null;

		if (u != null && r != null && (getFunding(r.getProject().getProjectid())+fundingModel.getQuantity()* r.getMinAmt())<= project.getGoalAmt()) {
			
			Funding fun=new Funding();
			fun.setQuantity(fundingModel.getQuantity());
			fun.setTotal(fundingModel.getQuantity()* r.getMinAmt());
			fun.setReward(r);
			fun.setUser(u);
			fun = fundingDao.save(fun);
			project.setBackersCount(getBackers(r.getProject().getProjectid()));
			project.setReceivedAmt(getFunding(r.getProject().getProjectid()));
			project=projectDao.save(project);
			fundingProfile = new FundingModel();
			fundingModel.setTotal(fun.getTotal());
			fundingModel.setFundingid(fun.getFundingid());
		} else {
			return fundingProfile;
		}

		return fundingProfile;

	}
	
	@Transactional
	public boolean updateFunding(Integer fundingId,FundingModel fundingModel) {
		
		Funding fun=fundingDao.findOne(fundingModel.getFundingid());
		
		if(fun != null){
			
			if(fundingModel.getQuantity()!=null){
				fun.setQuantity(fundingModel.getQuantity());
				fun.setTotal(fun.getReward().getMinAmt()*fundingModel.getQuantity());
			}
			
			fundingDao.save(fun);
			return true;
		}else{
			return false;
		}
	}
 
		 @Transactional
		 public boolean deleteFunding(Integer fundingId) {
			 
			 Funding toBeDeleted=fundingDao.findOne(fundingId);
			 	
			 	if(toBeDeleted!=null){
			 		
			 		fundingDao.delete(toBeDeleted);
					return true;
			 	}
				return false;
		 }
	public Integer getBackers(Integer projectId){
		
		List<Funding> fundings=fundingDao.findAll();
		int backers=0;
		for(Funding f:fundings){
			if(f.getReward().getProject().getProjectid()==projectId){
				backers++;
			}
		}
		return backers;
	}
	
	public Integer getFunding(Integer projectId){
			List<Funding> fundings=fundingDao.findAll();
			int funds=0;
			for(Funding f:fundings){
				if(f.getReward().getProject().getProjectid()==projectId){
					funds+=f.getTotal();
				}
			}
			return funds;
	}
	
	@Transactional
	public List<FundingModel> getFunders(Integer projectId){
		
		List<Funding> fundings=new ArrayList<>();
		for(Funding f:fundingDao.findAll()){
			if(f.getReward().getProject().getProjectid()==projectId){
				fundings.add(f);
			}
		}
		return fundings.stream().map(x -> {
			FundingModel temp = new FundingModel();
			temp.setQuantity(x.getQuantity());
			temp.setFundingid(x.getFundingid());
			temp.setRewardId(x.getReward().getRewardId());
			temp.setTotal(x.getTotal());
			temp.setUserId(x.getUser().getUserId());
			return temp;
		}).collect(Collectors.toList());
    }
	
	public List<FundingModel> getFundersByUser(Integer userId){
		
		List<Project> projects=projectDao.findByUserUserId(userId);
		List<FundingModel> fun=new ArrayList<>();
		for(Project p:projects){
			 fun.addAll(getFunders(p.getProjectid()));
		 }
		return fun;
	}
		 
}
