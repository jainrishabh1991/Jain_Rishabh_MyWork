package neu.edu.controller.location;

import javax.validation.constraints.NotNull;

public class LocationModel {
	
	@NotNull
	private String location;
	
	private Integer locationId;
	
	
	
	public LocationModel() {
		
	}

	public LocationModel(Integer locationId) {
		// TODO Auto-generated constructor stub
		this.locationId = locationId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	
}
