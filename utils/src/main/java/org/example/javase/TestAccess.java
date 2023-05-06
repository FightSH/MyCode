package org.example.javase;

public class TestAccess {

    public static void main(String[] args) throws CloneNotSupportedException {
        AAA aaa = new AAA();
        aaa.clone();
    }


}
class AAA {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
