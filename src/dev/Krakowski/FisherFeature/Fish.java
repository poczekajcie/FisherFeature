package dev.Krakowski.FisherFeature;

import dev.Krakowski.FisherFeauture.gfx.Assets;

import java.awt.image.BufferedImage;

public class Fish {
    private int fishMove, side;
    private boolean access;
    private BufferedImage fishImage;
    public Fish() { fishImage = Assets.fish; fishMove=0; side=0; }
    public Fish (int fishMove, int side, BufferedImage fishImage) {
        this.fishImage = fishImage;
        this.fishMove = fishMove;
        this.side = side;
        access = true;
    }

    public int getFishMove() { return fishMove; }
    public int getFishSide() { return side; }
    public BufferedImage getFishImage() { return fishImage; }
    public boolean checkAccess() { return access; }

    public void setFishMove(int fishMove) {
        this.fishMove = fishMove;
    }
    public void setFishSide(int side) {
        this.side = side;
    }
    public void setFishImage(BufferedImage fishImage) {
        this.fishImage = fishImage;
    }
    public void setAccess(boolean acces) {
        this.access = acces;
    }
}

