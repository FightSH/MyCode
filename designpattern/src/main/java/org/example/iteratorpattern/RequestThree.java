package org.example.iteratorpattern;

public class RequestThree extends AbstractRequest {
    public RequestThree(Object object) {
        super(object);
    }

    @Override
    public int getRequestLevel() {
        return 3;
    }

    @Override
    public Object getContent() {
        return super.getContent();
    }
}
