package org.nott.rpc;

import org.nott.rpc.netty.client.NettySocketClient;

/**
 * @author Nott
 * @date 2024-7-24
 */
public class DefaultClient {

    public static void main(String[] args) {
        NettySocketClient client = NettySocketClient.DEFAULT();
        client.connect("localhost", 70);
        RpcRequest request = new RpcRequest();
        client.sendMsg(request);
    }
}
