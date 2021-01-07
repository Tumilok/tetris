package com.epam.prejap.tetris;

import com.epam.prejap.tetris.game.Waiter;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "Tetris")
public class ScoreTest {

    @Test
    public void shallIncreaseScore() {
        //given
        Waiter waiter = new Waiter(0);
        Score score = new Score(waiter);

        //when
        score.increaseScore();
        int expectedPoints = score.points();
        int actualPoints = 1;

        //then
        Assert.assertEquals(actualPoints, expectedPoints);
    }

    @Test
    public void shallThrowNullPointerException() {
        //given

        //when

        //then
        Assert.assertThrows(NullPointerException.class, () -> new Score(null));
    }

}