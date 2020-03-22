package com.tb.function;

import java.util.function.Supplier;

public enum SingleTon {
    INSTANCE;

    public static Supplier<SingleTon> getIntance(){
        return ()->INSTANCE;
    }

    public void doSomething(){
        System.out.println("Something is done!");
    }


}
