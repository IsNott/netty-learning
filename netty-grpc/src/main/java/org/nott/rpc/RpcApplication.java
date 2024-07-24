package org.nott.rpc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Nott
 * @date 2024-7-24
 */

@Slf4j
@SpringBootApplication(scanBasePackages = {"org.nott.rpc"})
public class RpcApplication {

    public static void main(String[] args) {
        log.info("Rpc Web Application run");
        SpringApplication.run(RpcApplication.class,args);
    }
}
