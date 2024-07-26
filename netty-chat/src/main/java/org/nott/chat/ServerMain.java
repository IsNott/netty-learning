package org.nott.chat;

import org.nott.chat.socket.server.ChatServer;
import org.nott.chat.webSocket.server.WsChatServer;

/**
 * @author Nott
 * @date 2024-7-24
 */
public class ServerMain {

    public static void main(String[] args) {
//        ChatServer chatServer = new ChatServer(80);
        WsChatServer chatServer = new WsChatServer(81);
        try {
            chatServer.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
