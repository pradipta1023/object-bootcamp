package com.tw.bootcamp.p5;

public class RedBallRule implements BallRule {
    public boolean isValidRule(Color color, Bag bag) {
        if (color == Color.RED) {
            int countOfGreenBalls = bag.getCountForColor(Color.GREEN);
            int countOfRedBalls = bag.getCountForColor(color);

            return countOfRedBalls < countOfGreenBalls * 2;
        }

        return true;
    }
}
