package dev.Krakowski.FisherFeature;

import dev.Krakowski.FisherFeauture.display.*;
import dev.Krakowski.FisherFeauture.gfx.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

import java.util.concurrent.ThreadLocalRandom;

public class Game implements Runnable{

    private Display display;
    public int width, height;
    public String title;

    public static boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private KeyPress keyManager;

    private int riverMove;
        //Random values for speed of objects
        private int randSpeed[] = new int[4];

    public static int points;

    //Game constructor
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyPress();
    }

    //Initialize thread
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        ObjectsPosition.init();
        //Set timer
        GameTimer.myTimer.scheduleAtFixedRate(GameTimer.task, 1000, 1000);
        //Random speed of objects
        for (int i=0; i<randSpeed.length; i++) {
            randSpeed[i] = ThreadLocalRandom.current().nextInt(2, 5);
        }
    }

    //Refresh values and positions
    private void tick() {
        riverMove+=1;
        if (riverMove > 640) {
            riverMove=0;
        }
        for (int i=0; i<ObjectsPosition.tableOfFish.length; i++) {
            ObjectsPosition.tableOfFish[i].setFishMove(ObjectsPosition.tableOfFish[i].getFishMove()+randSpeed[i]);
            //If object left the window he will be set again on starting position
            if (ObjectsPosition.tableOfFish[i].getFishMove() > 640) {
                ObjectsPosition.tableOfFish[i].setFishMove(ThreadLocalRandom.current().nextInt(-600, 0));
                ObjectsPosition.tableOfFish[i].setFishSide(ThreadLocalRandom.current().nextInt(135, 210));
                //If object was catch but it appears again then can be catch
                if (ObjectsPosition.tableOfFish[i].getFishImage()==null) {
                    ObjectsPosition.tableOfFish[i].setFishImage(Assets.fish);
                    ObjectsPosition.tableOfFish[i].setAccess(true);
                }
            }
        }
        for (int i=0; i<ObjectsPosition.tableOfTrash.length; i++) {
            ObjectsPosition.tableOfTrash[i].setTrashMove(ObjectsPosition.tableOfTrash[i].getTrashMove()+randSpeed[i]);
            if (ObjectsPosition.tableOfTrash[i].getTrashMove() > 640) {
                ObjectsPosition.tableOfTrash[i].setTrashMove(ThreadLocalRandom.current().nextInt(-600, 0));
                ObjectsPosition.tableOfTrash[i].setTrashSide(ThreadLocalRandom.current().nextInt(135, 210));
                if (ObjectsPosition.tableOfTrash[i].getTrashImage()==null) {
                    ObjectsPosition.tableOfTrash[i].setTrashImage(Assets.trash);
                    ObjectsPosition.tableOfTrash[i].setAccess(true);
                }
            }
        }
    }

    //Render the graphics
    private void render() {
        Player.init();
        Barrel.init();


        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        g.clearRect(0,0, width, height);

        g.drawImage(Assets.backgroundImage, 0, 0, null );
        g.drawImage(Barrel.barrel, 310, 190, null);
        g.drawImage(Assets.kidsImg, 290, 250, null);
        g.drawImage(Assets.river, 133, riverMove, null);
        g.drawImage(Assets.river, 133, riverMove-640, null);

        for (int i=0; i<ObjectsPosition.tableOfFish.length; i++) {
            g.drawImage(ObjectsPosition.tableOfFish[i].getFishImage(), ObjectsPosition.tableOfFish[i].getFishSide(), ObjectsPosition.tableOfFish[i].getFishMove(), null);
        }
        for (int i=0; i<ObjectsPosition.tableOfTrash.length; i++) {
            g.drawImage(ObjectsPosition.tableOfTrash[i].getTrashImage(), ObjectsPosition.tableOfTrash[i].getTrashSide(), ObjectsPosition.tableOfTrash[i].getTrashMove(), null);
        }

        g.drawImage(Assets.timerImg,90,0,null);
        g.drawImage(Assets.clockImg, 125, 18, null);
        g.drawImage(Assets.fishPointsImage, 230, 25, null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(Color.white);
        g.drawString(String.valueOf(GameTimer.secondsLeft), 175, 50);
        g.drawString(String.valueOf(points), 260, 50);

        g.drawImage(Player.playerImage, 0, 0, null);

        if (GameTimer.secondsLeft==0 || GameTimer.secondsLeft<0) {
            g.drawImage(Assets.endingBackground, 0, 0, null);
            g.drawString(String.valueOf(points), 200, 370);
            GameTimer.secondsLeft=-100;
        }

        bs.show();
        g.dispose();
    }


    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            if (delta >= 1){
                tick();
                render();
                delta--;
            }
        }
        stop();
    }


    public synchronized  void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }


    public synchronized  void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
