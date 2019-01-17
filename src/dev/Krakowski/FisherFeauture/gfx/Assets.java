package dev.Krakowski.FisherFeauture.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage playerRight, playerLeft, playerRightAction, playerLeftAction, backgroundImage, river, fish, trash, timerImg, clockImg, fishPointsImage, endingBackground, kidsImg, emptyBarrel, smallBarrel, moreBarrel, moremoreBarrel, bigBarrel;
    public static void init() {
        playerLeft = ImageLoader.loadImage("/textures/playerLeft.png");
        playerRight = ImageLoader.loadImage("/textures/playerRight.png");
        playerRightAction = ImageLoader.loadImage("/textures/playerRightAction.png");
        playerLeftAction = ImageLoader.loadImage("/textures/playerLeftAction.png");
        backgroundImage = ImageLoader.loadImage("/textures/backgroundImage.png");
        river = ImageLoader.loadImage("/textures/river.png");
        fish = ImageLoader.loadImage("/textures/fish.png");
        trash = ImageLoader.loadImage("/textures/trash.png");
        timerImg = ImageLoader.loadImage("/textures/timerImage.png");
        clockImg = ImageLoader.loadImage("/textures/clockImage.png");
        fishPointsImage = ImageLoader.loadImage("/textures/fishPointsImage.png");
        endingBackground = ImageLoader.loadImage("/textures/ending.png");
        kidsImg = ImageLoader.loadImage("/textures/kidsImg.png");
        emptyBarrel =  ImageLoader.loadImage("/textures/barrels/emptyBarrel.png");
        smallBarrel = ImageLoader.loadImage("/textures/barrels/smallBarrel.png");
        moreBarrel = ImageLoader.loadImage("/textures/barrels/moreBarrel.png");
        moremoreBarrel = ImageLoader.loadImage("/textures/barrels/moremoreBarrel.png");
        bigBarrel = ImageLoader.loadImage("/textures/barrels/bigBarrel.png");

    }
}
