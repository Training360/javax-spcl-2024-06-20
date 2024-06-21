package careerservice.enrollment.model;

public enum EnrollmentStatus {

    STARTED {
        @Override
        public EnrollmentStatus complete() {
            return COMPLETED;
        }

        @Override
        public EnrollmentStatus cancel() {
            return CANCELLED;
        }
    }, COMPLETED , CANCELLED;

    // 200
    public EnrollmentStatus complete() {
        throw new IllegalArgumentException("Can not complete this status");
    }

    // 400
    public EnrollmentStatus cancel() {
        throw new IllegalArgumentException("Can not cancel this status");
    }
}
