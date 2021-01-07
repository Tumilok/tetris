package com.epam.prejap.tetris.game;

import java.util.concurrent.TimeUnit;

/**
 * The Waiter class is responsible for waiting some given time
 * till the next render.
 *
 * @implNote It gets {@link #milliseconds} filed as a constructor argument
 */

public class Waiter {

    private int milliseconds;

    public Waiter(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public void waitForIt() {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException ignore) {
        }
    }

    public void decreaseWaitingTime() {
        if (haveEnoughTime()) {
            milliseconds -= 100;
        }
    }

    private boolean haveEnoughTime() {
        return milliseconds - 100 > 0;
    }

    public int milliseconds() {
        return milliseconds;
    }
}