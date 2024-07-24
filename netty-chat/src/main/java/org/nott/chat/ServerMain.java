package org.nott.chat;

import org.nott.chat.server.ChatServer;

/**
 * @author Nott
 * @date 2024-7-24
 */
public class ServerMain {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(80);
        try {
            chatServer.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
