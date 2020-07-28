package org.example.iteratorpattern;

public abstract class AbstractHandler {

    protected static final String TAG = AbstractHandler.class.getSimpleName();

    protected AbstractHandler nextHandler;

    public final void handleRequest(AbstractRequest request) {

        if (getHandleLevel() == request.getRequestLevel()) {
            handle(request);
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                //当所有处理者对象均不能处理该请求时输出
//                 (TAG, "All of handler can not handle the request");
                System.out.println("TAG" + "All of handler can not handle the request");
            }
        }
    }

    protected abstract int getHandleLevel();

    protected abstract void handle(AbstractRequest request);

}
