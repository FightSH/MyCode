package org.example.iteratorpattern;

public class HandlerOne extends AbstractHandler {
    @Override
    protected int getHandleLevel() {
        return 1;
    }

    @Override
    protected void handle(AbstractRequest request) {
        System.out.println(TAG + "Handler1 handler request:" + request.getRequestLevel());
    }
}
