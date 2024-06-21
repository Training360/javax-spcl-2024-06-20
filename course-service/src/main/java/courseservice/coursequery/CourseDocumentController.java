package courseservice.coursequery;

import courseservice.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course-documents")
@AllArgsConstructor
public class CourseDocumentController {

    private CourseDocumentRepository repository;

    @GetMapping("/{id}")
    public CourseDocument getCourseDocument(@PathVariable long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Document not found with id " + id));
    }
}
