package student_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithUniversityResponse {
	
		private Long id;

		private String firstName;

	    private String lastName;

	    private String email;

	    private UniversityResponse university;

}
