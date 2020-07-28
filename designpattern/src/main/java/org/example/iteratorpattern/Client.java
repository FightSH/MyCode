package org.example.iteratorpattern;

public class Client {

    public static void main(String[] args) {
        AbstractHandler handler1 = new HandlerOne();
        AbstractHandler handler2 = new HandlerTwo();
        AbstractHandler handler3 = new HandlerThree();

        handler1.nextHandler = handler2;
        handler2.nextHandler = handler3;


        AbstractRequest request1 = new RequestOne("Request1");
        AbstractRequest request2 = new RequestTwo("Request2");
        AbstractRequest request3 = new RequestThree("Request3");

        //首端请求
        handler1.handleRequest(request1);
        handler1.handleRequest(request2);
        handler1.handleRequest(request3);
    }


}
