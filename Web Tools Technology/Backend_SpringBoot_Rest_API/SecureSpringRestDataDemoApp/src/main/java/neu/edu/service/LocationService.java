package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.location.LocationModel;
import neu.edu.dao.LocationDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Location;
import neu.edu.entity.User;

@Service
public class LocationService {
	
	@Autowired
	private LocationDao locationDao;

	@Autowired
	private UserDao userDao;

	@Transactional
	public Integer createLocation(Integer userId, LocationModel locationModel) {
		User user = userDao.findOne(userId);
		if (user!=null && "Administrator".equals(user.getRole().getRoleName())) {
			Location loc=new Location();
			loc.setLocation(locationModel.getLocation());
			loc = locationDao.save(loc);
			System.out.println("ID Created " + loc.getLocationId());
			return loc.getLocationId();
		} else {
			return null;
		}

	}

	@Transactional
	public List<LocationModel> findAll() {
		// TODO Auto-generated method stub
		
		return locationDao.findAll().stream().map(x -> {
			LocationModel temp = new LocationModel(x.getLocationId());
			temp.setLocation(x.getLocation());
			return temp;
		}).collect(Collectors.toList());
	}

	@Transactional
	public boolean deleteLocation(Integer locationId, Integer userId) {
		Location toBeDeleted = locationDao.findOne(locationId);
		User user = userDao.findOne(userId);
		if (user!=null && "Administrator".equals(user.getRole().getRoleName()) && toBeDeleted!=null && toBeDeleted.getProjects().size() <= 0 && toBeDeleted.getStartups().size()<= 0){
			locationDao.delete(toBeDeleted);
			return true;
		}
		return false;
		
	}

	@Transactional
	public boolean updateLocation(Integer locationId, LocationModel newLocation, Integer userId) {
		Location toBeUpdated = locationDao.findOne(locationId);
		User user = userDao.findOne(userId);
		if (user!=null && "Administrator".equals(user.getRole().getRoleName()) && toBeUpdated!=null){
			toBeUpdated.setLocation(newLocation.getLocation());
			locationDao.save(toBeUpdated);
			return true;
		}
		return false;
		
	}
	
}
