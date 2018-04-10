package neu.edu.controller.servicebid;

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

import neu.edu.dao.ProjectDao;
import neu.edu.service.ProjectService;
import neu.edu.service.ServiceBidService;

@RestController
@RequestMapping(path="/serviceBid")
public class ServiceBidController {
	
	@Autowired
	private ServiceBidService servicebidService; 
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ServicebidModel> findAll() {
		return servicebidService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createBid(@RequestBody @Valid ServicebidModel bidModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("ServiceBid Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		ServicebidModel serviceBidProfile = null;
		if ((serviceBidProfile = servicebidService.createBid(bidModel)) != null) {
			responseEntity = new ResponseEntity<>(serviceBidProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{serviceBidId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateBid(@NotNull @PathVariable("serviceBidId") Integer serviceBidId,
			@RequestBody ServicebidModel servicebidModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("ServiceBid update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (servicebidService.updateBid(serviceBidId, servicebidModel)) {
			responseEntity = new ResponseEntity<>("ServiceBid update Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{serviceBidId:[0-9]+}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteService(@NotNull @PathVariable("serviceBidId") Integer serviceBidId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("ServiceBid delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (servicebidService.deleteService(serviceBidId)) {
			responseEntity = new ResponseEntity<>("ServiceBid Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/startup/{startupId:[0-9]+}", method = RequestMethod.GET)
	public List<ServicebidModel> findByStartup(@NotNull @PathVariable("startupId") Integer startupId) {

		return servicebidService.findByStartup(startupId); 
		
	}
	
	@RequestMapping(path = "/{serviceBidId:[0-9]+}/assign", method = RequestMethod.PUT)
	public ResponseEntity<?> assignBid(@NotNull @PathVariable("serviceBidId") Integer serviceBidId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("ServiceBid assign Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (servicebidService.assignBid(serviceBidId)) {
			responseEntity = new ResponseEntity<>("ServiceBid assign Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/user/{username}", method = RequestMethod.GET)
	public List<ServicebidModel> findUserBid(@NotNull @PathVariable("username") String username) {
		System.out.println("-------------Inside-----------------");
		Integer userId=projectService.findUserId(username);
		return servicebidService.findUserBid(userId); 		
	}
	
}
