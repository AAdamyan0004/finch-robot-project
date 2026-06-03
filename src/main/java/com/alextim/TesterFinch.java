package com.alextim;
import com.birdbrain.Finch;

public class TesterFinch {                 

    public static void main(String[] args) {
        ExtraMethods bird = new ExtraMethods("A");
        bird.safetyRunCheck();
        bird.setUp();

        bird.stopAll();
    }
  
}
