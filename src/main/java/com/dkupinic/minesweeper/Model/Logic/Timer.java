package com.dkupinic.minesweeper.Model.Logic;

import com.dkupinic.minesweeper.Controller.MinesweeperController;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;

import java.util.Date;

public class Timer {
    private float timePlayed = 0;
    private long lastFrame = -1;
    public static boolean activeTimer;

    public void startTimer(MinesweeperController controller) {
        activeTimer = true;
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (lastFrame != -1) {
                    timePlayed += (new Date().getTime() - lastFrame) / 1000.0;
                }
                lastFrame = new Date().getTime();
                Platform.runLater(() -> controller.setTimerLabel(String.format("%.2fs", timePlayed)));
            }
        };
        animationTimer.start();
    }
}