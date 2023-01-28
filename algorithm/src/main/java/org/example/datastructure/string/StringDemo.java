package org.example.datastructure.string;


/**
 * @author SH
 * @date 2021/5/2 20:27
 */
public class StringDemo {

    public static void main(String[] args) {


        String str = new StringBuilder("Ja").append("va").toString();
        System.out.println(str==str.intern());

        String str1 = new StringBuilder("sca").append("la").toString();
        System.out.println(str1==str1.intern());
    }
}
