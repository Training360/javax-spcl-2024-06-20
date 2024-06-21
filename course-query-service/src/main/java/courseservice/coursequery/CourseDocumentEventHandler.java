package courseservice.coursequery;

import courseservice.course.CourseHasBeenCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.function.Consumer;

@Configuration
@AllArgsConstructor
@Slf4j
public class CourseDocumentEventHandler {

    private final CourseDocumentMapper courseDocumentMapper;

    private final CourseDocumentRepository courseDocumentRepository;

    @Bean
    public Consumer<CourseHasBeenCreatedEvent> eventHandler() {
        return event -> {
            log.info("Event has come: {}", event);
            var mapped = courseDocumentMapper.toCourseDocument(event);
            courseDocumentRepository.save(mapped);
        };
    }
}
