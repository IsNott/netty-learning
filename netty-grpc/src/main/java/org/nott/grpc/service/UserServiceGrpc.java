package org.nott.grpc.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: Service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "org.nott.grpc.service.UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.nott.grpc.service.UserNameRequest,
      org.nott.grpc.service.UserResponse> getGetUserRealNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserRealName",
      requestType = org.nott.grpc.service.UserNameRequest.class,
      responseType = org.nott.grpc.service.UserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.nott.grpc.service.UserNameRequest,
      org.nott.grpc.service.UserResponse> getGetUserRealNameMethod() {
    io.grpc.MethodDescriptor<org.nott.grpc.service.UserNameRequest, org.nott.grpc.service.UserResponse> getGetUserRealNameMethod;
    if ((getGetUserRealNameMethod = UserServiceGrpc.getGetUserRealNameMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserRealNameMethod = UserServiceGrpc.getGetUserRealNameMethod) == null) {
          UserServiceGrpc.getGetUserRealNameMethod = getGetUserRealNameMethod =
              io.grpc.MethodDescriptor.<org.nott.grpc.service.UserNameRequest, org.nott.grpc.service.UserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserRealName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.nott.grpc.service.UserNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.nott.grpc.service.UserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUserRealName"))
              .build();
        }
      }
    }
    return getGetUserRealNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.nott.grpc.service.UserAgeRequest,
      org.nott.grpc.service.UserInfoResponse> getGetUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserInfo",
      requestType = org.nott.grpc.service.UserAgeRequest.class,
      responseType = org.nott.grpc.service.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.nott.grpc.service.UserAgeRequest,
      org.nott.grpc.service.UserInfoResponse> getGetUserInfoMethod() {
    io.grpc.MethodDescriptor<org.nott.grpc.service.UserAgeRequest, org.nott.grpc.service.UserInfoResponse> getGetUserInfoMethod;
    if ((getGetUserInfoMethod = UserServiceGrpc.getGetUserInfoMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserInfoMethod = UserServiceGrpc.getGetUserInfoMethod) == null) {
          UserServiceGrpc.getGetUserInfoMethod = getGetUserInfoMethod =
              io.grpc.MethodDescriptor.<org.nott.grpc.service.UserAgeRequest, org.nott.grpc.service.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.nott.grpc.service.UserAgeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.nott.grpc.service.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUserInfo"))
              .build();
        }
      }
    }
    return getGetUserInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.nott.grpc.service.UserAgeRequest,
      org.nott.grpc.service.UserInfoResponseList> getGetUserInfoListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserInfoList",
      requestType = org.nott.grpc.service.UserAgeRequest.class,
      responseType = org.nott.grpc.service.UserInfoResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.nott.grpc.service.UserAgeRequest,
      org.nott.grpc.service.UserInfoResponseList> getGetUserInfoListMethod() {
    io.grpc.MethodDescriptor<org.nott.grpc.service.UserAgeRequest, org.nott.grpc.service.UserInfoResponseList> getGetUserInfoListMethod;
    if ((getGetUserInfoListMethod = UserServiceGrpc.getGetUserInfoListMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserInfoListMethod = UserServiceGrpc.getGetUserInfoListMethod) == null) {
          UserServiceGrpc.getGetUserInfoListMethod = getGetUserInfoListMethod =
              io.grpc.MethodDescriptor.<org.nott.grpc.service.UserAgeRequest, org.nott.grpc.service.UserInfoResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserInfoList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.nott.grpc.service.UserAgeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.nott.grpc.service.UserInfoResponseList.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUserInfoList"))
              .build();
        }
      }
    }
    return getGetUserInfoListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.nott.grpc.service.StreamRequest,
      org.nott.grpc.service.StreamResponse> getBiStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BiStream",
      requestType = org.nott.grpc.service.StreamRequest.class,
      responseType = org.nott.grpc.service.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.nott.grpc.service.StreamRequest,
      org.nott.grpc.service.StreamResponse> getBiStreamMethod() {
    io.grpc.MethodDescriptor<org.nott.grpc.service.StreamRequest, org.nott.grpc.service.StreamResponse> getBiStreamMethod;
    if ((getBiStreamMethod = UserServiceGrpc.getBiStreamMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getBiStreamMethod = UserServiceGrpc.getBiStreamMethod) == null) {
          UserServiceGrpc.getBiStreamMethod = getBiStreamMethod =
              io.grpc.MethodDescriptor.<org.nott.grpc.service.StreamRequest, org.nott.grpc.service.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BiStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.nott.grpc.service.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.nott.grpc.service.StreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("BiStream"))
              .build();
        }
      }
    }
    return getBiStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * 1.客户端发出一个普通的请求，服务器的返回一个普通的响应
     * </pre>
     */
    default void getUserRealName(org.nott.grpc.service.UserNameRequest request,
        io.grpc.stub.StreamObserver<org.nott.grpc.service.UserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserRealNameMethod(), responseObserver);
    }

    /**
     * <pre>
     * 2.客户端发出一个普通的请求，服务器的以流的形式返回
     * </pre>
     */
    default void getUserInfo(org.nott.grpc.service.UserAgeRequest request,
        io.grpc.stub.StreamObserver<org.nott.grpc.service.UserInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     * 3.以流式的方式请求一个Request服务器会返回一个ResponseList
     * </pre>
     */
    default io.grpc.stub.StreamObserver<org.nott.grpc.service.UserAgeRequest> getUserInfoList(
        io.grpc.stub.StreamObserver<org.nott.grpc.service.UserInfoResponseList> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetUserInfoListMethod(), responseObserver);
    }

    /**
     * <pre>
     *4.客户源与服务端都以流式的方式，双向的数据流传递
     * </pre>
     */
    default io.grpc.stub.StreamObserver<org.nott.grpc.service.StreamRequest> biStream(
        io.grpc.stub.StreamObserver<org.nott.grpc.service.StreamResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBiStreamMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserService.
   */
  public static abstract class UserServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return UserServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserService.
   */
  public static final class UserServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1.客户端发出一个普通的请求，服务器的返回一个普通的响应
     * </pre>
     */
    public void getUserRealName(org.nott.grpc.service.UserNameRequest request,
        io.grpc.stub.StreamObserver<org.nott.grpc.service.UserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserRealNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 2.客户端发出一个普通的请求，服务器的以流的形式返回
     * </pre>
     */
    public void getUserInfo(org.nott.grpc.service.UserAgeRequest request,
        io.grpc.stub.StreamObserver<org.nott.grpc.service.UserInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetUserInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 3.以流式的方式请求一个Request服务器会返回一个ResponseList
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.nott.grpc.service.UserAgeRequest> getUserInfoList(
        io.grpc.stub.StreamObserver<org.nott.grpc.service.UserInfoResponseList> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getGetUserInfoListMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *4.客户源与服务端都以流式的方式，双向的数据流传递
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.nott.grpc.service.StreamRequest> biStream(
        io.grpc.stub.StreamObserver<org.nott.grpc.service.StreamResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBiStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserService.
   */
  public static final class UserServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1.客户端发出一个普通的请求，服务器的返回一个普通的响应
     * </pre>
     */
    public org.nott.grpc.service.UserResponse getUserRealName(org.nott.grpc.service.UserNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserRealNameMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 2.客户端发出一个普通的请求，服务器的以流的形式返回
     * </pre>
     */
    public java.util.Iterator<org.nott.grpc.service.UserInfoResponse> getUserInfo(
        org.nott.grpc.service.UserAgeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetUserInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserService.
   */
  public static final class UserServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1.客户端发出一个普通的请求，服务器的返回一个普通的响应
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.nott.grpc.service.UserResponse> getUserRealName(
        org.nott.grpc.service.UserNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserRealNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_REAL_NAME = 0;
  private static final int METHODID_GET_USER_INFO = 1;
  private static final int METHODID_GET_USER_INFO_LIST = 2;
  private static final int METHODID_BI_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_REAL_NAME:
          serviceImpl.getUserRealName((org.nott.grpc.service.UserNameRequest) request,
              (io.grpc.stub.StreamObserver<org.nott.grpc.service.UserResponse>) responseObserver);
          break;
        case METHODID_GET_USER_INFO:
          serviceImpl.getUserInfo((org.nott.grpc.service.UserAgeRequest) request,
              (io.grpc.stub.StreamObserver<org.nott.grpc.service.UserInfoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_INFO_LIST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getUserInfoList(
              (io.grpc.stub.StreamObserver<org.nott.grpc.service.UserInfoResponseList>) responseObserver);
        case METHODID_BI_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biStream(
              (io.grpc.stub.StreamObserver<org.nott.grpc.service.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetUserRealNameMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              org.nott.grpc.service.UserNameRequest,
              org.nott.grpc.service.UserResponse>(
                service, METHODID_GET_USER_REAL_NAME)))
        .addMethod(
          getGetUserInfoMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              org.nott.grpc.service.UserAgeRequest,
              org.nott.grpc.service.UserInfoResponse>(
                service, METHODID_GET_USER_INFO)))
        .addMethod(
          getGetUserInfoListMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              org.nott.grpc.service.UserAgeRequest,
              org.nott.grpc.service.UserInfoResponseList>(
                service, METHODID_GET_USER_INFO_LIST)))
        .addMethod(
          getBiStreamMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              org.nott.grpc.service.StreamRequest,
              org.nott.grpc.service.StreamResponse>(
                service, METHODID_BI_STREAM)))
        .build();
  }

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.nott.grpc.service.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getGetUserRealNameMethod())
              .addMethod(getGetUserInfoMethod())
              .addMethod(getGetUserInfoListMethod())
              .addMethod(getBiStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
