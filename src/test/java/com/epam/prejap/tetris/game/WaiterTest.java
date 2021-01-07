package com.epam.prejap.tetris.game;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "Game")
public class WaiterTest {

    @Test
    public void shallDecreaseWaitingTime() {
        //given
        int initialMills = 500;
        int actualMills = 400;
        var waiter = new Waiter(initialMills);

        //when
        waiter.decreaseWaitingTime();
        int expectedMills = waiter.milliseconds();

        //then
        Assert.assertEquals(actualMills, expectedMills);
    }

    @Test
    public void shallNotModifyWaitingTime() {
        //given
        int initialMills = 100;
        var waiter = new Waiter(initialMills);

        //when
        waiter.decreaseWaitingTime();
        int expectedMills = waiter.milliseconds();

        //then
        Assert.assertEquals(initialMills, expectedMills);
    }
}
