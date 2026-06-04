package com.tw.bootcamp.p5;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Bag {
    private final int capacity;
    private final List<BallRule> rules;
    private final HashMap<Color, Integer> ballsInventory;

    public Bag(int capacity, List<BallRule> rules) {
        this.capacity = capacity;
        this.rules = rules;
        this.ballsInventory = new HashMap<>();
    }

    public int getCountForColor(Color color) {
        return ballsInventory.getOrDefault(color, 0);
    }

    public boolean add(Color color) {
        for (BallRule rule : rules) {
            if (!rule.isValidRule(color, this)) {
                return false;
            }
        }

        addBall(color);
        return true;
    }

    private void addBall(Color color) {
        ballsInventory.put(color, ballsInventory.getOrDefault(color, 0) + 1);
    }

    public int getTotalCount() {
        AtomicInteger totalCount = new AtomicInteger();
        ballsInventory.forEach((Color color, Integer countOfBalls) -> totalCount.addAndGet(countOfBalls));

        return totalCount.get();
    }
}
