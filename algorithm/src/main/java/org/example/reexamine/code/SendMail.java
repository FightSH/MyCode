package org.example.reexamine.code;

import java.util.Scanner;
// 输入包含多组数据。
//
//每组数据的第一行是一个整数n (1≤n≤128)，表示后面有n个姓名。
//
//紧接着n行，每一行包含一个收件人的姓名。姓名长度不超过16个字符

/**
 * 如果一封邮件中包含多个收件人，收件人姓名之间会用一个逗号和空格隔开；如果收件人姓名也包含空格或逗号，则姓名需要用双引号包含。
 * 现在给你一组收件人姓名，请你帮他生成相应的收件人列表。
 */

public class SendMail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String name = scanner.nextLine();
            StringBuilder sb = new StringBuilder(name);
            for (int i = 0; i < n; i++) {
                String str = scanner.nextLine();
                if (str.contains(",") || str.contains(" ")) {
                    str = "\"" + str + "\"";
                }
                sb.append(str);
                if (i != n - 1) {
                    sb.append(", ");
                }
            }
            System.out.print(sb.toString());
        }

    }
}
