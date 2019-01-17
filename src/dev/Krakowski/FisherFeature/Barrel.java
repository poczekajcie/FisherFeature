package dev.Krakowski.FisherFeature;

import dev.Krakowski.FisherFeauture.gfx.Assets;

import java.awt.image.BufferedImage;

public class Barrel {
    public static BufferedImage barrel;
    public static void init() {
        barrel = Assets.emptyBarrel;
        if (Game.points > 5) {
            barrel = Assets.smallBarrel;
        }
        if (Game.points > 10) {
            barrel = Assets.moreBarrel;
        }
        if (Game.points > 15) {
            barrel = Assets.moremoreBarrel;
        }
        if (Game.points > 20) {
            barrel = Assets.bigBarrel;
        }
    }
}
