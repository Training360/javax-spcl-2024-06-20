package careerservice.gateway;

import careerservice.enrollment.model.EnrollCommand;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseGateway {

    private StreamBridge streamBridge;

    public void sendEnrollCommand(EnrollCommand command) {
        streamBridge.send("courses-request", command);
    }
}
