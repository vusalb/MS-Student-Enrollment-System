package university_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import university_service.dto.UniversityRequest;
import university_service.dto.UniversityResponse;
import university_service.service.UniversityService;

@RestController
@RequestMapping("/api/universities")
@RequiredArgsConstructor
public class UniversityController {
	
	 private final UniversityService universityService;

	    @PostMapping
	    public ResponseEntity<String> createUniversity(@RequestBody UniversityRequest request) {
	    	
	        universityService.createUniversity(request);
	        return ResponseEntity.status(HttpStatus.CREATED).body("University created!");
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<UniversityResponse> getUniversityById(@PathVariable Long id) {
	    	
	        UniversityResponse response = universityService.getUniversityById(id);
	        return ResponseEntity.ok(response);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateUniversity(@PathVariable Long id, @RequestBody UniversityRequest request) {
	    	
	        universityService.updateUniversity(id, request);
	        return ResponseEntity.ok("University updated!");
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteUniversity(@PathVariable Long id) {
	    	
	        universityService.deleteUniversity(id);
	        return ResponseEntity.ok("University deleted!");
	    }

	    @GetMapping
	    public ResponseEntity<List<UniversityResponse>> getAllUniversities() {
	        List<UniversityResponse> universities = universityService.getAllUniversities();
	        return ResponseEntity.ok(universities);
	    }

}
