package com.tw.bootcamp.p5;

public class GreenBallRule implements BallRule {

    @Override
    public boolean isValidRule(Color color, Bag bag) {
        if (color == Color.GREEN) {
            return bag.getCountForColor(color) < 3;
        }
        return true ;
    }
}
