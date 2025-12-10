package student_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import student_service.dto.UniversityRequest;
import student_service.dto.UniversityResponse;


@FeignClient(name = "university-service")
public interface UniversityFeignClient {

    @GetMapping("/api/universities/{id}")
    UniversityResponse getUniversityById(@PathVariable("id") Long id);

    @PostMapping("/api/universities")
    String createUniversity(@RequestBody UniversityRequest request);
}

