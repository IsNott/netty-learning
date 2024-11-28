package org.nott.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.nott.grpc.service.UserNameRequest;
import org.nott.grpc.service.UserResponse;
import org.nott.grpc.service.UserServiceGrpc;

/**
 * @author Nott
 * @date 2024-11-28
 */
@Slf4j
public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9999).usePlaintext().build();
        UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(managedChannel);
        UserNameRequest req = UserNameRequest.newBuilder().setUsername("test").build();
        UserResponse response = stub.getUserRealName(req);
        log.info("普通回复:{}", response.getRealName());
    }
}
