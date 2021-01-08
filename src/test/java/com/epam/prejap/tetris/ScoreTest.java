package com.epam.prejap.tetris;

import com.epam.prejap.tetris.game.Waiter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

@Test(groups = "Score")
public class ScoreTest {

    @Test
    public void shallIncreaseScore() {
        //given
        Waiter waiter = new Waiter(0);
        Score score = new Score(waiter);
        score.handleScore();
        int expectedPoints = 1;

        //when
        int actualPoints = score.points();

        //then
        assertEquals(actualPoints, expectedPoints);
    }

    @Test
    public void shallThrowNullPointerExceptionReceivingNullArgumentInConstructor() {
        assertThrows(NullPointerException.class, () -> new Score(null));
    }

}
