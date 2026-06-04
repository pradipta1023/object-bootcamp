package com.tw.bootcamp.p5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BagTest {

    private Bag bag;

    @BeforeEach
    void setUp() {
        List<BallRule> rules = new ArrayList<>();
        rules.add(new GreenBallRule());
        rules.add(new YellowBallRule());
        rules.add(new RedBallRule());

        bag = new Bag(12, rules);
    }

    @Test
    void shouldAddTheBallInTheBag() {
        assertTrue(bag.add(Color.BLUE));
    }

    @Test
    void setLimitToTheGreenColoredBall() {
        bag.add(Color.GREEN);
        bag.add(Color.GREEN);
        assertTrue(bag.add(Color.GREEN));
        assertFalse(bag.add(Color.GREEN));
    }

    @Test
    void shouldSetTheMaxLimitForRedAsPerTheGreenCount() {
        assertFalse(bag.add(Color.RED));
    }

    @Test
    void shouldNotAddYellowIfTotalYellowBallIsMoreThanFortyPercentOfTotalBalls() {
         assertFalse(bag.add(Color.YELLOW));
    }

    @Test
    void shouldAddYellowIfItsCountLessThanFortyPercentOfTotalBalls() {
        bag.add(Color.GREEN);
        bag.add(Color.GREEN);
        assertTrue(bag.add(Color.YELLOW));
    }

    @Test
    void shouldNotAddRedIfItsCountIsGreaterThanDoubleOfGreen() {
        assertFalse(bag.add(Color.RED));
    }
}