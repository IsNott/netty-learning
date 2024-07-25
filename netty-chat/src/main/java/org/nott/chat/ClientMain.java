package org.nott.chat;

import io.netty.channel.Channel;
import org.nott.chat.client.ChatClient;
import java.util.Scanner;

/**
 * @author Nott
 * @date 2024-7-24
 */
public class ClientMain {

    public static void main(String[] args) {
        ChatClient client = new ChatClient("localhost",80);
            try {
                client.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                client.getBoss().shutdownGracefully();
            }

    }
}
