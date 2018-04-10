package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Testimonial;

@Repository
public interface TestimonialDao extends JpaRepository<Testimonial, Integer>{

}
