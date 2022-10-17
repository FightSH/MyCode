package org.example.utils;

import org.example.myinterface.BranchHandler;
import org.example.myinterface.PresentOrElseHandler;
import org.example.myinterface.ThrowExceptionFunction;

public class MyUtils {

    public static ThrowExceptionFunction isTrue(boolean flag) {

        return message -> {
            if (flag) {
                throw new RuntimeException(message);
            }
        };
    }

    public static BranchHandler isTrueOrFalse(boolean f) {
        return ((trueRunnable, falseRunnable) -> {
            if (f) {
                trueRunnable.run();
            } else {
                falseRunnable.run();

            }
        });
    }

    public static PresentOrElseHandler<?> isBlankOrNoBlank(String str){


        return (consumer, runnable) -> {
            if (str == null || str.length() == 0){
                runnable.run();
            } else {
                consumer.accept(str);
            }
        };
    }
}
