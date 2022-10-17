package org.example.myinterface;
@FunctionalInterface
public interface BranchHandler {

    void trueOrFalseHandle(Runnable trueRunnable, Runnable falseRunnable);

}
