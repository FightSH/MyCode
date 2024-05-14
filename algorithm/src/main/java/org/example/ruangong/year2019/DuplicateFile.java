package org.example.ruangong.year2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DuplicateFile {
    public static void main(String[] args) {
        Path source = Paths.get("path/to/source/file.txt");
        Path destination = Paths.get("path/to/destination/file.txt");
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("文件复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件复制失败！");
        }


        Path sourcePath = Paths.get("path/to/source/file.txt");
        Path destinationPath = Paths.get("path/to/destination/file.txt");
        try {
            // 读取源文件内容
            byte[] content = Files.readAllBytes(sourcePath);
            // 将内容写入目标文件
            Files.write(destinationPath, content);

            System.out.println("文件内容复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件内容复制失败！");
        }

        try (BufferedReader reader = Files.newBufferedReader(sourcePath);
             BufferedWriter writer = Files.newBufferedWriter(destinationPath)) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // 根据需要添加新行
            }

            System.out.println("文件内容复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件内容复制失败！");
        }
    }
}
