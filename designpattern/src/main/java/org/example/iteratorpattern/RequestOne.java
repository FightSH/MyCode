package org.example.iteratorpattern;

public class RequestOne extends AbstractRequest{
    @Override
    public int getRequestLevel() {
        return 1;
    }

    public RequestOne(Object object) {
        super(object);
    }

    @Override
    public Object getContent() {
        return super.getContent();
    }
}
