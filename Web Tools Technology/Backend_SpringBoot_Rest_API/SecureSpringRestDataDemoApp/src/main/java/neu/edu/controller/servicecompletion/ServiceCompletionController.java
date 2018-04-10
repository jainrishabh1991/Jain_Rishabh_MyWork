package neu.edu.controller.servicecompletion;

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

import neu.edu.service.ServiceCompletionService;


@RestController
@RequestMapping(path="/serviceCompletion")
public class ServiceCompletionController {
	
	@Autowired
	private ServiceCompletionService serviceService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ServiceCompletionModel> findAll() {
		return serviceService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createService(@RequestBody @Valid ServiceCompletionModel serviceModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("ServiceCompletion Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		ServiceCompletionModel serviceProfile = null;
		if ((serviceProfile = serviceService.createService(serviceModel)) != null) {
			responseEntity = new ResponseEntity<>(serviceProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{serviceId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateService(@NotNull @PathVariable("serviceId") Integer serviceId,
			@RequestBody ServiceCompletionModel serviceModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("ServiceCompletion update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (serviceService.updateService(serviceId, serviceModel)) {
			responseEntity = new ResponseEntity<>("ServiceCompletion update Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{serviceId:[0-9]+}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteService(@NotNull @PathVariable("serviceId") Integer serviceId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("ServiceCompletion delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (serviceService.deleteService(serviceId)) {
			responseEntity = new ResponseEntity<>("ServiceCompletion Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/service/{serviceBid:[0-9]+}", method = RequestMethod.GET)
	public ServiceCompletionModel findServiceProgress(@NotNull @PathVariable("serviceBid") Integer serviceBid) {
		return serviceService.findServiceProgress(serviceBid);
	}
	
	@RequestMapping(path = "/progress/{serviceBid:[0-9]+}", method = RequestMethod.GET)
	public List<ServiceCompletionModel> findServiceAllProgress(@NotNull @PathVariable("serviceBid") Integer serviceBid) {
		
		return serviceService.findServiceAllProgress(serviceBid);
	}
}
