package org.nott.grpc;


import lombok.extern.slf4j.Slf4j;
import org.nott.grpc.client.GrpcClient;
import org.nott.grpc.model.DataInfo;
import org.nott.grpc.sever.GrpWsServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Nott
 * @date 2024-11-28
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "org.nott.grpc")
public class GrpcApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GrpcApplication.class, args);
        log.info("Grpc Application running...");
        new GrpWsServer().run();
        new GrpcClient().run();

    }
}
