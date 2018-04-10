package neu.edu.controller.reward;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.service.RewardService;

@RestController
@RequestMapping(path="/reward")
public class RewardController {
	
	@Autowired
	private RewardService rewardService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public List<RewardModel> findAll() {
		return rewardService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createReward(@RequestBody @Valid RewardModel rewardModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Reward Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		RewardModel rewardProfile = null;
		if ((rewardProfile = rewardService.createReward(rewardModel)) != null) {
			responseEntity = new ResponseEntity<>(rewardProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{rewardId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateReward(@NotNull @PathVariable("rewardId") Integer rewardId,
			@RequestBody RewardModel rewardModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Reward update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		if (rewardService.updateReward(rewardId, rewardModel)) {
			responseEntity = new ResponseEntity<>("Reward update Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{rewardId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteReward(@NotNull @PathVariable("rewardId") Integer rewardId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Reward delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (rewardService.deleteReward(rewardId)) {
			responseEntity = new ResponseEntity<>("Reward Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}
	
}
