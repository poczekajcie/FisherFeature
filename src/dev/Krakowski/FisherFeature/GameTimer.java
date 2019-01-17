package dev.Krakowski.FisherFeature;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    public static int secondsLeft = 45;
    public static Timer myTimer = new Timer();
    public static TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsLeft--;
            if (secondsLeft==-100) {
                Game.running = false;
                myTimer.cancel();
            }
        }
    };
}
