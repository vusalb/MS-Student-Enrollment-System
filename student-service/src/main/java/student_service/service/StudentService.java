package student_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import student_service.dto.StudentRequest;
import student_service.dto.StudentResponse;
import student_service.dto.StudentWithUniversityResponse;
import student_service.dto.UniversityResponse;
import student_service.entity.Student;
import student_service.feign.UniversityFeignClient;
import student_service.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	private final UniversityFeignClient universityFeignClient;

	public String createStudent(StudentRequest request) {

		Student student = new Student();
		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setEmail(request.getEmail());
		student.setUniversityId(request.getUniversityId());

		studentRepository.save(student);

		return "Student created!";
	}

	public StudentResponse getStudentById(Long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id " + id));
		return new StudentResponse(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
	}

	public String updateStudent(Long id, StudentRequest request) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id " + id));

		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setEmail(request.getEmail());

		studentRepository.save(student);

		return "Student updated!";

	}

	public String deleteStudent(Long id) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id " + id));
		studentRepository.deleteById(student.getId());
		return "Student deleted!";
	}

	public List<StudentResponse> getAllStudents() {

		return studentRepository.findAll().stream()
				.map(s -> new StudentResponse(s.getId(), s.getFirstName(), s.getLastName(), s.getEmail()))
				.collect(Collectors.toList());
	}

	public StudentWithUniversityResponse getStudentWithUniversity(Long id) {

		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found!"));

		UniversityResponse uni = universityFeignClient.getUniversityById(student.getUniversityId());

		return new StudentWithUniversityResponse(student.getId(), student.getFirstName(), student.getLastName(),
				student.getEmail(), uni);
	}
}
