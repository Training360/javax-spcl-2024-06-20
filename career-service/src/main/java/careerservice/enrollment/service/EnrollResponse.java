package careerservice.enrollment.service;

public record EnrollResponse(long employeeId, long courseId, EnrollResult result) {

    public enum EnrollResult {SUCCESS, FAIL_FULL}

}
