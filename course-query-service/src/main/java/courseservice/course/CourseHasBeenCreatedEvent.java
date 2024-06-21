package courseservice.course;

public record CourseHasBeenCreatedEvent(long id,
                                        String name,
                                        String description,
                                        String syllabus) {

}
