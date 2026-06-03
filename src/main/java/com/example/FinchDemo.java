package com.example;

import com.birdbrain.Finch;

public class FinchDemo {
    public static void main(String[] args) {
        Finch myFinch = new Finch();

        myFinch.setMove("F",10,50);
        myFinch.playNote(60,0.5);

        myFinch.setMove("F",10,50);

    }
}