package com.epam.prejap.tetris.game;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "Game")
public class WaiterTest {

    @Test
    public void shallDecreaseWaitingTimeWhenScoreDivisibleBy10() {
        //given
        var waiter = new Waiter(500);
        waiter.scoreChanged(10);

        //when
        int actualMills = waiter.milliseconds();

        //then
        assertEquals(actualMills, 400);
    }

    @Test
    public void shallNotModifyWaitingTimeWhenScoreDivisibleBy10() {
        //given
        int initialMills = 100;
        var waiter = new Waiter(initialMills);
        waiter.scoreChanged(10);

        //when
        int actualMills = waiter.milliseconds();

        //then
        assertEquals(actualMills, initialMills);
    }

    @Test
    public void shallNotModifyWaitingTimeWhenScoreNotDivisibleBy10() {
        //given
        int initialMills = 500;
        var waiter = new Waiter(initialMills);
        waiter.scoreChanged(9);

        //when
        int actualMills = waiter.milliseconds();

        //then
        assertEquals(actualMills, initialMills);
    }

}
