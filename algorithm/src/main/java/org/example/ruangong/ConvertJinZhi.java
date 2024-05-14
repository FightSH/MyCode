package org.example.ruangong;

public class ConvertJinZhi {
    public static void main(String[] args) {
        String binaryStr = "1010";
        System.out.print(binConvertTodec(binaryStr));
    }
    public static int binConvertTodec(String binaryStr) {

        int decimal = 0;
        int base = 1;

        // 从右往左遍历二进制字符串
        for (int i = binaryStr.length() - 1; i >= 0; --i) {
            char bit = binaryStr.toCharArray()[i];
            // 检查当前位是否为'1'
            if (bit == '1') {
                decimal += base;
            }
            // 更新基数，相当于乘以2
            base *= 2;
        }

        return decimal;
    }

}
