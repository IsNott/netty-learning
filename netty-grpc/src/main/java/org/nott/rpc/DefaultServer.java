package org.nott.rpc;

import lombok.extern.slf4j.Slf4j;
import org.nott.rpc.netty.server.NettySocketServer;

/**
 * @author Nott
 * @date 2024-7-24
 */
public class DefaultServer {

    public static void main(String[] args) {
        NettySocketServer.Default().start(70);
    }
}
