package neu.edu.controller.testimonial;

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
import neu.edu.service.TestimonialService;

@RestController
@RequestMapping(path="/testimonial")
public class TestimonialController {
	
	@Autowired
	private TestimonialService testimonialService;

	@RequestMapping(method = RequestMethod.GET)
	public List<TestimonialModel> findAll() {
		return testimonialService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> postTestimonial(@RequestBody @Valid TestimonialModel  testimonialModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Testimonial Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		TestimonialModel userProfile = null;
		if ((userProfile = testimonialService.postTestimonial(testimonialModel)) != null) {
			responseEntity = new ResponseEntity<>(userProfile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	
	@RequestMapping(path = "/{testimonialId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTestimonial(@NotNull @PathVariable("testimonialId") Integer testimonialId,
			@RequestBody TestimonialModel testimonialModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Testimonial update Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (testimonialService.updateTestimonial(testimonialId, testimonialModel)) {
			responseEntity = new ResponseEntity<>("Testimonial update Successful", HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/{testimonialId:[0-9]+}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTestimonial(@NotNull @PathVariable("testimonialId") Integer testimonialId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Testimonial delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (testimonialService.deleteTestimonial(testimonialId)) {
			responseEntity = new ResponseEntity<>("Testimonial Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}
	
}
