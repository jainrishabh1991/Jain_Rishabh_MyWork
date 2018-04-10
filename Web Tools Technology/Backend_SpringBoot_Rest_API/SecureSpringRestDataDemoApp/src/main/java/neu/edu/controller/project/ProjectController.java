package neu.edu.controller.project;

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

@RestController
@RequestMapping(path="/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ProjectModel> findAll() {
		return projectService.findAll();
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createProject(@RequestBody @Valid ProjectModel projectModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Project Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		ProjectModel projectProfile = null;
		if ((projectProfile = projectService.createProject(projectModel)) != null) {
			responseEntity = new ResponseEntity<>(projectProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{projectId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProject(@NotNull @PathVariable("projectId") Integer projectId,
			@RequestBody ProjectModel projectModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Project update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (projectService.updateProject(projectId, projectModel)) {
			responseEntity = new ResponseEntity<>("Project update Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{projectId:[0-9]+}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProject(@NotNull @PathVariable("projectId") Integer projectId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Project delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (projectService.deleteProject(projectId)) {
			responseEntity = new ResponseEntity<>("Project Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/category/{categoryId:[0-9]+}",method = RequestMethod.GET)
	public List<ProjectModel> findByCategory(@NotNull @PathVariable("categoryId") Integer categoryId) {
		
		return projectService.findByCategory(categoryId);
	}
	
	@RequestMapping(path = "/userId/{username}",method = RequestMethod.GET)
	public List<ProjectModel> findByUser(@NotNull @PathVariable("username") String username) {
		
		Integer userId=projectService.findUserId(username);
		return projectService.findByUser(userId);
	}
	
	@RequestMapping(path = "/user/{username}",method = RequestMethod.GET)
	public List<ProjectModel> findProjectByFunder(@NotNull @PathVariable("username") String username) {
		
		Integer userId=projectService.findUserId(username);
		return projectService.findProjectByFunder(userId);
	}
}
