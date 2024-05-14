package org.example.honer;

import java.util.Scanner;
// NowCoder每天要给许多客户写电子邮件。正如你所知，如果一封邮件中包含多个收件人，收件人姓名之间会用一个逗号和空格隔开；如果收件人姓名也包含空格或逗号，则姓名需要用双引号包含。
public class Shoujianrenliebiao14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String name = sc.nextLine();
                if (name.contains(",") || name.contains(" ")) {
                    System.out.print("\"" + name + "\"");
                } else {
                    System.out.print(name);
                }

                if (i != n - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
