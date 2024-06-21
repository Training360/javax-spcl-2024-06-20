package courseservice.coursequery;

import courseservice.course.CourseHasBeenCreatedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseDocumentEventHandler {

    private final CourseDocumentMapper courseDocumentMapper;

    private final CourseDocumentRepository courseDocumentRepository;

    @EventListener
    public void handleCourseHasBeenCreatedEvent(CourseHasBeenCreatedEvent event) {
        var mapped = courseDocumentMapper.toCourseDocument(event);
        courseDocumentRepository.save(mapped);
    }
}
