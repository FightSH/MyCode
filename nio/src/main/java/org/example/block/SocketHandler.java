package org.example.block;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketHandler implements Runnable{

    private SocketChannel socketChannel;

    public SocketHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            int num;
            while ((num = socketChannel.read(byteBuffer)) > 0) {
                //切换模式，由写入切换到读取
                byteBuffer.flip();

                final byte[] bytes = new byte[num];
                byteBuffer.get(bytes);
                String result = new String(bytes, "UTF-8");

                final ByteBuffer writeBuffer = ByteBuffer.wrap("已收到请求".getBytes());
                socketChannel.write(writeBuffer);
                byteBuffer.clear();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
