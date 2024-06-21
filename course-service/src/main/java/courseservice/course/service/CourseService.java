package courseservice.course.service;

import courseservice.course.dto.*;
import courseservice.course.model.Course;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CourseService {

    private CourseRepository courseRepository;

    private CourseMapper courseMapper;

    private ApplicationEventPublisher eventPublisher;

    public CourseView createCourse(CreateCourseCommand command) {
        var course =  Course.announceCourse(command);
        courseRepository.save(course);

        eventPublisher.publishEvent(courseMapper.toEvent(course));

        return courseMapper.toView(course);
    }

    @Transactional(readOnly = true)
    public CourseDetailsView findCourseById(long id) {
        var course = courseRepository.findById(id).orElseThrow();
        return courseMapper.toDetailsView(course);
    }

    public List<CourseView> findAllCourses() {
        return courseRepository.findAllView();
    }

    @Transactional
    public EnrollmentResult enroll(EnrollCommand command) {
        var course = courseRepository.findById(command.getCourseId()).orElseThrow();
        var result = course.enroll(command);

        return result;
    }


}
