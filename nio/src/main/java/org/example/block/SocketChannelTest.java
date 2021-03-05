package org.example.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelTest {
    public static void main(String[] args) throws IOException {
        final SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.write(byteBuffer);

        final ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int num;
        if ((num = socketChannel.read(readBuffer)) > 0) {
            readBuffer.flip();

            final byte[] bytes = new byte[num];

            readBuffer.get(bytes);
            String result = new String(bytes, "UTF-8");
            System.out.println("返回值: " + result);

        }


    }
}
