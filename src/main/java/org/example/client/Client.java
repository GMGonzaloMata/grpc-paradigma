package org.example.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.StudentRequest;
import org.example.StudentResponse;
import org.example.StudentServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    static Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("192.168.0.5", 6565).usePlaintext().build();



        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);

        StudentResponse studentResponse = blockingStub.getStudent(StudentRequest.newBuilder().setId(2).build());

        logger.info("Respuesta Nombre:"+ studentResponse.getName() +" Edad:" + studentResponse.getAge());
    }
}
