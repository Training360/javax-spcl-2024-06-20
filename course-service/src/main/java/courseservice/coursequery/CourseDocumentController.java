package courseservice.coursequery;

import courseservice.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<CourseDocument> findByWord(@RequestParam String word) {
        return repository.findByWord(word);
    }
}
