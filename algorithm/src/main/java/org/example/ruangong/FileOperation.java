package org.example.ruangong;

import java.io.*;

public class FileOperation {
    public static void main(String[] args) throws FileNotFoundException {
        copy();
        output();
        input();
    }

    private static void copy() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("E:\\MyCode\\mycode\\MyCode\\algorithm\\src\\main\\java\\org\\example\\ruangong\\text.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\MyCode\\mycode\\MyCode\\algorithm\\src\\main\\java\\org\\example\\ruangong\\text1.txt");
        try {
            byte[] bytes = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(bytes)) != -1) {
                fileInputStream.read(bytes, 0, readLen);
                fileOutputStream.write(bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void input() throws FileNotFoundException {
        try (final BufferedWriter writer =
                     new BufferedWriter(new FileWriter("E:\\MyCode\\mycode\\MyCode\\algorithm\\src\\main\\java\\org\\example\\ruangong\\text1.txt"))
        ) {
            writer.write("哈哈哈嘿嘿嘿");
            writer.newLine();
            writer.write("呵呵呵 桀桀桀");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void output() {
        try (final BufferedReader reader =
                     new BufferedReader(new FileReader("E:\\MyCode\\mycode\\MyCode\\algorithm\\src\\main\\java\\org\\example\\ruangong\\text1.txt"))
        ) {
            String line = null;
            while ((line= reader.readLine())!=null){
                System.out.println(line);
            }
            reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
