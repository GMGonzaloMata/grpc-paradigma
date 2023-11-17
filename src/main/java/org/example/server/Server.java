package org.example.server;

import org.example.StudentResponse;
import org.example.StudentServiceGrpc;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService
public class Server extends StudentServiceGrpc.StudentServiceImplBase {
    Logger logger = LoggerFactory.getLogger(Server.class);

    public void getStudent(org.example.StudentRequest request,
                           io.grpc.stub.StreamObserver<org.example.StudentResponse> responseObserver) {
        logger.info("Solicitud = "+ request.getId());
        StudentResponse studentResponse = StudentResponse.newBuilder().setAge(20).setName("Gonzalo").build();
        responseObserver.onNext(studentResponse);
        responseObserver.onCompleted();
    }
}
