package university_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import university_service.entity.University;

public interface UniversityRepository extends JpaRepository<University, Long> {
	
}
