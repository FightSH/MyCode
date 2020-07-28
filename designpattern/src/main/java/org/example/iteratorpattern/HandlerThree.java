package org.example.iteratorpattern;

public class HandlerThree extends AbstractHandler {
    @Override
    protected int getHandleLevel() {
        return 3;
    }

    @Override
    protected void handle(AbstractRequest request) {
        System.out.println(TAG + "Handler3 handler request:" + request.getRequestLevel());
    }
}
