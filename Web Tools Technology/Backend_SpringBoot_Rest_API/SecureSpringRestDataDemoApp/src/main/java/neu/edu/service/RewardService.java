package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.reward.RewardModel;
import neu.edu.dao.ProjectDao;
import neu.edu.dao.RewardDao;
import neu.edu.entity.Project;
import neu.edu.entity.Reward;

@Service
public class RewardService {
	
	@Autowired
	private RewardDao rewardDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Transactional
	public List<RewardModel> findAll() {
		return rewardDao.findAll().stream().map(x -> {
			RewardModel temp = new RewardModel();
			temp.setProjectId(x.getProject().getProjectid());
			temp.setRewardId(x.getRewardId());
			temp.setMinAmt(x.getMinAmt());
			temp.setText(x.getText());
			return temp;
		}).collect(Collectors.toList());
	}
	
	@Transactional
	public RewardModel createReward(RewardModel rewardModel) {

		Project project = projectDao.findOne(rewardModel.getProjectId());
//		List<Reward> allreward=rewardDao.findByProjectProjectid(rewardModel.getProjectId());
//		System.out.println("-------------------"+getBackers(allreward)+"-------------");
		
		RewardModel rewardProfile = null;

		if (project != null) {
			
			Reward r=new Reward();
			r.setText(rewardModel.getText());
			r.setMinAmt(rewardModel.getMinAmt());
			r.setProject(project);
			r = rewardDao.save(r);
			
			rewardProfile = new RewardModel();
			rewardProfile.setProjectId(r.getProject().getProjectid());
			rewardProfile.setText(r.getText());
			rewardProfile.setMinAmt(r.getMinAmt());
			rewardProfile.setRewardId(r.getRewardId());
		} else {
			return rewardProfile;
		}

		return rewardProfile;

	}
	
	@Transactional
	public boolean updateReward(Integer rewardId,RewardModel rewardModel) {
		Reward r = rewardDao.findOne(rewardId);
		if(r != null){
			
			if((Integer)rewardModel.getMinAmt()!=null){
				r.setMinAmt(rewardModel.getMinAmt());
			}
			if(rewardModel.getText()!=null){
				r.setText(rewardModel.getText());
			}
			
			rewardDao.save(r);
			return true;
		}else{
			return false;
		}
	}
 
		 @Transactional
		 public boolean deleteReward(Integer rewardId) {
			 
			 Reward toBeDeleted = rewardDao.findOne(rewardId);
			 	
			 	if(toBeDeleted!=null && toBeDeleted.getFundings().size()<=0){
			 		
			 		rewardDao.delete(toBeDeleted);
					return true;
			 	}
				return false;
		 }
	
		 public int getBackers(List<Reward> l){
			 
			 return l.size();
		 }
}
