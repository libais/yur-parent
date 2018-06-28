package com.yur.demo.pattern.Observe;

import java.util.Observable;

public class ObserveDemo extends Observable {


    public static void main(String[] args){

        ObserveDemo demo = new ObserveDemo();

        demo.addObserver((o, msg) -> {
            System.out.println("1 号接收到消息："+ msg.toString());

        });
        demo.addObserver((o, msg) -> {
            System.out.println("2 号接收到消息："+ msg.toString());
        });

        demo.setChanged();
        demo.notifyObservers("123");

    }

}
