package org.nott.chat;

import org.nott.chat.client.ChatClient;
import org.nott.chat.server.ChatServer;

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
            }
    }
}
