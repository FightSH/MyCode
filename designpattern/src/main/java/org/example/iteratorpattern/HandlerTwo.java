package org.example.iteratorpattern;

public class HandlerTwo extends AbstractHandler {

    @Override
    protected int getHandleLevel() {
        return 2;
    }

    @Override
    protected void handle(AbstractRequest request) {
        System.out.println(TAG + "Handler2 handler request:" + request.getRequestLevel());
    }
}
