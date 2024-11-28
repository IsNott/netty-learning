package org.nott.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.nott.grpc.service.impl.UserServiceImpl;

/**
 * Grpc 服务端
 * @author Nott
 * @date 2024-11-28
 */
public class GrpcServer {

    private Server server;

    public static void main(String[] args) throws Exception{
        GrpcServer grpcServer = new GrpcServer();
        grpcServer.run();
    }

    private void run() throws Exception{
        this.server = ServerBuilder.forPort(9999).addService(new UserServiceImpl()).build();
        this.server.start();
        this.server.awaitTermination();
    }
}
