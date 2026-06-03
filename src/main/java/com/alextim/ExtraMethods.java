package com.alextim;

import com.birdbrain.Finch;

public class ExtraMethods extends Finch {

    public ExtraMethods(String device) {
        super(device);
    }


    public int hiText[] = {1,0,0,0,1,1,0,0,0,0,1,1,1,0,1,1,0,1,0,1,1,0,1,0,1};
    public int[][] startAnimation = {
        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
        {0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
        {0,0,1,1,1,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0}, 
        {0,1,1,1,1,0,0,1,1,1,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0}, 
        {1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,0,0,0,1,1,0,0,0,0,1}, 
        {1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,0,0,0,1,1}, 
        {1,1,1,0,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,0,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,0,0,0,1,1,1,0,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,1,1,0,0,0,1,1,1,0,0,1,1,1,1,0,1,1,1,1,1},
        {0,0,0,0,0,1,0,0,0,0,1,1,0,0,0,1,1,1,0,0,1,1,1,1,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    public int[][] smileAnimation = {
        {0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1,1,1,0},
        {0,1,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1,1,1,0,0,0,0,0,0}
    };

    public void setUp () {
        for(int r = 0; r < startAnimation.length; r++){
            int[] currentAnimation = startAnimation[r];
            setDisplay(currentAnimation);
            pause(0.2);
        }
        setDisplay(hiText);
        boolean isWalking = true;
        while(isWalking){
            if(getButton("A") == true){
                moonWalk();
                isWalking = false;
            }
            if(getButton("B") == true){
                shuffle();
                isWalking = false;
            }
        }
    }

    public void moonWalk(){
        countdown();
        setTurn("L", 360, 100);
        objectDistanceCheck();
        setMove("B", 30, 100);
        objectDistanceCheck();
        setTurn("L", 547, 100);
        objectDistanceCheck();
        setMove("B", 30, 100);
        objectDistanceCheck();
        setMove("F",5,100);
        objectDistanceCheck();
        setTurn("L", 180, 100);
        adjustmentCheck();
        smileAnimation();
    }
    public void shuffle(){
        countdown();
        setTurn("L",180,100);
        objectDistanceCheck();
        setMove("F",30,100);
        objectDistanceCheck();
        setTurn("L",45,100);
        objectDistanceCheck();
        setMove("F",15,100);
        objectDistanceCheck();
        setMove("B",15,100);
        objectDistanceCheck();
        setTurn("R",45,100);
        objectDistanceCheck();
        setMove("F",20,100);
        objectDistanceCheck();
        setMove("B",20,100);
        objectDistanceCheck();
        setTurn("R",45,100);
        objectDistanceCheck();
        setMove("F",15,100);
        objectDistanceCheck();
        setMove("B",15,100);
        objectDistanceCheck();
        setTurn("L",45,100);
        objectDistanceCheck();
        setTurn("L", 540, 100);
        objectDistanceCheck();
        setMove("F", 30, 100);
        objectDistanceCheck();
        adjustmentCheck();
        smileAnimation();
        
    }
    public void countdown(){
        pause(1);
        print("3");
        pause(1);
        print("2");
        pause(1);
        print("1");
        pause(1);
    }   
    public void adjustmentCheck(){
        String currentOrientation = getOrientation();
        if(currentOrientation.equals("Tilt right")){
            setTurn("R", 5, 100);
        } else {
            setTurn("L",5,100);
        }
    }
    public void safetyRunCheck(){
        int temp = getTemperature();
        if(temp > 33){
            print("WARNING: TEMPERATURE IS TOO HIGH, PLEASE RELOCATE YOUR FINCH ROBOT");
            pause(2);
            stopAll();
            disconnect();
        }
    }
    public void objectDistanceCheck(){
        int currentDistance = getDistance();
        if(currentDistance < 5){
            setMove("B", 3, 100);
            adjustmentCheck();
        }
    }
    public void smileAnimation(){
        for(int i = 0; i < 3; i++){
            setDisplay(smileAnimation[0]);
            pause(1);
            setDisplay(smileAnimation[1]);
            pause(1);
        }
    }
}
