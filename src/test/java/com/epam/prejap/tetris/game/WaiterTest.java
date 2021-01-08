package com.epam.prejap.tetris.game;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "Game")
public class WaiterTest {

    @Test
    public void shallDecreaseWaitingTime() {
        //given
        int expectedMills = 400;
        int initialMills = 500;
        var waiter = new Waiter(initialMills);
        waiter.decreaseWaitingTime();

        //when
        int actualMills = waiter.milliseconds();

        //then
        assertEquals(actualMills, expectedMills);
    }

    @Test
    public void shallNotModifyWaitingTime() {
        //given
        int expectedMills = 100;
        var waiter = new Waiter(expectedMills);
        waiter.decreaseWaitingTime();

        //when
        int actualMills = waiter.milliseconds();

        //then
        assertEquals(actualMills, expectedMills);
    }

}
