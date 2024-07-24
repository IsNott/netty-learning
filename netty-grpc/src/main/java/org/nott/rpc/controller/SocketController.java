package org.nott.rpc.controller;

import org.nott.rpc.DefaultClient;
import org.nott.rpc.netty.client.NettySocketClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nott
 * @date 2024-7-24
 */

@RestController
@RequestMapping("/socket/")
public class SocketController {

    @RequestMapping("send")
    public void sendMsg(){
        NettySocketClient client = new NettySocketClient("localhost", 70);
        client.sendMsg();
        client.close();
    }
}
