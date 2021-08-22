package org.example.aes;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;

import java.nio.charset.StandardCharsets;

public class AESDemo {
    public static void main(String[] args) {
        // AES加密，密钥需要是16字节

        AES aes = new AES(Mode.CBC, Padding.PKCS5Padding, "12345678".getBytes(StandardCharsets.UTF_8), "0000000000000000".getBytes(StandardCharsets.UTF_8));
        byte[] bytes = aes.encrypt("hello world");
        String res = Base64.encode(bytes);
        System.out.println(res);
        // 加密模式

        // 填充模式

    }
}
