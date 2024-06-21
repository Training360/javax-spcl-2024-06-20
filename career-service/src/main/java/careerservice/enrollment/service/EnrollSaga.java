package careerservice.enrollment.service;

import careerservice.enrollment.model.EnrollCommand;
import careerservice.enrollment.view.EnrollmentView;
import careerservice.gateway.CourseGateway;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class EnrollSaga {

    private CourseGateway courseGateway;

    private EnrollmentService enrollmentService;

    @Transactional
    public EnrollmentView enroll(EnrollCommand command) {
        var result = enrollmentService.enrollToCourse(command);
        courseGateway.sendEnrollCommand(command);
        return result;
    }

    @EventListener
    public void handleEnrollResponse(EnrollResponse enrollResponse) {
        switch (enrollResponse.result()) {
            case SUCCESS -> enrollmentService.complete(enrollResponse.courseId(), enrollResponse.employeeId());
            case FAIL_FULL -> enrollmentService.cancel(enrollResponse.courseId(), enrollResponse.employeeId());
        }
    }


}
