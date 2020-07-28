package org.example.iteratorpattern;

public class RequestTwo extends AbstractRequest {
    public RequestTwo(Object object) {
        super(object);
    }

    @Override
    public int getRequestLevel() {
        return 2;
    }

    @Override
    public Object getContent(){
        return super.getContent();
    }
}
