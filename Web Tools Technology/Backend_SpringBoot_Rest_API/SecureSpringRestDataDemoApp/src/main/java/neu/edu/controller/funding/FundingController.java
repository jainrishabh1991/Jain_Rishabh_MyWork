package neu.edu.controller.funding;

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

import neu.edu.service.FundingService;
import neu.edu.service.ProjectService;

@RestController
@RequestMapping(path="/funding")
public class FundingController {
	
	@Autowired
	private FundingService fundingService; 
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<FundingModel> findAll() {
		return fundingService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createFunding(@RequestBody @Valid FundingModel fundingModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Funding Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		FundingModel fundingProfile = null;
		if ((fundingProfile = fundingService.createFunding(fundingModel)) != null) {
			responseEntity = new ResponseEntity<>(fundingProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{fundingId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateFunding(@NotNull @PathVariable("fundingId") Integer fundingId,
			@RequestBody FundingModel fundingModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (fundingService.updateFunding(fundingId, fundingModel)) {
			responseEntity = new ResponseEntity<>("Service update Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{fundingId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteFunding(@NotNull @PathVariable("fundingId") Integer fundingId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (fundingService.deleteFunding(fundingId)) {
			responseEntity = new ResponseEntity<>("Service Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}
	@RequestMapping(path = "/{projectId:[0-9]+}", method = RequestMethod.GET)
	public List<FundingModel> getFunders(@NotNull @PathVariable("projectId") Integer projectId) {

		return fundingService.getFunders(projectId);
		
	}
	
	@RequestMapping(path = "/user/{username}", method = RequestMethod.GET)
	public List<FundingModel> getFundersByUser(@NotNull @PathVariable("username") String username) {
		Integer userId=projectService.findUserId(username);
		return fundingService.getFundersByUser(userId);
		
	}
	
}
