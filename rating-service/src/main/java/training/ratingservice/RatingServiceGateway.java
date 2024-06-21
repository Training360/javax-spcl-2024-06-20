package training.ratingservice;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import training.ratingservice.grpcgateway.RateRequest;
import training.ratingservice.grpcgateway.RateResponse;
import training.ratingservice.grpcgateway.RatingServiceGrpc;

@GrpcService
public class RatingServiceGateway extends RatingServiceGrpc.RatingServiceImplBase {

    @Override
    public void rate(RateRequest request, StreamObserver<RateResponse> responseObserver) {
        var response = RateResponse.newBuilder().setStars(request.getStars()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
