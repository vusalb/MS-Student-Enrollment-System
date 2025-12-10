package university_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;
import university_service.dto.UniversityRequest;
import university_service.dto.UniversityResponse;
import university_service.entity.University;
import university_service.repository.UniversityRepository;

@Service
@RequiredArgsConstructor
public class UniversityService {
	
	private final UniversityRepository universityRepository;

    public String createUniversity(UniversityRequest request) {
    	
        University university = new University();
        university.setName(request.getName());
        university.setCity(request.getCity());
        university.setCountry(request.getCountry());

        universityRepository.save(university);
        return "University created!";
    }

    public UniversityResponse getUniversityById(Long id) {
    	
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found with id " + id));
        return new UniversityResponse(university.getId(), university.getName(), university.getCity(), university.getCountry());
    }

    public String updateUniversity(Long id, UniversityRequest request) {
    	
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found with id " + id));

        university.setName(request.getName());
        university.setCity(request.getCity());
        university.setCountry(request.getCountry());

        universityRepository.save(university);
        return "University updated!";
    }

    public String deleteUniversity(Long id) {
    	
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found with id " + id));
        universityRepository.deleteById(university.getId());
        return "University deleted!";
    }

    public List<UniversityResponse> getAllUniversities() {
    	
        return universityRepository.findAll()
                .stream()
                .map(u -> new UniversityResponse(u.getId(), u.getName(), u.getCity(), u.getCountry()))
                .collect(Collectors.toList());
    }

}
