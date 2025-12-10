package student_service.controller;

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
import student_service.dto.StudentRequest;
import student_service.dto.StudentResponse;
import student_service.dto.StudentWithUniversityResponse;
import student_service.service.StudentService;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
	
	 private final StudentService studentService;
	 
	 @PostMapping
	    public ResponseEntity<String> createStudent(@RequestBody StudentRequest request) {
		 
	       studentService.createStudent(request);
	       return ResponseEntity.status(HttpStatus.CREATED).body("Student created!");
	    }
	 
	   @GetMapping("/{id}")
	    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id) {
	       
	            StudentResponse response = studentService.getStudentById(id);
	            return ResponseEntity.ok(response);
	    }


	   @PutMapping("/{id}")
	    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody StudentRequest request) {
	    	
	        studentService.updateStudent(id, request);
	        return ResponseEntity.ok("Student updated!");
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
	    	
	        studentService.deleteStudent(id);
	        return ResponseEntity.ok("Student deleted!");
	    }
	    
	    @GetMapping
	    public ResponseEntity<List<StudentResponse>> getAllStudents() {
	    	List<StudentResponse> students = studentService.getAllStudents();
	        return ResponseEntity.ok(students);
	    }
	    
	    @GetMapping("/{id}/with-university")
	    public ResponseEntity<StudentWithUniversityResponse> getStudentWithUniversity(@PathVariable Long id) {
	    	
	    	StudentWithUniversityResponse response = studentService.getStudentWithUniversity(id);
	        return ResponseEntity.ok(response);
	    }

}
