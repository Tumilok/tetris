package com.epam.prejap.tetris.score;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

@Test(groups = "Score")
public class ScoreTest {

    @Test
    public void shallIncreaseScore() {
        //given
        var score = new Score();
        score.increaseScore();
        int expectedPoints = 1;

        //when
        int actualPoints = score.points();

        //then
        assertEquals(actualPoints, expectedPoints);
    }

    @Test
    public void shallThrowNullPointerExceptionAddingNullObserver() {
        //given
        var score = new Score();

        //when

        //then
        assertThrows(NullPointerException.class, () -> score.addObserver(null));
    }

}
