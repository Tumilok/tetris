package com.epam.prejap.tetris.game;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

@Test(groups = "Game")
public class RefereeTest {

    @Test
    public void shallIncreaseScore() {
        //given
        var score = new Referee();
        score.increaseScore();
        int expectedPoints = 1;

        //when
        int actualPoints = score.currentScore();

        //then
        assertEquals(actualPoints, expectedPoints);
    }

    @Test
    public void shallThrowNullPointerExceptionAddingNullObserver() {
        //given
        var score = new Referee();

        //when

        //then
        assertThrows(NullPointerException.class, () -> score.addObserver(null));
    }

}
