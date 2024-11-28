package org.nott.grpc.service.impl;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.nott.grpc.service.*;

/**
 * @author Nott
 * @date 2024-11-28
 */
@Slf4j
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUserRealName(UserNameRequest request, StreamObserver<UserResponse> responseObserver) {
        log.info("Grpc interface getUserRealName executed...");
        String username = request.getUsername();
        responseObserver.onNext(UserResponse.newBuilder().setRealName(username + "From Response...").build());
        responseObserver.onCompleted();
        log.info("普通请求，返回普通响应");
    }

    @Override
    public void getUserInfo(UserAgeRequest request, StreamObserver<UserInfoResponse> responseObserver) {
        log.info("Grpc interface getUserInfo executed...");
        int age = request.getAge();
        responseObserver.onNext(UserInfoResponse.newBuilder().setAge((age + 1)).build());
        responseObserver.onNext(UserInfoResponse.newBuilder().setAge((age + 1)).build());
        responseObserver.onNext(UserInfoResponse.newBuilder().setAge((age + 1)).build());
        responseObserver.onCompleted();
        log.info("普通请求，返回流式响应");
    }

    @Override
    public StreamObserver<UserAgeRequest> getUserInfoList(StreamObserver<UserInfoResponseList> responseObserver) {
        log.info("Grpc interface getUserInfoList executed...");
        return new StreamObserver<UserAgeRequest>() {
            // 读取
            @Override
            public void onNext(UserAgeRequest userAgeRequest) {
                int age = userAgeRequest.getAge();
                log.info("getUserInfoList StreamObserver<UserAgeRequest> : {}", age);
            }

            // 错误
            @Override
            public void onError(Throwable throwable) {
                log.error("getUserInfoList Args read error...");
            }

            // 读取完成
            @Override
            public void onCompleted() {
                String baseName = "getUserInfoList: ";
                UserResponse build = UserResponse.newBuilder().setRealName(baseName + "zhangsan").build();
                UserResponse build1 = UserResponse.newBuilder().setRealName(baseName + "zhangsan2").build();
                UserResponse build2 = UserResponse.newBuilder().setRealName(baseName + "zhangsan3").build();
                UserInfoResponseList resp = UserInfoResponseList.newBuilder().addUserInfoResponseList(build).addUserInfoResponseList(build1).addUserInfoResponseList(build2).build();
                responseObserver.onNext(resp);
                responseObserver.onCompleted();
                log.info("流式请求，返回列表");
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biStream(StreamObserver<StreamResponse> responseObserver) {
        log.info("Grpc interface biStream executed...");
        return new StreamObserver<StreamRequest>() {
            // 读取
            @Override
            public void onNext(StreamRequest streamRequest) {
                log.info("biStream StreamObserver<StreamRequest> : {}", streamRequest.getRequest());
            }

            // 错误
            @Override
            public void onError(Throwable throwable) {
                log.error("biStream Args read error...");
            }

            // 读取完成
            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
                log.info("双向流关闭");
            }
        };
    }
}
