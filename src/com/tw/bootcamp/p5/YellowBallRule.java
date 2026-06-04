package com.tw.bootcamp.p5;

public class YellowBallRule implements BallRule {
    public boolean isValidRule(Color color, Bag bag) {
        if (color == Color.YELLOW) {
            int countOfYellowBalls = bag.getCountForColor(color);

            return countOfYellowBalls < bag.getTotalCount() * 0.4;
        }
        return true;
    }
}
