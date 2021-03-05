package org.example.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {

    public static void main(String[] args) throws IOException {
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        while (true){
            //阻塞
            final SocketChannel socketChannel = serverSocketChannel.accept();
            final SocketHandler socketHandler = new SocketHandler(socketChannel);
            new Thread(socketHandler).start();

        }

    }
}
