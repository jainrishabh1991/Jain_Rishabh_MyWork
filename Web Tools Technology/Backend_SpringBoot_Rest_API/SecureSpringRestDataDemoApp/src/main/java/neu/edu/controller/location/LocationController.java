package neu.edu.controller.location;

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
import neu.edu.service.LocationService;

@RestController
@RequestMapping(path="/location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;

	@RequestMapping(path = "/{userId:[0-9]+}", method = RequestMethod.POST)
	public ResponseEntity<String> createLocation(@NotNull @PathVariable("userId") Integer userId,
			@RequestBody LocationModel locationModel) {
		ResponseEntity<String> response = new ResponseEntity<String>("Location Not Created",
				HttpStatus.UNPROCESSABLE_ENTITY);
		if (locationService.createLocation(userId, locationModel) != null) {
			response = new ResponseEntity<String>("Location Created", HttpStatus.OK);
		}

		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<LocationModel> findAll() {
		return locationService.findAll();
	}

	@RequestMapping(path = "/{locationId:[0-9]+}/user/{userId:[0-9]+}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRole(@PathVariable("locationId") Integer locationId,@PathVariable("userId") Integer userId) {
		ResponseEntity<?> response = new ResponseEntity<>("Location Not Deleted", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = locationService.deleteLocation(locationId,userId);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = "/{locationId:[0-9]+}/user/{userId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRole(@PathVariable("locationId") Integer locationId, @RequestBody @Valid LocationModel newLocation,@PathVariable("userId") Integer userId) {
		ResponseEntity<?> response = new ResponseEntity<>("Location Not Updated", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = locationService.updateLocation(locationId, newLocation,userId);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
	
}
