package neu.edu.controller.service;

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

import neu.edu.service.ProjectService;
import neu.edu.service.ServiceService;

@RestController
@RequestMapping(path="/service")
public class ServiceController {
	
	@Autowired
	private ServiceService serviceService; 
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ServiceModel> findAll() {
		return serviceService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createService(@RequestBody @Valid ServiceModel serviceModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		ServiceModel serviceProfile = null;
		if ((serviceProfile = serviceService.createService(serviceModel)) != null) {
			responseEntity = new ResponseEntity<>(serviceProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{serviceId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateService(@NotNull @PathVariable("serviceId") Integer serviceId,
			@RequestBody ServiceModel serviceModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (serviceService.updateService(serviceId, serviceModel)) {
			responseEntity = new ResponseEntity<>("Service update Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{serviceId:[0-9]+}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteService(@NotNull @PathVariable("serviceId") Integer serviceId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Service delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (serviceService.deleteService(serviceId)) {
			responseEntity = new ResponseEntity<>("Service Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/deadline", method = RequestMethod.GET)
	public List<ServiceModel> deadlineService() {
		
		return serviceService.findDeadlineService();
	}
	
	@RequestMapping(path = "/user/{username}", method = RequestMethod.GET)
	public List<ServiceModel> userService(@NotNull @PathVariable("username") String username) {
		Integer userId=projectService.findUserId(username);
		return serviceService.findUserService(userId);
	}
	
}
