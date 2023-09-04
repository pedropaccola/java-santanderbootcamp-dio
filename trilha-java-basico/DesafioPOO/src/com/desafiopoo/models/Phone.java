package com.desafiopoo.models;

public class Phone {
    public void call(int number) {
        System.out.println("Calling " + number);
    }

    public void answer(int number) {
        System.out.println("Answering " + number);
    }

    public void voiceMail() {
        System.out.println("Calling voicemail service");
    }
}
