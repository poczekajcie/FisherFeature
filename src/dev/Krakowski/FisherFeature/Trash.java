package dev.Krakowski.FisherFeature;

import dev.Krakowski.FisherFeauture.gfx.Assets;

import java.awt.image.BufferedImage;

public class Trash {
    private int trashMove, side;
    private boolean access;
    private BufferedImage trashImage;
    public Trash() { trashImage = Assets.trash; trashMove=0; side=0; }
    public Trash (int trashMove, int side, BufferedImage trashImage) {
        this.trashImage = trashImage;
        this.trashMove = trashMove;
        this.side = side;
        access = true;
    }

    public int getTrashMove() { return trashMove; }
    public int getTrashSide() { return side; }
    public BufferedImage getTrashImage() { return trashImage; }
    public boolean checkAccess() { return access; }

    public void setTrashMove(int trashMove) {
        this.trashMove = trashMove;
    }
    public void setTrashSide(int side) {
        this.side = side;
    }
    public void setTrashImage(BufferedImage trashImage) {
        this.trashImage = trashImage;
    }
    public void setAccess(boolean acces) {
        this.access = acces;
    }
}
