package courseservice.coursequery;

import courseservice.course.CourseHasBeenCreatedEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseDocumentMapper {

    CourseDocument toCourseDocument(CourseHasBeenCreatedEvent event);
}
