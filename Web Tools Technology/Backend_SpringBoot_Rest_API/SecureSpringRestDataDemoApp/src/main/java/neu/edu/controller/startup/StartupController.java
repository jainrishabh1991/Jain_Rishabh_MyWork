package neu.edu.controller.startup;

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
import neu.edu.service.StartupService;

@RestController
@RequestMapping(path="/startup")
public class StartupController {
	
	@Autowired
	private StartupService startupService;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<StartupModel> findAll() {
		return startupService.findAll();
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createStartup(@RequestBody @Valid StartupModel startupModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Startup Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		StartupModel userProfile = null;
		if ((userProfile = startupService.createStartup(startupModel)) != null) {
			responseEntity = new ResponseEntity<>(userProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{startupId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUsername(@NotNull @PathVariable("startupId") Integer startupId,
			@RequestBody StartupModel startupModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Startup update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (startupService.updateStartup(startupId, startupModel)) {
			responseEntity = new ResponseEntity<>("Startup update Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{startupId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@NotNull @PathVariable("startupId") Integer startupId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Startup delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (startupService.deleteStartup(startupId)) {
			responseEntity = new ResponseEntity<>("Startup Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path="/user/{username}",method = RequestMethod.GET)
	public List<StartupModel> findStartupByUsername(@NotNull @PathVariable("username") String username) {
		
		Integer userId=projectService.findUserId(username);
		return startupService.findStartupByUsername(userId);
	}
	
}
