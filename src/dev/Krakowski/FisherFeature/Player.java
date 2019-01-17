package dev.Krakowski.FisherFeature;

import dev.Krakowski.FisherFeauture.gfx.Assets;

import java.awt.image.BufferedImage;

public class Player {
    public static BufferedImage playerImage;
    public static void init() {
        if (KeyPress.isLeftPosition) {
            playerImage = Assets.playerLeft;
            if (KeyPress.isLeftAction) {
                playerImage = Assets.playerLeftAction;
                KeyPress.isLeftAction = false;
            }
        }
        if (!KeyPress.isLeftPosition) {
            playerImage = Assets.playerRight;
            if (KeyPress.isRightAction) {
                playerImage = Assets.playerRightAction;
                KeyPress.isRightAction = false;
            }
        }
    }
}
